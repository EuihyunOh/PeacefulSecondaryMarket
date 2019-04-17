<%@ page import="psm.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Peaceful! Secondary Market!</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">

<link rel="stylesheet" href="../resources/css/non-responsive.css">
</head>
<body>

<jsp:include page="/Navbars.jsp"/>

<div class="container">

	<div class="page-header">
		<h2>Peaceful Board</h2>
	</div>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>#</th>
			<th>Condition</th>
			<th>Title</th>
			<th>Trader</th>
			<th>Date</th>
			<th>Price</th>
			<th>State</th>
		</tr>
		</thead>		
		<tbody>
		<tr>
			<td>111</td>
			<td>Perfect</td>
			<td>안뇽</td>
			<td>되팔이</td>
			<td>2019.01.01</td>
			<td>89$</td>
			<td>5</td>
		</tr>
		<tr>
			<td>112</td>
			<td>Good</td>
			<td>ㅎㅎ</td>
			<td>사기아님</td>
			<td>2019.01.01</td>
			<td>9$</td>
			<td>5</td>
		</tr>
		<tr>
			<td>113</td>
			<td>Not Bad</td>
			<td>안뇽</td>
			<td>되팔이</td>
			<td>2019.01.01</td>
			<td>89$</td>
			<td>5</td>
		</tr>
		<tr>
			<td>114</td>
			<td>Bad</td>
			<td>ㅎㅎ</td>
			<td>사기아님</td>
			<td>2019.01.01</td>
			<td>9$</td>
			<td>5</td>
		</tr>
		</tbody>
	</table>
	
	<c:if test="${empty sessionScope.member or empty sessionScope.member.id}">
  		 <a class="btn btn-info pull-right" href="<%=request.getContextPath()%>/auth/signin.do" role="button">Write</a>
    </c:if>
    <c:if test="${!empty sessionScope.member and !empty sessionScope.member.id}">
  		 <a class="btn btn-info pull-right" href="write.do" role="button">Write</a>
    </c:if>
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