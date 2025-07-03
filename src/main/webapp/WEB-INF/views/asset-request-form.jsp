<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Request New Asset</title>
    <%@ include file="head.jsp" %> <!-- Bootstrap + custom CSS -->
</head>
<body>
<%@ include file="employee-navbar.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4 text-center">Request New Asset</h2>

    <!-- Flash message -->
    <c:if test="${not empty msg}">
        <div class="alert alert-info">${msg}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/employee/submit-asset-request" method="post">
        <!-- Optional: Asset ID (if coming from asset detail page) -->
        <c:if test="${not empty asset}">
            <input type="hidden" name="assetId" value="${asset.id}" />
            <input type="hidden" name="categoryId" value="${asset.category.id}" />
            <div class="mb-3">
                <label class="form-label">Asset Name</label>
                <input type="text" class="form-control" value="${asset.assetName}" disabled>
            </div>
        </c:if>

        <!-- Category selection (if not coming from asset) -->
        <c:if test="${empty asset}">
            <div class="mb-3">
                <label for="categoryId" class="form-label">Category</label>
                <select name="categoryId" id="categoryId" class="form-select" required>
                    <option value="">-- Select Category --</option>
                    <c:forEach var="cat" items="${categories}">
                        <option value="${cat.id}">${cat.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
        </c:if>

        <div class="mb-3">
            <label for="description" class="form-label">Asset Description</label>
            <textarea id="description" name="description" rows="3" class="form-control" placeholder="Enter asset description" required></textarea>
        </div>

        <div class="mb-3">
            <label for="requestReason" class="form-label">Justification / Request Reason</label>
            <textarea id="requestReason" name="requestReason" rows="3" class="form-control" placeholder="Why do you need this asset?" required></textarea>
        </div>
<div class="d-flex">
    <button type="submit" class="btn btn-primary me-2">Submit Request</button>
    <a href="/employee/dashboard" class="btn btn-secondary">Cancel</a>
</div>

    </form>
</div>

</body>
</html>
