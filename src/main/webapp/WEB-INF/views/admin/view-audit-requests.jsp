<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Audit Requests - Admin</title>
    <%@ include file="../head.jsp" %>
</head>
<body>
<%@ include file="../admin-navbar.jsp" %>

<div class="container mt-5">
    <h2>Audit Requests Sent to Employees</h2>

    <c:if test="${not empty msg}">
        <div class="alert alert-success">${msg}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/admin/sendAuditRequests" method="post">
        <button type="submit" class="btn btn-primary mb-3">Send Audit Requests to All Employees</button>
    </form>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Audit ID</th>
            <th>Employee ID</th>
            <th>Status</th>
            <th>Remarks</th>
            <th>Requested At</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="audit" items="${audits}">
            <tr>
                <td>${audit.id}</td>
                <td>${audit.employee.id}</td>
                <td>${audit.status}</td>
                <td>${audit.remarks}</td>
                <td>${audit.requestedAt}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
