<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Service Requests</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="admin-navbar.jsp" %>

<div class="container mt-4">
    <h3 class="text-center mb-4">All Service Requests</h3>

    <c:if test="${not empty msg}">
        <div class="alert alert-success">${msg}</div>
    </c:if>

    <c:if test="${not empty requests}">
        <table class="table table-bordered table-hover">
            <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Employee</th>
                    <th>Asset</th>
                    <th>Issue Type</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Requested On</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="req" items="${requests}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${req.employee.name}</td>
                        <td>${req.asset.assetName}</td>
                        <td>${req.issueType}</td>
                        <td>${req.description}</td>
                        <td><span class="badge bg-secondary">${req.status}</span></td>
                        <td>${req.requestDate}</td>
                        <td>
                            <c:choose>
                                <c:when test="${req.status == 'PENDING'}">
                                    <a href="/admin/service/approve?id=${req.id}" class="btn btn-success btn-sm">Approve</a>
                                    <a href="/admin/service/reject?id=${req.id}" class="btn btn-danger btn-sm">Reject</a>
                                </c:when>
                                <c:when test="${req.status == 'APPROVED'}">
                                    <a href="/admin/service/resolve?id=${req.id}" class="btn btn-warning btn-sm">Mark Resolved</a>
                                </c:when>
                                <c:when test="${req.status == 'RESOLVED'}">
                                    <a href="/admin/service/verify?id=${req.id}" class="btn btn-info btn-sm">Verify</a>
                                </c:when>
                                <c:otherwise>
                                    <span class="text-muted">No action</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty requests}">
        <div class="alert alert-info text-center">No service requests found.</div>
    </c:if>
</div>

</body>
</html>
