<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form id="actionForm" action="/board/modify" method="get">
		<input type='hidden' name='bno' value='${vo.bno}'> 
		<input type='hidden' name="title" value="${vo.title}"> 
		<input type='hidden' name="content" value="${vo.content}"> 
		<input type='hidden' name="writer" value="${vo.writer}">
	</form>

	<div>
		<input type="text" name='bno' value="${vo.bno}">
	</div>
	<div>
		<input type="text" name='title' value="${vo.title}">
	</div>
	<div>
		<input type="text" name='content' value="${vo.content}">
	</div>
	<div>
		<input type="text" name='writer' value="${vo.writer}">
	</div>

	<button class = "modBtn ">Modify</button>
	<button class = "listBtn ">GoList</button>
	<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script>
	console.log("==================")
	var actionForm = $("#actionForm");

	$(".modBtn").click(function(e) {
		actionForm.submit();
	})
	
	$(".listBtn").click(function(e) {
		console.log("=======")
		actionForm.attr("action", "/board/list");
		actionForm.submit();
	})
	
	</script>
</script>
</body>
</html>