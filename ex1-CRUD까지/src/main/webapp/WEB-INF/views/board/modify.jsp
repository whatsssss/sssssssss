<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Modify Page</h1>

	<form id="actionForm" action="/board/modify" method="post">
		<input type='hidden' name="title" value="${vo.title}"></input> <input
			type='hidden' name="content" value="${vo.content}"></input> <input
			type='hidden' name="writer" value="${vo.writer}"></input>



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


	</form>
	<button class="ModBtn">Submit</button>
	<button class="DelBtn">Delete</button>
	<button class="LisBtn">Go List</button>

	<hr>


	<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

	<script>
		var actionForm = $("#actionForm");

		$(".ModBtn").click(function(e) {
			actionForm.submit();
		})

		$(".DelBtn").click(function(e) {
			console.log("=======")
			actionForm.attr("action", "/board/delete");
		
			actionForm.submit();
		})

		$(".LisBtn").click(function(e) {
			console.log("=======")
			actionForm.attr("action", "/board/list");
			actionForm.attr("method", "get");
			actionForm.submit();
		})
	</script>
</body>
</html>