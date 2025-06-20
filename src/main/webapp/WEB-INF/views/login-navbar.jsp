<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/user/login">AssetManagement</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
      aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" href="/user/login">Home</a>
        </li>
      </ul>

      <ul class="navbar-nav mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="/user/register">
            <i class="bi bi-person-plus-fill"></i> Sign Up
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/user/login">
            <i class="bi bi-box-arrow-in-right"></i> Login
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/user/logout">
            <i class="bi bi-box-arrow-left"></i> Logout
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>
