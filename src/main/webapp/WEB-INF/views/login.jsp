<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="navbar.jsp"%>

<div class="container mt-5">
<div class="row justify-content-center">
<div class="col-sm-6">
<h3 class ="text-center mb-4"><b>Login to Asset Management</b></h3>
<form action="/user/logincheck" method="post">
        <div class="mb-3">
            <input type="email" value = "${emp.email}" class="form-control" name="email" placeholder="Email" required />
        </div>
        <div class="mb-3">
            <input type="password" value="${emp.password}"class="form-control" name="password" placeholder="Password" required />
        </div>
        <div class="mb-3">
            <select class="form-control" name="userrole" required>
                <option value="">Select Role</option>
                <option value="ADMIN">ADMIN</option>
                <option value="EMPLOYEE">EMPLOYEE</option>
            </select>
        </div>
        
        <div class="mb-3 text-center">
            <button type="submit" class="btn btn-primary">Sign In</button>
            <button type="reset" class="btn btn-danger ms-2">Reset</button>
        </div>
    <div class="text-danger text-center">
   <c:if test="${not empty msg}">
        ${msg}
   </c:if>
</div>
    </form>
    <p>Don't have an account? <a href="register">Register here</a> (for Employees only)</p>
    
</div>
</div>
</div>
</body>
</html>
