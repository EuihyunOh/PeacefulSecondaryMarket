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
	<table class="table table-hover table-bordered" style="margin:10px;" >
		<thead>
		<tr>
			<th width="5%">#</th>
			<th width="10%">Condition</th>
			<th width="30%">Title</th>
			<th width="10%">Trader</th>
			<th width="25%">Date</th>
			<th width="10%">Price</th>
			<th width="10%">State</th>
		</tr>
		</thead>		
		<tbody>
		<c:forEach var="trade" items="${trades}">
			<tr>
				<td>${trade.no}</td>				
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
				<td><a href="detail.do?no=${trade.no}">${trade.title}</a></td>
				<td>${trade.tradeName}</td>
				<td>${trade.createDate}</td>
				<td>${trade.price} $</td>
				<c:choose>
					<c:when test="${trade.state==0}">
						<td>Available</td>
					</c:when>
					<c:when test="${trade.state==1}">
						<td>Processing</td>
					</c:when>
					<c:when test="${trade.state==2}">
						<td>Complete</td>
					</c:when>
					<c:when test="${trade.state==3}">
						<td>On Deal</td>
					</c:when>
					<c:when test="${trade.state==4}">
						<td>Dispute</td>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${empty sessionScope.member or empty sessionScope.member.id}">
  		 <a class="btn btn-info pull-right" href="../auth/signin.do">Write</a>
    </c:if>
    <c:if test="${!empty sessionScope.member and !empty sessionScope.member.id}">
  		  <a class="btn btn-info pull-right" href="write.do">Write</a>
    </c:if>
	<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${no.paginationStart == 1}">
					<li class="page-item"><a class="page-link">Previous</a></li>		
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="list.do?no=${no.paginationStart-1}">Previous</a></li>								
				</c:otherwise>
			</c:choose>
			<li class="page-item <c:if test="${no.paginationStart == no.page}">active</c:if>"><a class="page-link" href="list.do?no=${no.paginationStart}">${no.paginationStart}</a></li>
			<li class="page-item <c:if test="${no.paginationStart+1 == no.page}">active</c:if>" ><a class="page-link" href="list.do?no=${no.paginationStart+1}">${no.paginationStart+1}</a></li>
			<li class="page-item <c:if test="${no.paginationStart+2 == no.page}">active</c:if>" ><a class="page-link" href="list.do?no=${no.paginationStart+2}">${no.paginationStart+2}</a></li>
			<li class="page-item <c:if test="${no.paginationStart+3 == no.page}">active</c:if>" ><a class="page-link" href="list.do?no=${no.paginationStart+3}">${no.paginationStart+3}</a></li>
			<li class="page-item <c:if test="${no.paginationStart+4 == no.page}">active</c:if>" ><a class="page-link" href="list.do?no=${no.paginationStart+4}">${no.paginationStart+4}</a></li>
			<li class="page-item"><a class="page-link" href="list.do?no=${no.paginationStart+5}">Next</a></li>
		</ul>
	</div>
	
</div> <!--  /container  -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

</body>
</html>