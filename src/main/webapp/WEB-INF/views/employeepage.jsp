<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Employee Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
  <style>
    .nav-link {
      display: flex;
      align-items: center;
    }
    .nav-link i {
      margin-right: 6px;
    }
    .navbar-brand {
      font-weight: bold;
      font-size: 1.3rem;
    }
  </style>
</head>
<body>

<!-- Employee Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="/employee/assets">
      <i class="bi bi-boxes"></i> AssetManagement
    </a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#employeeNavbar"
      aria-controls="employeeNavbar" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="employeeNavbar">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="/employee/assets"><i class="bi bi-house-door"></i> Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/employee/assets"><i class="bi bi-laptop"></i> View Assets</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/employee/request-new"><i class="bi bi-plus-square"></i> Request Asset</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/employee/employee-my-asset-requests"><i class="bi bi-list-check"></i> My Requests</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/employee/request-service"><i class="bi bi-tools"></i> Service Request</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/employee/request-audit"><i class="bi bi-search"></i> Audit Request</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/employee/request-audit"><i class="bi bi-search"></i> My assets /a>
        </li>
      </ul>

      <ul class="navbar-nav ms-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="profileDropdown" role="button" data-bs-toggle="dropdown">
            <i class="bi bi-person-circle"></i> ${loggedInUser.username}
          </a>
          <ul class="dropdown-menu dropdown-menu-end">
            <li><a class="dropdown-item" href="/settings"><i class="bi bi-gear"></i> Settings</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/user/logout"><i class="bi bi-box-arrow-right"></i> Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Optional spacing below fixed navbar -->
<div style="height: 70px;"></div>

<!-- Bootstrap Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
