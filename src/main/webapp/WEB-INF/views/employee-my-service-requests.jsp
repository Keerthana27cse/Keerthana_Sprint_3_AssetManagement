<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Service Requests</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="employee-navbar.jsp" %>

<div class="container mt-4">
    <h3 class="text-center mb-4">My Service Requests</h3>

    <c:if test="${not empty requests}">
        <table class="table table-bordered table-hover">
            <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Asset Name</th>
                    <th>Asset No</th>
                    <th>Issue Type</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Requested On</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="req" items="${requests}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${req.asset.assetName}</td>
                        <td>${req.asset.assetNo}</td>
                        <td>${req.issueType}</td>
                        <td>${req.description}</td>
                        <td><span class="badge bg-secondary">${req.status}</span></td>
                        <td>${req.requestDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty requests}">
        <h1>${msg}</h1>
    
        <div class="alert alert-info text-center">No service requests found.</div>
    </c:if>
</div>

</body>
</html>
