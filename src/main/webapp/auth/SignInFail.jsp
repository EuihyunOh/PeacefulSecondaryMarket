<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oops!</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/css/non-responsive.css">
</head>
<body>

<jsp:include page="/Navbars.jsp"/>

<div class="container">
<div class="jumbotron">
	<h1>Oops!</h1>
	<div class="text-center">
		<div class="alert alert-danger" role="alert" style='margin:50px'>
			<strong>We can't find you on the list</strong>
			"Please check your Id or Password"<br>
			 or you are not our member, please Sign Up and With Us!<br>
		</div>
		<a class="btn btn-primary" href="../member/signup.do">Sign Up!</a>
	</div>
</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

</body>
</html>