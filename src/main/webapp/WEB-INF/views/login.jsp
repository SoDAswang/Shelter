<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<link href="${ctx }/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/static/css/shelter-style.css" rel="stylesheet">
<title>login | Shelter</title>

</head>
<body>

	<div class="container">

		<form class="form-signin">
			<label for="inputUserName" class="sr-only">用户名</label> <input
				type="text" id="inputUserName" class="form-control"
				placeholder="用户名" required autofocus> 
			<label
				for="inputPassword" class="sr-only">密码</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="密码" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					记住密码
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录
				</button>
		</form>

	</div>
	<!-- /container -->

</body>
</html>