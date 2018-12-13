<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>

<link href="${ctx }/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/static/css/shelter-style.css" rel="stylesheet">
<title>Shelter | 修改信息</title>

</head>
<body>
    <div class="container margin_head">
    <ul class="breadcrumb col-md-4" style="margin-left: -80px;">
			<li>我的信息</li>
			<li class="active"></li>
		</ul>
		
		
		<input type="hidden" value ="${session }" name="session"/>
		
	</div>

	<script src="${ctx }/static/js/jquery.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/js/js-shelter/sample_detail.js"></script>

</body>
</html>