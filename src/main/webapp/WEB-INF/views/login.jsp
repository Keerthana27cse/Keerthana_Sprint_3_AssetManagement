<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="head.jsp" %>
    <title>Login | Asset Management</title>
</head>
<body>
<%@ include file="login-navbar.jsp" %>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h3 class="text-center mb-4"><b>Login to Asset Management</b></h3>
          <form action="/user/logincheck" method="post" class="border p-4 rounded shadow">
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" name="email"  value=" ${emp.email}"required />
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" required />
                </div>
                <div class="mb-3">
                    <label for="username" class="form-label">UserName</label>
                    <input type="text" class="form-control" name="username" value=" ${emp.username}"required />
                </div>
                <div class="mb-3">
                    <label for="userrole" class="form-label">Select Role</label>
                <select class="form-select" name="userrole" required>
                    <option value="">Select Role</option>
                    <option value="EMPLOYEE" selected>Employee</option>
                </select>
                                    
                </div>
                <div class="text-center mb-3">
                    <button type="submit" class="btn btn-primary me-2">Sign In</button>
                    <button type="reset" class="btn btn-secondary">Reset</button>
                </div>

                <div class="text-danger text-center">
                    <c:if test="${not empty msg}">
                        ${msg}
                    </c:if>
                </div>
            </form>
           
            <p class="text-center mt-3">Don't have an account? <a href="register">Register here</a></p>
        </div>
    </div>
</div>
</body>
</html>
