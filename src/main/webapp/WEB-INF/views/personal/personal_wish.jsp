<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>

<link href="${ctx }/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/static/css/shelter-style.css" rel="stylesheet">
<title>Shelter | 我的心愿单</title>

</head>
<body>
	<div class="container margin_head">
		<ul class="breadcrumb" style="margin-left: -80px;">
			<li>装修心愿单</li>
			<li class="active"></li>
		</ul>

		<hr style="margin-top: 0px;" />

		<div>
			<c:forEach items="${ wishes}" var="w">
				<div class="col-md-3">
				    <div style="background:url(${w[0] }); background-size:100% 100%; height:150px;">
						   <div class="img-title"
							style="height: 150px; padding-top: 80px;"
							align="center" onClick="deleteWish(${w[4]})">
							<span class="glyphicon glyphicon-trash" style="width: 80px; height: 20px;"></span>
						   </div>
					    <!-- </a> -->
				    </div><a
						href="${ctx }/personal/wish/${w[4]}">
						<!--                           sampleId、 sTitle、sSubject、wishId   -->
						<div style="padding-left: 15px; padding-right: 15px;">
							<h6>[${w[3]}]${w[2] }</h6>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>

        <input type="hidden" value ="${session }" name="session"/>
	</div>

	<%-- <div class="row margin_head">
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
		</div> --%>

	<script src="${ctx }/static/js/jquery.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/js/js-shelter/personal_wish.js"></script>

</body>
</html>