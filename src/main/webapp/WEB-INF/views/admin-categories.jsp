<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Asset Categories</title>
    <%@ include file="head.jsp" %>
</head>
<body class="bg-light">
    <%@ include file="admin-navbar.jsp"%>

    <div class="container mt-5">
        <div class="text-center mb-4">
            <h2 class="fw-bold">Asset Category Management</h2>
            <p class="text-muted">Add and manage asset categories</p>
        </div>

        <!-- Display success message -->
        <c:if test="${not empty msg}">
            <div class="alert alert-success text-center">${msg}</div>
        </c:if>
        
  <div class="card shadow mb-4">
    <div class="card-header bg-primary text-white">
        <h5 class="mb-0">
            <c:choose>
                <c:when test="${not empty category.id}">Edit Category</c:when>
                <c:otherwise>Add New Category</c:otherwise>
            </c:choose>
        </h5>
    </div>
    <div class="card-body">
        <form:form action="/admin/saveCategory" method="post" modelAttribute="category">
            <form:hidden path="id" />
            <div class="row g-2 align-items-center">
                <div class="col-md-10">
                    <form:input path="categoryName" class="form-control" placeholder="Enter category name" required="true" />
                </div>
                <div class="col-md-2 text-end">
                    <button type="submit" class="btn btn-success w-100">
                        <c:choose>
                            <c:when test="${not empty category.id}">Update</c:when>
                            <c:otherwise>Add Category</c:otherwise>
                        </c:choose>
                    </button>
                </div>
            </div>
        </form:form>
    </div>
</div>
        <div class="card shadow">
            <div class="card-header bg-dark text-white">Existing Categories</div>
            <div class="card-body p-0">
                <table class="table table-bordered table-striped mb-0 text-center align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>ID</th>
                            <th>Category Name</th> 
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="category" items="${categories}">
                            <tr>
                                <td>${category.id}</td>
                                <td>${category.categoryName}</td>
                                <td>
                                    
                                     <a href="/admin/editCategory?id=${category.id}" class="btn btn-sm btn-warning me-2"
                                       onclick="return confirm('Are you sure you want to update this category?');">Update</a> 
                                      
                                      <a href="/admin/deleteCategory?id=${category.id}" class="btn btn-sm btn-danger"
                                       onclick="return confirm('Are you sure you want to delete this category?');">Delete</a>
                                      
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty categories}">
                            <tr>
                                <td colspan="3" class="text-muted text-center">No categories available.</td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
