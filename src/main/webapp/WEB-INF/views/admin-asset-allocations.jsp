<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Asset Allocations</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="admin-navbar.jsp" %>

<div class="container mt-4">
    <h3 class="text-center mb-4">Asset Allocations</h3>

    <c:if test="${not empty allocations}">
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Asset</th>
                    <th>Employee</th>
                    <th>Request Date</th>
                    <th>Allocated On</th>
                    <th>Return Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="alloc" items="${allocations}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${alloc.asset.assetName}</td>
                        <td>${alloc.employee.name}</td>
                        <td>${alloc.requestDate}</td>
                        <td>${alloc.allocationDate}</td>
                        <td><c:out value="${alloc.returnDate != null ? alloc.returnDate : 'Not Returned'}"/></td>
                        <td><span class="badge bg-primary">${alloc.allocationStatus}</span></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty allocations}">
        <div class="alert alert-info text-center">No allocations found.</div>
    </c:if>
</div>

</body>
</html>
