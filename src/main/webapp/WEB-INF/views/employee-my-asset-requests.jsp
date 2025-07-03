<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My New Asset Requests</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="employee-navbar.jsp" %>

<div class="container mt-4">
    <h3 class="text-center mb-4">Asset Requests by ${employee.name}</h3>

    <c:if test="${not empty requests}">
        <table class="table table-bordered table-hover">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Category</th>
                    <th>Asset (if any)</th>
                    <th>Description</th>
                    <th>Reason</th>
                    <th>Status</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="req" items="${requests}">
                    <tr>
                        <td>${req.id}</td>
                        <td>${req.requestedCategory.categoryName}</td>
                        <td>
                            <c:choose>
                                <c:when test="${not empty req.asset}">
                                    ${req.asset.assetName}
                                </c:when>
                                <c:otherwise>
                                    <em>Not linked</em>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${req.description}</td>
                        <td>${req.requestReason}</td>
                        <td>
                            <span class="badge bg-info text-dark">${req.status}</span>
                        </td>
                        <td>${req.requestDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty requests}">
    <h1>${msg}</h1>
        <div class="alert alert-info text-center">No asset requests submitted yet.</div>
    </c:if>
</div>

</body>
</html>
