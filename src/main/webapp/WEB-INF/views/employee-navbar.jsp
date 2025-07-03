<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/user/login">AssetManagement</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#employeeNavbar" aria-controls="employeeNavbar" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="employeeNavbar">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link" href="/employee/dashboard">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="/employee/assets">View Assets</a></li>
        <li class="nav-item"><a class="nav-link" href="/employee/my-asset-requests">My Requests</a></li>
        <li class="nav-item"><a class="nav-link" href="/employee/my-service-requests">My Service Request</a></li>
        <li class="nav-item"><a class="nav-link" href="/employee/auditRequests">Audit Request</a></li>
            <li class="nav-item"><a class="nav-link" href="/employee/auditRequests">My Assetst</a></li>
    
        
      </ul>

      <ul class="navbar-nav ms-auto">
        <li class="nav-item"><a class="nav-link" href="/user/logout"><i class="bi bi-box-arrow-right"></i> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
