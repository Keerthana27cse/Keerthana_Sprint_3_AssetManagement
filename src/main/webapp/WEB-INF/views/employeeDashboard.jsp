<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Dashboard</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="employee-navbar.jsp" %>

<div class="container mt-4">
    <h2 class="fw-bold text-center mb-4">Welcome to Employee Dashboard</h2>

    <!-- Filter/Search -->
    <form method="get" action="/employee/assets" class="row g-3 mb-4">
        <div class="col-md-4">
            <select class="form-select" name="category">
                <option value="">All Categories</option>
                <c:forEach var="cat" items="${categories}">
                <option value="${cat.id}" <c:if test="${selectedCategoryId==cat.id}">selected</c:if>>${cat.categoryName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-5">
            <input type="text" name="search" placeholder="Search assets..." class="form-control">
        </div>
        <div class="col-md-3">
            <button class="btn btn-primary w-100">Search</button>
        </div>
    </form>

    <!-- Asset Cards -->
    <div class="row">
        <c:forEach var="asset" items="${assets}">
            <div class="col-md-4 mb-4">
                <div class="card h-100 shadow">
                    <img src="${asset.imageUrl}" class="card-img-top" style="height: 200px; object-fit: cover;">
                    <div class="card-body">
                        <h5 class="card-title">${asset.assetName}</h5>
                        <p class="card-text">Model: ${asset.assetModel}</p>
                        <p>Status: <span class="badge bg-info text-dark">${asset.assetStatus}</span></p>
                        <p><strong>₹${asset.assetValue}</strong></p>
                        <a href="/employee/asset/${asset.id}" class="btn btn-outline-primary w-100">View Details</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <hr class="my-5">

    <div class="d-flex justify-content-between">
        <a href="/employee/request-new" class="btn btn-success btn-lg">+ Request New Asset</a>
        <a href="/employee/request-service" class="btn btn-warning btn-lg">⚙ Raise Service Request</a>
    </div>
</div>

</body>
</html>
