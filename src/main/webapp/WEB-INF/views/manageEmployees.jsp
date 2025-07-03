<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="head.jsp" %>
    
    <title>Employee Management</title>
</head>
<body>
    <%@ include file="admin-navbar.jsp"%>

    <div class="container mt-5">
        <div class="text-center mb-4">
            <h2><b>Welcome ${loggedInUser.username}</b></h2>
            <h4 class="text-muted">Manage Employee Records</h4>
        </div>
        <c:if test="${not empty msg}">
            <div class="alert alert-success text-center">${msg}</div>
        </c:if>
       <div class="card">
        <div class="card-body table-responsive">
        <table class="table table-bordered table-hover text-center align-middle">
            <thead class="table-dark">
                <tr>
                   
                    <th>ID</th>
                    <th>UserName</th>
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Address</th>
                    <th>PassWord</th>
                    <th>Gender</th>
                    <th>Status</th>
                    <th>Created</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="emp" items="${EmpDetails}">
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.username}</td>
                        <td>${emp.name}</td>
                        <td>${emp.email}</td>
                        <td>${emp.contactNumber}</td>
                        <td>${emp.address}</td>
                        <td>${emp.password}</td>
                        <td>${emp.gender}</td>
                        <td>${emp.empstatus}</td>  
<td><fmt:formatDate value="${emp.createdAt}" pattern="dd-MM-yyyy HH:mm" /></td>
                                            
                                              
                        <td>
                            <a href="/admin/update?id=${emp.id}" class="btn btn-sm btn-warning me-2"
                                onclick="return confirm('Are you sure you want to Update this employee?');">Update</a>
                            
                            <a href="/admin/delete?id=${emp.id}" class="btn btn-sm btn-danger"
                               onclick="return confirm('Are you sure you want to delete this employee?');"> Delete </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    </div>
    </div>
</body>
</html>
