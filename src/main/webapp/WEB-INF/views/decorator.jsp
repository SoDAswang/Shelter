<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${ctx }/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/static/css/shelter-style.css" rel="stylesheet">

<!-- <title>Navigation</title> -->

<sitemesh:write property='head' />
</head>
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top border-radius">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="${ctx }/home">Shelter</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="${ctx }/home">首页</a></li>
							<li><a href="${ctx }/material">购买建材</a></li>
							<li><a href="#">购买家居</a></li>
							<li><a href="${ctx }/sample">装修案例</a></li>

							<c:if test="${session > 0}">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown" role="button" aria-haspopup="true"
									aria-expanded="false">个人中心<span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="${ctx }/personal/">我的信息</a></li>
										<li><a href="${ctx }/personal/favorite/">我的收藏</a></li>
										<li><a href="${ctx }/personal/wish">装修心愿单</a></li>
										<li><a href="${ctx }/personal/order">我的订单</a></li>
									</ul></li>
							</c:if>

						</ul>
						<ul class="nav navbar-nav navbar-right">
						    <li><a href="#">${session}</a></li>
							<li><a><span class="glyphicon glyphicon-user white"
									onclick="loginModel()"></span></a></li>
						    <c:if test="${session > 0}">
									 <li>
						        <a href="${ctx }/logout">退出</a>
						    </li>
						    </c:if>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>

	<!-- Login Modal -->
	<div class="modal fade" id="loginModal" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<p class="login-title" align="center">Welcome Shelter</p>

					<div class="tab-content">

						<!-- Login Panel -->
						<div id="login" class="tab-pane active">
							<form action="${ctx }/login" class="form-signin" method="post" id="loginform">
								<input type="text" id="inputUserName" class="form-control"
									name="username" placeholder="手机号" required autofocus
									style="margin-bottom: 10px;"> <input type="password"
									name="password" id="inputPassword" class="form-control"
									style="margin-bottom: 10px;" placeholder="密码" required>

								<input type="text" class="form-control" name="jcaptchaCode"
									id="jcaptchaCode" placeholder="请输入验证码" />
								<div class="form-group col-sm-12">
									<label for="inputPwd" class="col-sm-4 control-label"></label>
									<div class="col-sm-6">
										<img class="jcaptcha-btn jcaptcha-img"
											src="${pageContext.request.contextPath}/jcaptcha.jpg"
											title="点击更换验证码"> <a class="jcaptcha-btn"
											href="javascript:;">换一张</a>
									</div>
								</div>
								<div class="form-group col-sm-12">
								<p id="errorTip" style="color: red;"></p>

								</div>
								<div class="form-inline">
									<!-- <div class="form-group col-md-3 col-xs-3 checkbox"
										style="margin-left: 10px;">
										<label> <input type="checkbox" value="remember-me"
											style="-webkit-appearance: checkbox"> 记住密码
										</label>
									</div> -->
									<div class="form-group col-md-offset-10 col-md-2 col-xs-2">
										<a href="#register" aria-controls="register" data-toggle="tab">立即注册</a>
									</div>
								</div>
								<button class="btn btn-lg btn-primary btn-block" type="button" onclick="login()">登录
								</button>
								<input type="hidden" id="url" name="url"  />
							</form>
						</div>

						<!-- Register Panel -->
						<div id="register" class="tab-pane">
							<form class="form-signin">
								<p align="right">
									已有Shelter账号？<a href="#login" aria-controls="login"
										data-toggle="tab">登录</a>
								</p>
								<input type="text" id="inputRegisterUserName"
									class="form-control" placeholder="手机号" required autofocus
									style="margin-bottom: 10px;"> <input type="password"
									id="inputRegisterPassword" class="form-control"
									style="margin-bottom: 10px;" placeholder="输入密码" required>
								<input type="password" id="confirmRegisterPassword"
									class="form-control" style="margin-bottom: 10px;"
									placeholder="确认密码" required>
								<p id="isSame" style="color: red;"></p>
								<button class="btn btn-lg btn-primary btn-block" type="button"
									onclick="register()">立即注册</button>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
    <input type="hidden" id="error" value="${error}">
	<sitemesh:write property='body' />

	<script src="${ctx }/static/js/jquery.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/js/js-shelter/decorator.js"></script>
	<script>
	$(function() {
		$(".jcaptcha-btn").click(
				function() {
					$(".jcaptcha-img").attr("src",'${pageContext.request.contextPath}/jcaptcha.jpg?'+ new Date().getTime());
				});
	});
	
		function loginModel() {
			$("#loginModal").modal('toggle').css({
				'width' : 'auto', // Center display.
				'margin-top' : function() {
					return ($(this).height() / 4);
				}
			});
		}
		
	</script>

</body>
</html>