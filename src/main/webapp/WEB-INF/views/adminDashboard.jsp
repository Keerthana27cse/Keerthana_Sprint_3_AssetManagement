<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="admin-navbar.jsp" %>

<div class="container mt-5">
    <div class="text-center mb-4">
        <p class="text-muted">Here’s a quick overview of the system</p>
    </div>

    <div class="row g-4">
        <!-- Manage Employees -->
        <div class="col-md-4">
            <div class="card text-white bg-success h-100">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title">Manage Employees</h5>
                    <p class="card-text">View and manage employee details.</p>
                    <a href="/admin/EmployeeList" class="btn btn-light mt-auto">Go</a>
                </div>
            </div>
        </div>

        <!-- Asset Categories -->
        <div class="col-md-4">
            <div class="card text-white bg-info h-100">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title">Asset Categories</h5>
                    <p class="card-text">Organize assets by category.</p>
                    <a href="/admin/categories" class="btn btn-light mt-auto">Go</a>
                </div>
            </div>
        </div>

        <!-- Manage Assets -->
        <div class="col-md-4">
            <div class="card text-white bg-primary h-100">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title">Manage Assets</h5>
                    <p class="card-text">View, add, update or delete assets.</p>
                    <a href="/admin/assetCatalogue" class="btn btn-light mt-auto">Go</a>
                </div>
            </div>
        </div>

        <!-- Asset Requests -->
        <div class="col-md-4">
            <div class="card text-white bg-warning h-100">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title">Asset Requests</h5>
                    <p class="card-text">Review and approve employee asset requests.</p>
                    <a href="/admin/asset-requests" class="btn btn-light mt-auto">Go</a>
                </div>
            </div>
        </div>

        <!-- Asset Allocation -->
        <div class="col-md-4">
            <div class="card text-white bg-dark h-100">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title">Asset Allocation</h5>
                    <p class="card-text">Assign assets to employees.</p>
                    <a href="/admin/viewallocatedAsset" class="btn btn-light mt-auto">Go</a>
                </div>
            </div>
        </div>

        <!-- Audit Asset -->
        <div class="col-md-4">
            <div class="card text-white bg-secondary h-100">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title">Audit Asset</h5>
                    <p class="card-text">Auditing the assets.</p>
                    <a href="/admin/auditAsset" class="btn btn-light mt-auto">Go</a>
                </div>
            </div>
        </div>

        <!-- Service Requests -->
        <div class="col-md-4">
            <div class="card text-white bg-danger h-100">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title">Service Requests</h5>
                    <p class="card-text">Review and approve employee service requests.</p>
                    <a href="/admin/service-requests" class="btn btn-light mt-auto">Go</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
