<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="admin-navbar.jsp"%>

<div class="container mt-5">
    <div class="text-center mb-4">
        <p class="text-muted">Here’s a quick overview of the system</p>
    </div>
        <div class="row mt-4">
        <div class="col-md-4 mb-3">
            <div class="card text-white bg-success h-100">
                <div class="card-body">
                    <h5 class="card-title">Manage Employees</h5>
                    <p class="card-text">View and manage employee details.</p>
                    <a href="/admin/EmployeeList" class="btn btn-light">Go</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <div class="card text-white bg-info h-100">
                <div class="card-body">
                    <h5 class="card-title">Asset Categories</h5>
                    <p class="card-text">Organize assets by category.</p>
                    <a href="/admin/categories" class="btn btn-light">Go</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <div class="card text-white bg-primary h-100">
                <div class="card-body">
                    <h5 class="card-title">Manage Assets</h5>
                    <p class="card-text">View, add, update or delete assets.</p>
                    <a href="/admin/assetCatalogue" class="btn btn-light">Go</a>
                </div>
            </div>
        </div>
        <!--second-->
        <div class="row mb-3">
        <div class="col-md-4 mb-3">
            <div class="card text-white bg-warning h-100">
                <div class="card-body">
                    <h5 class="card-title">Asset Requests</h5>
                    <p class="card-text">Review and approve employee asset requests.</p>
                    <a href="/admin/employee-new-requests" class="btn btn-light">Go</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 mb-3">
                <div class="card text-white bg-dark h-100">
                <div class="card-body">
                    <h5 class="card-title">Asset Allocation</h5>
                    <p class="card-text">Assign assets to employees.</p>
                    <a href="/admin/viewallocatedAsset" class="btn btn-light">Go</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <div class="card text-white bg-secondary h-100">
                <div class="card-body">
                    <h5 class="card-title"> Audit Asset</h5>
                    <p class="card-text">Auditing the assets.</p>
                    <a href="/admin/auditAsset" class="btn btn-light">Go</a>
                </div>
            </div>
        </div>
        </div>
    </div>
    </div>

</body>
</html>