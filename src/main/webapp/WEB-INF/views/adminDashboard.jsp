<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="head.jsp" %>

</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container mt-5">
<h2 class="text-center mb-4"><b>Welcome ${loggedInUser.getUsername()}</b></h2>
<h3 class="text-center mb-4"><b>View Employee List</b></h3>
<table class="table table-bordered table-striped table-hover text-center">
<thead class="table-dark">
<thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>CONTACT</th>
        <th>ADDRESS</th>
        <th>GENDER</th>
    </tr>
</thead>
<tbody>
    <c:forEach var="emp" items="${EmpDetails}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td>${emp.contactNumber}</td>
            <td>${emp.address}</td>
            <td>${emp.gender}</td>
            <td><a href ="/admin/delete?id=${emp.id}">DELETE</a></td>
        </tr>
    </c:forEach>
</tbody>
</table>
<a href=viewAllocatedAssets>ViewAllocatedAsset</a><br>
<a href=viewRequestedAssets>ViewRequestedAsset</a><br>
<a href=allocateAsset>AllocatedAsset</a><br>
<a href=assetCatalogue>AssetCatalogue</a><br>


</div>
<div class="alert alert-success">${msg}</div>

</body>
</html>


