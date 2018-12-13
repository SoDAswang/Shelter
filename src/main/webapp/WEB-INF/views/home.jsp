<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<link href="${ctx }/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/static/css/shelter-style.css" rel="stylesheet">
<title>Home</title>

</head>
<style>
.nav .open > a, .nav .open > a:hover, .nav .open > a:focus {
background-color:#00000000!important;
}
.nav .open>a, .nav .open>a:focus, .nav .open>a:hover {
background-color:#00000000!important;
}
</style>
<body>
	<nav class="navbar navbar-default navbar-fixed-top"
		style="margin-bottom: 0px">
		<div class="container-fluid" style="margin: 25px 20px">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img class="logo logo-black"
					src="${ctx }/static/image/logo_white.png"
					style="width: 80px; height: 20px;" alt="Home" /> </a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${ctx }/material"><b class="li-white">购买建材</b></a></li>
					<li><a href="${ctx }/sample"><b class="li-white">装修案例</b></a></li>
					<c:if test="${session > 0}">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown" role="button" aria-haspopup="true"
									aria-expanded="false"><b class="li-white">个人中心</b><span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="${ctx }/personal/">我的信息</a></li>
										<li><a href="${ctx }/personal/favorite/">我的收藏</a></li>
										<li><a href="${ctx }/personal/wish">装修心愿单</a></li>
										<li><a href="${ctx }/personal/order">我的订单</a></li>
									</ul></li>
							</c:if>
				    <li><a href="#"><b class="li-white">${session}</b></a></li>
					<li><a><span class="glyphicon glyphicon-user white"
									onclick="loginModel()"></span></a></li>
				    <c:if test="${session > 0}">
									 <li>
						        <a href="${ctx }/logout"><b class="li-white">退出</b></a>
						    </li>
					</c:if>
				</ul>





			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="top">
		<div class="jumbotron"
			style="background-image: url(${ctx }/static/image/homepage.jpg); background-size:100% 100%; height:670;">
			<div class="container">
				<div class="col-md-5" style="padding-top: 160px">
					<p style="color: white; font-size: 42px; margin-bottom: 30px">
						<b>打造完美家居生活</b>
					</p>
					<button type="button" class="btn btn-mydefault"
						style="padding: 10px 80px">
						<b>开始打造</b>
					</button>
				</div>
			</div>
		</div>
	</div>
	<%-- <div class="row full has-fold" style="">
		<div class="col-md-12 col-xs-12">
			<div class="top-img-md top-img-md--video"
				style="background-image: url()">
				<div class="wrapper-video" style="margin-bottom:50px;">
					<video autoplay muted playsinline loop>
						<source
							src="https://www.vipp.com/sites/default/files/vipploft_nosound_nologo-mobile.mp4"
							type="video/mp4">
					</video>
				</div>
				<div class="top-img-md--content white">
					<h4>装修案例</h4>
					<h1 class="hero-heading">打造您的私人天地</h1>
					<a href="${ctx }/sample" class="btn btn-mydefault">开始体验</a>
				</div>
			</div>
		</div>
	</div> --%>

	<div class="container">
		<h3 style="margin-left: -80px;">购买建材</h3>
		<div class="row">
			<div class="col-md-6 col-xs-12">
				<div
					style="background:url(${ctx }/static/image/material.jpg); background-size:100% 100%;  width:400px;height:200px ">
					<a href="${ctx }/material">
						<div class="img-title"
							style="width: 400px; height: 200px; padding-top: 80px;"
							align="center">
							<span>购买建材</span>
						</div>
					</a>

				</div>
				<h2>建材</h2>
				<div class="a-detail">
					<a href="#">木材</a> <a href="#">水泥</a> <a href="#">混凝土</a> <a
						href="#">金属</a> <a href="#">砖瓦</a> <a href="#">玻璃</a> <a href="#">复合材料</a>
				</div>
			</div>
			<div class="col-md-6 col-xs-12">
				<div
					style="background:url(${ctx }/static/image/furnish.jpg); background-size:100% 100%; width:400px; height:200px; ">
					<a href="#">
						<div class="img-title"
							style="width: 400px; height: 200px; padding-top: 80px;"
							align="center">
							<span>购买家居</span>
						</div>
					</a>
				</div>
				<h2>家居</h2>
				<div class="a-detail">
					<a href="#">沙发</a> <a href="#">床</a> <a href="#">衣柜</a> <a href="#">餐桌</a>
					<a href="#">电视柜</a> <a href="#">茶几</a> <a href="#">梳妆台</a>
				</div>
			</div>
		</div>
	</div>





		<!-- Login Modal -->
	<div class="modal fade" id="loginModal" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<p class="login-title" align="center">欢迎  Shelter</p>

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
		
		<input type="hidden" value ="${session }" name="session"/>
	<script src="${ctx }/static/js/jquery.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/js/js-shelter/decorator.js"></script>
	<script>
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




