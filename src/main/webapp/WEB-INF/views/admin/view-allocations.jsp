<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <title>Asset Allocations</title>
    <style>
        table {
            width: 90%;
            margin: 30px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px 15px;
            border: 1px solid #aaa;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h2 style="text-align:center;">All Asset Allocations</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Asset Name</th>
        <th>Employee Name</th>
        <th>Request Date</th>
        <th>Allocation Date</th>
        <th>Return Date</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="alloc" items="${allocations}">
        <tr>
            <td>${alloc.id}</td>
            <td>${alloc.asset.assetName}</td>
            <td>${alloc.employee.name}</td>
            <td>${alloc.requestDate}</td>
            <td>${alloc.allocationDate}</td>
            <td>
                <c:choose>
                    <c:when test="${not empty alloc.returnDate}">
                        ${alloc.returnDate}
                    </c:when>
                    <c:otherwise>
                        -
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${alloc.allocationStatus}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
