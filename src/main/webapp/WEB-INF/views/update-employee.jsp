<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="head.jsp" %>
    <title>Update Employee</title>
</head>
<body>
    <%@ include file="admin-navbar.jsp" %>

    <div class="container mt-5">
        <div class="card p-4">
            <h3 class="mb-4 text-center">Update Employee</h3>

            <form action="/admin/update" method="post">
                <input type="hidden" name="id" value="${updateUser.id}" />
                <div class="mb-3">
                    <label>Name:</label>
                    <input type="text" name="name" class="form-control" value="${updateUser.name}" required />
                </div>
                

                <div class="mb-3">
                    <label>UserName:</label>
                    <input type="text" name="username" class="form-control" value="${updateUser.username}" required />
                </div>

                <div class="mb-3">
                    <label>Email:</label>
                    <input type="email" name="email" class="form-control" value="${updateUser.email}" required />
                </div>

                <div class="mb-3">
                    <label>Contact:</label>
                    <input type="text" name="contactNumber" class="form-control" value="${updateUser.contactNumber}" required />
                </div>

                <div class="mb-3">
                    <label>Address:</label>
                    <textarea name="address" class="form-control">${updateUser.address}</textarea>
                </div>
                
				 <div class="mb-3">
				    <label>Status:</label><br>
				    <input type="radio" name="empstatus" value="ACTIVE"
				        <c:if test="${updateUser.empstatus eq 'ACTIVE'}">checked</c:if>> Active
				
				    <input type="radio" name="empstatus" value="INACTIVE"
				        <c:if test="${updateUser.empstatus eq 'INACTIVE'}">checked</c:if>> Inactive
				</div>
				               
                

                <div class="mb-3">
                    <label>Gender:</label><br>
                    <c:choose>
                        <c:when test="${updateUser.gender eq 'MALE'}">
                            <input type="radio" name="gender" value="MALE" checked> Male
                            <input type="radio" name="gender" value="FEMALE"> Female
                        </c:when>
                        <c:when test="${updateUser.gender eq 'FEMALE'}">
                            <input type="radio" name="gender" value="MALE"> Male
                            <input type="radio" name="gender" value="FEMALE" checked> Female
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="gender" value="MALE"> Male
                            <input type="radio" name="gender" value="FEMALE"> Female
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Update</button>
                    <a href="/admin/EmployeeList" class="btn btn-secondary ms-2">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
