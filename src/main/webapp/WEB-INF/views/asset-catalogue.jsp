<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Asset Catalogue</title>
    <%@ include file="head.jsp" %>
</head>
<body class="bg-light">
<%@ include file="admin-navbar.jsp"%>

<div class="container mt-5">
    <h2 class="fw-bold text-center mb-4">Asset Catalogue</h2>

    <!-- Asset Form -->
    <div class="card mb-4">
        <div class="card-header bg-success text-white">
            <c:choose>
                <c:when test="${not empty asset.id}">Edit Asset</c:when>
                <c:otherwise>Add Asset</c:otherwise>
            </c:choose>
        </div>
        <div class="card-body">
            <form action="/admin/saveAsset" method="post">
                <input type="hidden" name="id" value="${asset.id}" />

                <div class="mb-3">
                    <label class="form-label">Asset No</label>
                    <input type="text" name="assetNo" class="form-control" value="${asset.assetNo}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Asset Name</label>
                    <input type="text" name="assetName" class="form-control" value="${asset.assetName}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Asset Model</label>
                    <input type="text" name="assetModel" class="form-control" value="${asset.assetModel}">
                </div>

                <div class="mb-3">
                    <label class="form-label">Manufacturing Date</label>
                    <input type="date" name="manufacturingDate" class="form-control" value="${asset.manufacturingDate}">
                </div>

                <div class="mb-3">
                    <label class="form-label">Expiry Date</label>
                    <input type="date" name="expiryDate" class="form-control" value="${asset.expiryDate}">
                </div>

                <div class="mb-3">
                    <label class="form-label">Asset Value</label>
                    <div class="input-group">
                        <span class="input-group-text">₹</span>
                        <input type="number" name="assetValue" value="${asset.assetValue}" min="0" step="0.01" class="form-control" placeholder="Amount" />
                    </div>
                </div>

                <div class="mb-3">
                    <label class="form-label">Asset Status</label>
                    <select name="assetStatus" class="form-select" required>
                        <option value="">-- Select Status --</option>
                        <option value="AVAILABLE" ${asset.assetStatus != null && asset.assetStatus.name() == 'AVAILABLE' ? 'selected' : ''}>Available</option>
                        <option value="ALLOCATED" ${asset.assetStatus != null && asset.assetStatus.name() == 'ALLOCATED' ? 'selected' : ''}>Allocated</option>
                        <option value="UNDER_MAINTENANCE" ${asset.assetStatus != null && asset.assetStatus.name() == 'UNDER_MAINTENANCE' ? 'selected' : ''}>Under Maintenance</option>
                        <option value="RETURNED" ${asset.assetStatus != null && asset.assetStatus.name() == 'RETURNED' ? 'selected' : ''}>Returned</option>
                        <option value="DISCARDED" ${asset.assetStatus != null && asset.assetStatus.name() == 'DISCARDED' ? 'selected' : ''}>Discarded</option>
                        <option value="IN_USE" ${asset.assetStatus != null && asset.assetStatus.name() == 'IN_USE' ? 'selected' : ''}>In Use</option>
                        <option value="DAMAGED" ${asset.assetStatus != null && asset.assetStatus.name() == 'DAMAGED' ? 'selected' : ''}>Damaged</option>
                        <option value="IN_MAINTENANCE" ${asset.assetStatus != null && asset.assetStatus.name() == 'IN_MAINTENANCE' ? 'selected' : ''}>In Maintenance</option>
                        <option value="WORKING" ${asset.assetStatus != null && asset.assetStatus.name() == 'WORKING' ? 'selected' : ''}>Working</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Category</label>
                    <select name="category.id" class="form-select" required>
                        <option value="">-- Select Category --</option>
                        <c:forEach var="cat" items="${categories}">
                            <option value="${cat.id}" <c:if test="${asset.category.id == cat.id}">selected</c:if>>${cat.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="text-end">
                    <button type="submit" class="btn btn-success">
                        <c:choose>
                            <c:when test="${not empty asset.id}">Update</c:when>
                            <c:otherwise>Save</c:otherwise>
                        </c:choose>
                    </button>
                </div>
            </form>
        </div>
    </div>
    <form action="/admin/filterAssets" method="get" class="mb-3">
  <div class="row g-2 align-items-center">
    <div class="col-md-3">
      <select name="categoryId" class="form-select" onchange="this.form.submit()">
        <option value="0">-- All Categories --</option>
        <c:forEach var="cat" items="${categories}">
          <option value="${cat.id}" <c:if test="${selectedCategoryId == cat.id}">selected</c:if>>
            ${cat.categoryName}
          </option>
        </c:forEach>
      </select>
    </div>
  </div>
</form>

<div class="table-responsive">
    <table class="table table-bordered table-striped text-center align-middle">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Asset No</th>
                <th>Asset Name</th>
                <th>Model</th>
                <th>Manufactured</th>
                <th>Expiry</th>
                <th>Value</th>
                <th>Status</th>
                <th>Category</th>
                <th>CreatedAt</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="asset" items="${assets}">
                <tr>
                    <td>${asset.id}</td>
                    <td>${asset.assetNo}</td>
                    <td>${asset.assetName}</td>
                    <td>${asset.assetModel}</td>
                    <td>${asset.manufacturingDate}</td>
                    <td>${asset.expiryDate}</td>
                    <td>${asset.assetValue}</td>
                    <td>${asset.assetStatus}</td>
                    <td>${asset.category.categoryName}</td>
                    <td>${asset.createdAt}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/editAsset?id=${asset.id}" class="btn btn-sm btn-warning">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/deleteAsset?id=${asset.id}" class="btn btn-sm btn-danger" onclick="return confirm('Delete this asset?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty assets}">
                <tr>
                   <td colspan="11" class="text-muted text-center">No assets found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>
</body>
</html>
