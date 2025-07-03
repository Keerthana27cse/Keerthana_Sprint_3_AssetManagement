<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<%@ include file="../head.jsp" %>
</head>
<body> 
<%@ include file= "../admin-navbar.jsp" %>

<div class="container mt-5">
    <h3 class="text-center">Asset Allocation Summary</h3>

    <div class="card text-white bg-primary mb-4">
        <div class="card-body text-center">
            <h4 class="card-title">Total Allocated Assets</h4>
            <h2 class="display-6">${totalAllocated}</h2>
        </div>
    </div>

    <h4 class="mb-3">Allocated Asset Details</h4>
    <table class="table table-bordered table-hover">
        <thead class="table-light">
            <tr>
                <th>#</th>
                <th>Employee</th>
                <th>Asset Name</th>
                <th>Category</th>
                <th>Request Date</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="req" items="${allocatedRequests}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${req.employee.name}</td>
                    <td>${req.asset.assetName}</td>
                    <td>${req.requestedCategory.categoryName}</td>
                    <td>${req.requestDate}</td>
                    <td>${req.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
