<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/css/non-responsive.css">
</head>
<body>

<jsp:include page="/Navbars.jsp"/>

<div class="container">
	<table class="table table-bordered" style="width:800px">
		<tr>
			<th colspan="2">Title</th>
		</tr>
		<tr>
			<td>Date</td>
			<td>2019-01-01</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>사기아님</td>
		</tr>
		<tr>
			<td>Phone</td>
			<td>010-5555-1111</td>
		</tr>
		<tr>
			<td>Price ($)</td>
			<td>5</td>
		</tr>
		<tr>
			<td>Condition</td>
			<td>Good</td>
		</tr>
		<tr>
			<td colspan="2">막내야<br>또 속았구나</td>
		</tr>		
	</table>
		<button type="button" class="btn btn-info">Deal</button>
		<button type="button" class="btn btn-danger">Back</button>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

</body>
</html>