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
<div class="container mt-5">
    <h3>Asset Return Requests</h3>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>#</th>
                <th>Employee</th>
                <th>Asset</th>
                <th>Reason</th>
                <th>Status</th>
                <th>Request Date</th>
                <th>Return Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="r" items="${requests}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${r.employee.name}</td>
                    <td>${r.asset.assetName}</td>
                    <td>${r.reason}</td>
                    <td>${r.status}</td>
                    <td>${r.requestDate}</td>
                    <td>${r.returnDate}</td>
                    <td>
                        <form action="/admin/return-requests/${r.id}/approve" method="post" style="display:inline;">
                            <button class="btn btn-success btn-sm" type="submit">Approve</button>
                        </form>
                        <form action="/admin/return-requests/${r.id}/reject" method="post" style="display:inline;">
                            <button class="btn btn-danger btn-sm" type="submit">Reject</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>