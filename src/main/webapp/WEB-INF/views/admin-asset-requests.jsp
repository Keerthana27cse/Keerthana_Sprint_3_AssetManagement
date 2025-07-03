<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Asset Requests</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="admin-navbar.jsp" %>

<div class="container mt-4">
    <h3 class="text-center mb-4">All Employee Asset Requests</h3>

    <c:if test="${not empty requests}">
        <table class="table table-bordered table-hover">
            <thead class="table-dark">
                <tr>
                    <th>S.No</th>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Category</th>
                    <th>Requested Asset</th>
                    <th>Description</th>
                    <th>Reason</th>
                    <th>Status</th>
                    <th>Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="req" items="${requests}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${req.employee.id}</td>
                        <td>${req.employee.name}</td>
                        <td>${req.requestedCategory.categoryName}</td>
							<td>
							    <c:choose>
							        <c:when test="${not empty req.asset}">
							            ${req.asset.assetName}
							        </c:when>
							        <c:otherwise>
							            <em>Not specified</em>
							        </c:otherwise>
							    </c:choose>
							</td>
                        <td>${req.description}</td>
                        <td>${req.requestReason}</td>
                        <td><span class="badge bg-secondary">${req.status}</span></td>
                        <td>${req.requestDate}</td>
                        <td>
                            <c:if test="${req.status == 'PENDING'}">
                                <a href="/admin/approve-request?id=${req.id}" class="btn btn-success btn-sm">Approve</a>
                                <a href="/admin/reject-request?id=${req.id}" class="btn btn-danger btn-sm">Reject</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty requests}">
        <div class="alert alert-info text-center">No asset requests found.</div>
    </c:if>
</div>

</body>
</html>
