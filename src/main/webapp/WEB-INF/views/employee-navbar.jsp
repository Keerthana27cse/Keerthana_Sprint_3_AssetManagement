<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/employee/dashboard">AssetManagement</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#employeeNavbar" aria-controls="employeeNavbar" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="employeeNavbar">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link" href="/user/login">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="/employee/assets">View Assets</a></li>
        <li class="nav-item"><a class="nav-link" href="employee/request-new">Request Asset</a></li>
        <li class="nav-item"><a class="nav-link" href="employee/request-new">My Requests</a></li>
        <li class="nav-item"><a class="nav-link" href="employee/request-service">Service Request</a></li>
        <li class="nav-item"><a class="nav-link" href="employee/request-service">Audit Request</a></li>
        
        
      </ul>

      <ul class="navbar-nav ms-auto">
        <li class="nav-item"><a class="nav-link" href="/user/logout"><i class="bi bi-box-arrow-right"></i> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
