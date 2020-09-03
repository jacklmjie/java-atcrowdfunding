<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>system error</title>
<base
	href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />
<script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			// 相当于浏览器的后退按钮
			window.history.back();
		});
	});
</script>
</head>
<body>

	<h1>出错了！</h1>

	<!-- 从请求域取出Exception对象，再进一步访问message属性就能够显示错误消息 -->
	${requestScope.exception.message }
	<button>返回上一步</button>
</body>
</html>