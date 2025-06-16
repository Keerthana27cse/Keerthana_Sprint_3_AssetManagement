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
<h2 class="text-center mb-4"><b>Welcome Employee</b></h2>
<h2 class="text-center mb-4"><b>${loggedInUser.getEmail()}</b></h2>

<a href=requestAsset>View Allocated Asset</a><br>
<a href=assetCatalogue>Asset Catalogue</a><br>
</body>
</html>