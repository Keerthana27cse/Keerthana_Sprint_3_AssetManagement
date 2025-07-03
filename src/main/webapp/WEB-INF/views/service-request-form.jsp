<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">

    <title>Raise Service Request</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="employee-navbar.jsp" %>

<div class="container mt-4">
    <h2 class="mb-4">Raise Service Request</h2>
    
    <c:if test="${not empty msg}">
        <div class="alert alert-info">${msg}</div>
    </c:if>
    <form method="post" action="/employee/submit-service-request">
        <c:if test="${not empty asset}">
            <input type="hidden" name="assetId" value="${asset.id}" />
            <input type="hidden" name="categoryId" value="${asset.category.id}" />
            <div class="mb-3">
                <label class="form-label">Asset Name</label>
                <input type="text" class="form-control" value="${asset.assetName}" disabled>
            </div>
        </c:if>

        <div class="mb-3">
            <label class="form-label">Issue Type</label>
            <select name="issueType" class="form-select" required>
                <option value="">-- Select Issue --</option>
                <option value="HARDWARE">Hardware</option>
                <option value="SOFTWARE">Software</option>
                <option value="NETWORK">Network</option>
                <option value="OTHER">Other</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea name="description" rows="4" class="form-control" required></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Submit Request</button>
            <a href="/employee/dashboard" class="btn btn-secondary">Cancel</a>
        
    </form>
</div>
</body>
</html>
