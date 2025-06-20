<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Asset Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2>${asset.assetName}</h2>
    <div class="row">
        <div class="col-md-6">
            <img src="${asset.imageUrl}" class="img-fluid rounded shadow" alt="Asset Image">
        </div>
        <div class="col-md-6">
            <ul class="list-group">
                <li class="list-group-item"><strong>Model:</strong> ${asset.assetModel}</li>
                <li class="list-group-item"><strong>Value:</strong> ₹${asset.assetValue}</li>
                <li class="list-group-item"><strong>Status:</strong> ${asset.assetStatus}</li>
                <li class="list-group-item"><strong>Category:</strong> ${asset.category.categoryName}</li>
                <li class="list-group-item"><strong>Manufactured On:</strong> ${asset.manufacturingDate}</li>
                <li class="list-group-item"><strong>Expires On:</strong> ${asset.expiryDate}</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
