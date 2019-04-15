<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Peaceful! My page</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">

<link rel="stylesheet" href="../resources/css/non-responsive.css">
</head>
<body>

<jsp:include page="/Navbars.jsp"/>

<div class="container">

	<div class="page-header">
		<h2>My Item</h2>
	</div>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>#</th>
			<th>Title</th>
			<th>Trader</th>
			<th>Date</th>
			<th>Deal</th>
			<th>Hit</th>
		</tr>
		</thead>		
		<tbody>
		<tr>
			<td>111</td>
			<td>안뇽</td>
			<td>되팔이</td>
			<td>2019.01.01</td>
			<td>89$</td>
			<td>5</td>
		</tr>
		<tr>
			<td>112</td>
			<td>ㅎㅎ</td>
			<td>사기아님</td>
			<td>2019.01.01</td>
			<td>9$</td>
			<td>5</td>
		</tr>
		</tbody>
	</table>
	<div class="text-center">
		<ul class="pagination">
			<li><a href="#">1</a></li>
		</ul>
	</div>
	
	
	
	<div class="page-header">
		<h2>Trade History</h2>
	</div>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>#</th>
			<th>Title</th>
			<th>Trader</th>
			<th>Date</th>
			<th>Deal</th>
			<th>Hit</th>
		</tr>
		</thead>		
		<tbody>
		<tr>
			<td>111</td>
			<td>안뇽</td>
			<td>되팔이</td>
			<td>2019.01.01</td>
			<td>89$</td>
			<td>5</td>
		</tr>
		<tr>
			<td>112</td>
			<td>ㅎㅎ</td>
			<td>사기아님</td>
			<td>2019.01.01</td>
			<td>9$</td>
			<td>5</td>
		</tr>
		</tbody>
	</table>
	<div class="text-center">
		<ul class="pagination">
			<li><a href="#">1</a></li>
		</ul>
	</div>
</div> <!--  /container  -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

</body>
</html>