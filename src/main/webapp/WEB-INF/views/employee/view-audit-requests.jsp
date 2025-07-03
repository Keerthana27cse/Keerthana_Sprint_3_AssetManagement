<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Audit Requests - Employee</title>
    <%@ include file="../head.jsp" %>
</head>
<body>
<%@ include file="../employee-navbar.jsp" %>

<div class="container mt-5">
    <h2>My Audit Requests</h2>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Audit ID</th>
            <th>Status</th>
            <th>Remarks</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="audit" items="${audits}">
            <tr>
                <td>${audit.id}</td>
                <td>${audit.status}</td>
                <td>${audit.remarks}</td>
                <td>
                    <c:if test="${audit.status == 'PENDING'}">
                        <form action="${pageContext.request.contextPath}/employee/submitAuditResponse" method="post">
                            <input type="hidden" name="auditId" value="${audit.id}" />
                            <select name="status" class="form-control mb-2">
                                <option value="APPROVED">Approve</option>
                                <option value="REJECTED">Reject</option>
                            </select>
                            <textarea name="remarks" class="form-control mb-2" placeholder="Add remarks..." required></textarea>
                            <button type="submit" class="btn btn-success">Submit</button>
                        </form>
                    </c:if>
                    <c:if test="${audit.status != 'PENDING'}">
                        <em>Response submitted</em>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
