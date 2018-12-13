<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<link href="${ctx }/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/static/css/shelter-style.css" rel="stylesheet">
<title>Shelter | 我的收藏</title>
</head>
<body>
	<div class="container margin_head">
		<ul class="breadcrumb" style="margin-left: -80px;">
			<li>我的收藏</li>
			<li class="active"></li>
		</ul>
		
		<div>
		<c:forEach items="${materials }" var="m">
			<div class="col-md-12" style="margin-bottom:10px;">
				<img class="col-md-3" src=${m[11] } style="width:80px; height:80px; padding:0px;">
				<h6 class="col-md-7">${m[3] }</h6>
				<h5 class="col-md-2">￥${m[4] }</h5>
				                                             <%-- ${m[0] } materialId --%>
				<button class="btn btn-warning" onclick="openModal(${m[0]})">加入心愿单</button>

			</div>
		</c:forEach>
		
		
	</div>
	</div>
	
	<div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">选择心愿单</h4>
      </div>
      <div id="addToWishModal" class="modal-body">
         <div id="colors" style="margin-bottom:30px;"></div>
         <div id="wishes"  style="height:300px; overflow:scroll;">
             <c:forEach items="${wishes }" var="wish">
                 <div id="wish_${wish[4] }" class="col-md-12" onClick="changeWishClazz(${wish[4] })" style=" margin-bottom: 10px;">
                     <img class="col-md-3" src=${wish[0] } style="height:120; width:200;">
                     <h6>[${wish[3] }] ${wish[2] }</h6>
                 </div>
             </c:forEach>
         </div>
      </div>
      <div class="modal-footer">
      <p>* 请确认选择完所有选项后点击“确认添加”按钮。</p>
        <button type="button" id="addMaterialToWish" class="btn btn-danger" onclick="addMaterialToWish()">确认添加</button>
      </div>
    </div>
  </div>
</div>

		<input type="hidden" value ="${session }" name="session"/>

	</div>
	
	<script src="${ctx }/static/js/jquery.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/js/js-shelter/personal_favorite.js"></script>

</body>
</html>