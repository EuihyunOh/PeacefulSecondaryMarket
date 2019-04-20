<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Let's Trade</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/css/non-responsive.css">
</head>
<body>

<jsp:include page="/Navbars.jsp"/>

<div class="container">
	<form class="form-horizontal" action="write.do" method="post">
		<div class="col-xs-6">
		<div class="form-group">	
			<label for="title">Title</label>
			<input type="text" id="title" name="title" class="form-control" placeholder="Title" required>
		</div>
		<div class="form-group">
			<label for="tradeName">Name</label>
			<input type="text" id="tradeName" name="tradeName" class="form-control" value="${member.tradeName}" required> 
		</div>
		<div class="form-group">
			<label for="phone">Phone</label>
			<input type="text" id="phone" class="form-control" value="${member.phone}" placeholder="Please regist your number" required readOnly> 
		</div>
		<div class="form-group">
			<label for="price">Price ($)</label>
			<input type="number" step="any" id="price" name="price" class="form-control" placeholder="Price" required>
		</div>
		<div class="form-group">
			<label for="condition">Condition</label>
			<select class="form-control" id="condition" name="condition">
				<option value="3">Perfect</option>
				<option value="2">Good</option>
				<option value="1">Not Bad</option>
				<option value="0">Bad</option>
			</select>
		</div>
		<div class="form-group">
			<label for="content">Detail</label>
			<textarea id="content" name="content" rows="30" class="form-control" placeholder="Write detail" required></textarea>
		</div>

		<button type="button" class="btn btn-danger pull-right" 
			style='margin-left:5px' onclick='location.href="<%=request.getContextPath()%>/index.html"'>
				Cancel</button>
		<button type="submit" class="btn btn-info pull-right">Complete!</button>
		
		</div> <!-- /col-xs -->
	</form>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

</body>
</html>