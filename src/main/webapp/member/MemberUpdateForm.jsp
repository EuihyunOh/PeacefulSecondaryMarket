<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/non-responsive.css">
</head>
<body>

<jsp:include page="/Navbars.jsp"/>

<div class="container">	
	<form action="update.do" method="post">
		<div class="page-header">
			<h2>Update Information</h2>
			</div>
		<div class="col-xs-6">
		<div class="form-group">
 	 	<label for="id">ID</label>
  		<input type="text" id="id" name="id" class="form-control" value="${member.id}" readonly>
		</div>
		<div class="form-group">
    	<label for="password">Password</label>
    	<input type="password" id="password" name="password" class="form-control" placeholder="If you want change password, fill this fromIf you want change password, fill this from">    	
    	</div>
  		<div class="form-group">
  		<label for="address">Address</label>
  		<input type="text" id="address" name="address" class="form-control" value="${member.address}" required>
  		</div>
  		<div class="form-group">
  		<label for="tradeName">Trade Name</label>
  		<input type="text" id="tradeName" name="tradeName" class="form-control" value="${member.tradeName}" required>
  		</div>
  		<div class="form-group">
  		<label for="account">Bank Account</label>
  		<input type="text" id="account" name="account" class="form-control" value="${member.account}" placeholder="Account using at Trade" required>
  		</div>
  		<div class="form-group">
  		<label for="phone">Phone Number</label>
  		<input type="text" id="phone" name="phone" class="form-control" value="${member.phone}" placeholder="Phone number for contact" required>
  		</div>
	<button type="submit" class="btn btn-primary">Update</button>
	<button type="button" class="btn btn-danger" onclick='location.href="<%=request.getContextPath()%>/index.html"'>Cancel</button>
		</div> <!-- /col-md-6 -->
	</form>
</div> <!--  /container  -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

</body>
</html>