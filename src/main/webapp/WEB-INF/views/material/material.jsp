<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${ctx }/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/static/css/shelter-style.css" rel="stylesheet">
<title>买建材 | Shelter</title>
<style>
</style>
</head>
<body>
    
	<div class="jumbotron bottom" style="height:400px; background:url(${ctx }/static/image/material.jpg);">
		<div class="container white" style="margin-top: 140px;">
			<h1>购买建材</h1>
		</div>
	</div>
	<div class="container">
		<h3>建材</h3>
		<hr size='5' />
		<div class="row">
			<div class="col-md-4 col-xs-12">
			<a href="${ctx }/material/category">
			<div>
				<img src="${ctx }/static/image/material-content/wood.jpg"
					width="200" height="200">
				<h4>地板</h4>
			</div>
</a>
			</div>
			<div class="col-md-4 col-xs-12">
				<img src="${ctx }/static/image/material-content/concrete.jpg"
					width="200" height="200">
				<h4>水泥</h4>

			</div>
			<div class="col-md-4 col-xs-12">
				<img src="${ctx }/static/image/material-content/tile.jpg"
					width="200" height="200">
				<h4>砖瓦</h4>

			</div>
		</div>
		
		<input type="hidden" value ="${session }" name="session"/>
	</div>
	<script src="${ctx }/static/js/jquery.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js"></script>
	
</body>
</html>




