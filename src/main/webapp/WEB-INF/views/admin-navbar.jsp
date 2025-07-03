<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/user/login">Welcome ${loggedInUser.username}</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#adminNavbar" aria-controls="adminNavbar" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="adminNavbar">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link" href="/admin/dashboard">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="/admin/assetCatalogue">Manage Assets</a></li>
        <li class="nav-item"><a class="nav-link" href="admin-categories">Asset Categories</a></li>
        <li class="nav-item"><a class="nav-link" href="/admin/EmployeeList">Manage Employees</a></li>
        <li class="nav-item"><a class="nav-link" href="/admin/asset-requests">Asset Requests</a></li>
        <li class="nav-item"><a class="nav-link" href="/admin/asset-assignment-summary">Asset Allocation</a></li>
        <li class="nav-item"><a class="nav-link" href="/admin/viewAuditRequests">Asset Audits</a></li>
        <li class="nav-item"><a class="nav-link" href="/admin/service-requests">Service Requests</a></li>
        
        <li class="nav-item"><a class="nav-link" href="/settings">Settings</a></li>
      </ul>
      
      <ul class="navbar-nav ms-auto">
        <li class="nav-item"><a class="nav-link" href="/user/logout"><i class="bi bi-box-arrow-right"></i> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
