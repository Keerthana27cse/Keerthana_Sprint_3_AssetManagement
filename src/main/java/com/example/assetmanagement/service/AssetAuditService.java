package com.example.assetmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.entity.AssetAllocation;
import com.example.assetmanagement.entity.AssetAudit;
import com.example.assetmanagement.entity.Employee;
import com.example.assetmanagement.enums.AllocationStatus;
import com.example.assetmanagement.enums.RequestStatus;
import com.example.assetmanagement.repository.AssetAllocationRepo;
import com.example.assetmanagement.repository.AssetAuditRepo;
import com.example.assetmanagement.repository.EmployeeRepo;

@Service
public class AssetAuditService {

    @Autowired
    private AssetAuditRepo auditRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AssetAllocationRepo allocationRepo;

    /**
     * ADMIN: Send audit requests to all employees for assets currently in ALLOCATED status
     */
    public void sendAuditRequestToAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();

        for (Employee emp : employees) {
            List<AssetAllocation> allocations = allocationRepo.findByEmployeeId(emp.getId());

            for (AssetAllocation allocation : allocations) {
                if (allocation.getAllocationStatus() == AllocationStatus.ALLOCATED) {
                    Asset asset = allocation.getAsset();

                    // ✅ Prevent duplicate audits for same employee + asset + date
                    boolean auditExists = auditRepo.existsByEmployeeIdAndAssetIdAndAuditDate(
                            emp.getId(), asset.getId(), LocalDate.now());

                    if (!auditExists) {
                        AssetAudit audit = new AssetAudit();
                        audit.setEmployee(emp);
                        audit.setAsset(asset);
                        audit.setStatus(RequestStatus.PENDING);
                        audit.setAuditDate(LocalDate.now());
                        auditRepo.save(audit);
                    }
                }
            }
        }
    }

    /**
     * ADMIN: View all audit requests
     */
    public List<AssetAudit> getAllAuditRequests() {
        return auditRepo.findAll();
    }

    /**
     * ADMIN: Approve or reject an audit request
     */
    public String updateAuditStatus(Long auditId, RequestStatus status) {
        AssetAudit audit = auditRepo.findById(auditId).orElse(null);
        if (audit != null) {
            audit.setStatus(status);
            auditRepo.save(audit);
            return "Audit status updated.";
        }
        return "Audit request not found.";
    }

    /**
     * EMPLOYEE: View audit requests by employee
     */
    public List<AssetAudit> getAuditRequestsByEmployee(Employee employee) {
        return auditRepo.findByEmployeeId(employee.getId());
    }

    /**
     * EMPLOYEE: Submit remarks for an audit
     */
    public String submitAuditRemarks(Long auditId, String remarks) {
        AssetAudit audit = auditRepo.findById(auditId).orElse(null);
        if (audit != null && audit.getStatus() == RequestStatus.PENDING) {
            audit.setRemarks(remarks);
            audit.setStatus(RequestStatus.COMPLETED);
            auditRepo.save(audit);
            return "Audit remarks submitted successfully.";
        }
        return "Audit request not found or already processed.";
    }
}
