<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base
	href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />
<script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			// 相当于浏览器的后退按钮
			window.history.back();
		});
	});
</script>
</head>
<body>

	<h1>出错了！</h1>

	<!-- 
		requestScope对应的是存放request域数据的Map
		requestScope.exception相当于request.getAttribute("exception")
		requestScope.exception.message相当于exception.getMessage()
	-->
	${requestScope.exception.message }
	<br />
	<button>返回上一步</button>
</body>
</html>