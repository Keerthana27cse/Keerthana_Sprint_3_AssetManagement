<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp"%>
<meta charset="UTF-8">
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container">

<div class="row">

<div class="col -sm-6 text-center">
</div>

<div class="col-sm-6">
<h3 class="mb-4">Register</h3>

<form action ="/user/register" method="post">

<div class="mb-3">
            <select class="form-control" name="userrole" required>
                <option value="">Select Role</option>
                <option value="EMPLOYEE">Employee</option>
            </select>
        </div>


<div class="mb-3">
<input type="text" class="form-control"name="name" placeholder="Full Name"
required>
</div>

<div class ="mb-3" >
<select class="form-control" name="gender" required>
<option value="MALE">MALE</option>
<option value="FEMALE">FEMALE</option>
<option value="OTHER">OTHER</option>
</select></div>

<div class="mb-3">
<input type="tel" class="form-control"name="contactNumber" placeholder="ContactNo"
required>
</div>

<div class="mb-3">
<textArea class="form-control"name="address" placeholder="Address"
required></textArea>
</div>

<div class="mb-3">
<input type="email" class="form-control"name="email" placeholder="Email"
required>
</div>



<div class="mb-3">
<input type="password" class="form-control" name="password" placeholder="Password" required>
</div>


<div class="mb-3">
 <button type="submit" class="btn btn-primary">Registered</button>
 <button type="reset" class="btn btn-danger" >Reset</button>
</div>



</form>
</div>
</div>
</div>
</body>
</html>