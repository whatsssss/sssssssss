<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/board/register" method="post">
		<div>
			<input type="text" name='title' placeholder="Title">
		</div>
		<div>
			<input type="text" name='content' placeholder="Content">
		</div>
		<div>
			<input type="text" name='writer' placeholder="writer">
		</div>

		<hr>
		<button>Submit</button>


	</form>


	<form id="actionForm" action="/board/list" method="get">
		<input type='hidden' name='bno' value='${vo.bno}'> <input
			type='hidden' name="title" value="${vo.title}"> <input
			type='hidden' name="content" value="${vo.content}"> <input
			type='hidden' name="writer" value="${vo.writer}">
	</form>



	<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script>

	 var flag = '${result}';
	 
	 if(flag === 'success'){
		 alert("작업이 성공했습니다.");
	 }

	
	</script>

</body>
</html>