<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<link href="${ctx }/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/static/css/shelter-style.css" rel="stylesheet">
<title>Shelter | 装修估价</title>

</head>
<body>

   <!-- 设计案例 -->
   <div class="container margin_head">
       <div class="row">
           <h3 class="col-md-3" style="margin-left: -80px;">设计案例</h3>
           <a class="col-md-offset-8 col-md-1" style="margin-top: 30px;">更多<span class="glyphicon glyphicon-menu-right"></span></a>
       </div>
       <hr style="margin-top: 0px;"/>
       <div id=samples>
			<c:forEach items="${ samples}" var="s">
			  <a href="${ctx }/sample/${s.id }">
				<div class="col-md-3 col-xs-12">
					<img src=${s.coverAdd } width="275" height="183">
					<div style="padding-left: 15px; padding-right: 15px;">
						<h6>${s.title }</h6>
					</div>
				</div>
			  </a>	
			</c:forEach>
		</div>
		
		<input type="hidden" value ="${session }" name="session"/>
   </div>
   
	<script src="${ctx }/static/js/jquery.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/js/js-shelter/estimate.js"></script>
</body>
</html>