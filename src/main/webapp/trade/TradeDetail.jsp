<%@ page import="psm.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
			<th colspan="2">${trade.title}</th>
		</tr>
		<tr>
			<td>Date</td>
			<td>${trade.createDate}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${trade.tradeName}</td>
		</tr>
		<tr>
			<td>Contact</td>
			<td>${phone}</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>${trade.price} $</td>
		</tr>
		<tr>
			<td>Condition</td>
			<c:choose>
					<c:when test="${trade.condition == 0 }">
						<td>Bad</td>
					</c:when>
					<c:when test="${trade.condition == 1 }">
						<td>Not Bad</td>
					</c:when>
					<c:when test="${trade.condition == 2 }">
						<td>Good</td>
					</c:when>
					<c:when test="${trade.condition == 3 }">
						<td>Perfect</td>
					</c:when>
			</c:choose>
		</tr>
		<tr>
			<td colspan="2">${trade.content}</td>
		</tr>		
	</table>
	<c:if test="${empty sessionScope.member or empty sessionScope.member.id}">
            <button type="button" class="btn btn-info" onclick='location.href="../auth/signin.do"'>Deal</button>
    </c:if>
    <c:if test="${(!empty sessionScope.member or !empty sessionScope.member.id)and(isWriter==false)}">            
            <button type="button" class="btn btn-info" onclick='location.href="#"'>Deal</button>
    </c:if>
    <c:if test="${(!empty sessionScope.member or !empty sessionScope.member.id)and(isWriter==true)}">            
            <button type="button" class="btn btn-primary" onclick='location.href="update.do?no=${trade.no}"'>Update</button>
    </c:if>
		<button type="button" class="btn btn-danger" onclick='location.href="<%=request.getContextPath()%>/index.html"'>Back</button>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

</body>
</html>