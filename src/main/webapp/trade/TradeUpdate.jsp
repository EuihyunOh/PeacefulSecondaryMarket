<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trade Update</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/css/non-responsive.css">
</head>
<body>

<jsp:include page="/Navbars.jsp"/>

<div class="container">
	<form class="form-horizontal">
		<div class="col-xs-6">
		<div class="form-group">	
			<label for="title">Title</label>
			<input type="text" id="title" class="form-control" placeholder="Title" required>
		</div>
		<div class="form-group">
			<label for="tradeName">Name</label>
			<input type="text" id="tradeName" class="form-control" placeholder="Trade Name" disabled> 
		</div>
		<div class="form-group">
			<label for="phone">Phone</label>
			<input type="text" id="phone" class="form-control" placeholder="Phone" disabled> 
		</div>
		<div class="form-group">
			<label for="price">Price ($)</label>
			<input type="number" id="price" class="form-control" placeholder="Price" required>
		</div>
		<div class="form-group">
			<label for="condition">Condition</label>
			<select class="form-control" id="condition">
				<option>Perfect</option>
				<option>Good</option>
				<option>Not Bad</option>
				<option>Bad</option>
			</select>
		</div>
		<div class="form-group">
			<label for="content">Detail</label>
			<textarea id="content" rows="30" class="form-control" placeholder="Write detail" required></textarea>
		</div>
		<div class="form-group">
			<label for="InputSubject1">Attach</label>
			<input id="fileInput" class="filestyle" type="file" 
				data-class-button="btn btn-default" data-class-input="form-control" data-button-text="" data-icon-name="glyphicon glyphicon-upload" 
				class="form-control" tabindex="-1" style="position: absolute; clip: rect(0px 0px 0px 0px);">
			<div class="bootstrap-filestyle input-group">
				<input type="text" id="userfile" class="form-control" name="userfile" disabled>
				<span class="group-span-filestyle input-group-btn" tabindex="0">
					<label for="fileInput" class="btn btn-default ">
						<span class="glyphicon glyphicon-upload"></span>
					</label>
				</span>
			</div>
		</div>
		<button type="button" class="btn btn-danger pull-right" style='margin-left:5px'>Cancel</button>
		<button type="submit" class="btn btn-info pull-right">Complete!</button>
		
		</div> <!-- /col-xs -->
	</form>
</div>


<script type="text/javascript">
$(document).ready(function(){
	$("#fileInput").on('change', function(){  // if change val
		if(window.FileReader){  // modern browser
			var filename = $(this)[0].files[0].name;
		} else {  // old IE
			var filename = $(this).val().split('/').pop().split('\\').pop();  // get file name
		}
		// input filename
		$("#userfile").val(filename);
	});
});
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

</body>
</html>