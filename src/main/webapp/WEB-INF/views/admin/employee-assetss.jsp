<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Allocated Assets Per Employee</h2>
<c:forEach var="entry" items="${assetMap}">
    <h3>Employee: ${entry.key.name} (${entry.key.email})</h3>
    <table border="1" style="margin-bottom: 20px;">
        <tr>
            <th>Asset Name</th>
            <th>Model</th>
            <th>Status</th>
        </tr>
        <c:forEach var="asset" items="${entry.value}">
            <tr>
                <td>${asset.assetName}</td>
                <td>${asset.modelNumber}</td>
                <td>${asset.status}</td>
            </tr>
        </c:forEach>
    </table>
</c:forEach>

</body>
</html>