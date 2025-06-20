<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title>Asset Catalogue</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Browse Assets</h2>

    <form method="get" class="row g-3 mb-3">
        <div class="col-md-4">
            <select class="form-select" name="category">
                <option value="">All Categories</option>
                <c:forEach var="cat" items="${categories}">
                    <option value="${cat.id}">${cat.categoryName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-4">
            <input type="text" class="form-control" name="search" placeholder="Search assets...">
        </div>
        <div class="col-md-4">
            <button type="submit" class="btn btn-primary w-100">Filter</button>
        </div>
    </form>

    <div class="row">
        <c:forEach var="asset" items="${assets}">
            <div class="col-md-4 mb-4">
                <div class="card h-100">
                    <img src="${asset.imageUrl}" class="card-img-top" alt="Asset Image">
                    <div class="card-body">
                        <h5 class="card-title">${asset.assetName}</h5>
                        <p class="card-text">Model: ${asset.assetModel}</p>
                        <p class="card-text">Status: ${asset.assetStatus}</p>
                        <p class="card-text fw-bold">₹${asset.assetValue}</p>
                        <a href="/employee/asset/${asset.id}" class="btn btn-outline-primary w-100">View Details</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
