<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/css/non-responsive.css">
</head>
<body>

<jsp:include page="/Navbars.jsp"/>

<div class="container">
	
	<form>
		<div class="page-header">
        	<h2>Sign in</h2>
        </div>
		
        <div class="col-xs-6">
        <div class="form-group">
        <label for="id">ID</label>
        <input type="text" id="id" class="form-control" placeholder="ID" required>
        </div>
        <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Password" required>
        </div>
       
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </div> <!-- /col-xs-6 -->
     </form>	 
</div> <!--  /container  -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

</body>
</html>