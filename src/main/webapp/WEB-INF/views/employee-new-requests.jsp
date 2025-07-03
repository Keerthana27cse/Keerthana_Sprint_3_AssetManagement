<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>My New Asset Requests</title></head>
<body>
    <h2>New Asset Requests by ${employee.name}</h2>
    <table border="1">
        <tr>
            <th>Request ID</th>
            <th>Category</th>
            <th>Description</th>
            <th>Status</th>
            <th>Request Date</th>
            
        </tr>
        <c:forEach var="req" items="${requests}">
            <tr>
                <td>${req.id}</td>
                <td>${req.requestedCategory.categoryName}</td>
                <td>${req.description}</td>
                <td>${req.status}</td>
                <td>${req.requestDate}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
