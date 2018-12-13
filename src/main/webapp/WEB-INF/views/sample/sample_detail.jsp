<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>

<link href="${ctx }/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/static/css/shelter-style.css" rel="stylesheet">
<title>Shelter | 案例详情</title>

</head>
<body>

	<div class="row margin_head">

		<div class="col-md-8 primary_left">
			<!-- 封面 -->
			<div class="col-md-12 details_head">
				<div style="float: left">
					<img src=${sample.coverAdd } width="480" height="300">
				</div>
				<div class="details_title">
					<h3>${sample.title }</h3>
				</div>
			</div>
		</div>

		<!-- 商家信息 -->
		<div class="col-md-3 brand">
			<div class="brand_title">商家信息</div>
			<div style="float: left;">
				<img src="http://tgi12.jia.com/106/881/6881435.jpg" width="60"
					height="60">
			</div>
			<div style="margin-left: 80px;">
				<a href="#">${sample.brand }</a>
			</div>
		</div>
	</div>

	<div class="col-md-12">

		<!-- 设计方案（照片展示） -->
		<!-- style="margin-top: 25px; padding: 0px 0px 20px 20px;" -->
		<div class="col-md-8 design_left">

			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#home"
					aria-controls="design" role="tab" data-toggle="tab">设计方案</a></li>
				<li role="presentation"><a href="#profile"
					aria-controls="question" role="tab" data-toggle="tab">我要提问</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<!-- 设计方案 -->
				<div role="tabpanel" class="tab-pane active design" id="design">
					<div id="layout" class="design_room">
						<h3 class="design_roomTitle">全屋户型</h3>
						<img src=${sample.layoutAdd } class="design_image">
						<p>${sample.title }平面方案布置图</p>
					</div>

					<div id="living">
						<h3 class="design_roomTitle col-md-10">客厅</h3>
						<div id="living1" class="design_room">
							<img id="liv1" src=${sample.livingAdd1 } class="design_image">
							<p>${sample.livingNote1 }</p>
						</div>

						<div id="living2" class="design_room">
							<img id="liv2" src=${sample.livingAdd2 } class="design_image">
							<p>${sample.livingNote2 }</p>
						</div>

						<div id="living3" class="design_room">
							<img id="liv3" src=${sample.livingAdd3 } class="design_image">
							<p>${sample.livingNote3 }</p>
						</div>
					</div>

					<div id="bedroom">
						<h3 class="design_roomTitle">卧室</h3>
						<div id="bedroom1" class="design_room">
							<img id="bed1" src=${sample.bedroomAdd1 } class="design_image">
							<p>${sample.bedroomNote1 }</p>
						</div>

						<div id="bedroom2" class="design_room">
							<img id="bed2" src=${sample.bedroomAdd2 } class="design_image">
							<p>${sample.bedroomNote2 }</p>
						</div>

						<div id="bedroom3" class="design_room">
							<img id="bed3" src=${sample.bedroomAdd3 } class="design_image">
							<p>${sample.bedroomNote3 }</p>
						</div>
					</div>

					<div id="kitchen">
						<h3>厨房</h3>
						<div id="kitchen1" class="design_room">
							<img id="kit1" src=${sample.kitchenAdd1 } class="design_image">
							<p>${sample.kitchenNote1 }</p>
						</div>

						<div id="kitchen2" class="design_room">
							<img id="kit2" src=${sample.kitchenAdd2 } class="design_image">
							<p>${sample.kitchenNote2 }</p>
						</div>

						<div id="kitchen3" class="design_room">
							<img id="kit3" src=${sample.kitchenAdd3 } class="design_image">
							<p>${sample.kitchenNote3 }</p>
						</div>
					</div>

					<div id="tiolet">
						<h3 class="design_roomTitle">卫生间</h3>
						<div id="tiolet1" class="design_room">
							<img id="tio1" src=${sample.tioletAdd1 } class="design_image">
							<p>${sample.tioletNote1 }</p>
						</div>

						<div id="tiolet2" class="design_room">
							<img id="tio2" src=${sample.tioletAdd2 } class="design_image">
							<p>${sample.tioletNote2 }</p>
						</div>

						<div id="tiolet3" class="design_room">
							<img id="tio3" src=${sample.tioletAdd3 } class="design_image">
							<p>${sample.tioletNote3 }</p>
						</div>
					</div>

					<div id="dinning">
						<h3 class="design_roomTitle">餐厅</h3>
						<div id="dinning1" class="design_room">
							<img id="din1" src=${sample.dinningAdd1 } class="design_image">
							<p>${sample.dinningNote1 }</p>
						</div>

						<div id="dinning2" class="design_room">
							<img id="din2" src=${sample.dinningAdd2 } class="design_image">
							<p>${sample.dinningNote2 }</p>
						</div>

						<div id="dinning3" class="design_room">
							<img id="din3" src=${sample.dinningAdd3 } class="design_image">
							<p>${sample.dinningNote3 }</p>
						</div>
					</div>

					<div id="child">
						<h3 class="design_roomTitle">儿童房</h3>
						<div id="child1" class="design_room">
							<img id="chi1" src=${sample.childAdd1 } class="design_image">
							<p>${sample.childNote1 }</p>
						</div>

						<div id="child2" class="design_room">
							<img id="chi2" src=${sample.childAdd2 } class="design_image">
							<p>${sample.childNote2 }</p>
						</div>

						<div id="child3" class="design_room">
							<img id="chi3" src=${sample.childAdd3 } class="design_image">
							<p>${sample.childNote3 }</p>
						</div>
					</div>

					<div id="study">
						<h3 class="design_roomTitle">书房</h3>
						<div id="study1" class="design_room">
							<img id="stu1" src=${sample.studyAdd1 } class="design_image">
							<p>${sample.studyNote1 }</p>
						</div>

						<div id="study2" class="design_room">
							<img id="stu2" src=${sample.studyAdd2 } class="design_image">
							<p>${sample.studyNote2 }</p>
						</div>

						<div id="study3" class="design_room">
							<img id="stu3" id="studyImg3" src=${sample.studyAdd3 }
								class="design_image">
							<p>${sample.studyNote3 }</p>
						</div>
					</div>
				</div>

				<!-- 我要提问 -->
				<div role="tabpanel" class="tab-pane" id="question">...</div>
			</div>



		</div>

		<!-- 装修列表 -->
		<div class="col-md-3 design_detail">
		    <h5 class="brand_title">建材家具清单</h5>
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				
				<c:forEach items="${ sdLists}" var="sd">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#${sd.subjectTitle }" aria-expanded="true"
									aria-controls="collapseOne"> ${sd.subjectTitle } </a>
							</h4>
						</div>
						<div class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingOne" id=${sd.subjectTitle } >
							<div class="panel-body">
								<!-- 建筑材料 -->
								<c:forEach items="${sd.materialList }" var="m">
									<div class="col-md-12">
										<img class="col-md-3" src=${m[11] } width="50" height="50">
										<h6 class="col-md-7">${m[3] }</h6>
										<h5 class="col-md-2">￥${m[4] }</h5>
									</div>
								</c:forEach>

								<!-- 家居 -->
								<c:forEach items="${sd.furnitureList }" var="f">
									<div class="col-md-12">
										<img class="col-md-3" src=${f[10] } width="50" height="50">
										<h6 class="col-md-7">${f[3] }</h6>
										<h5 class="col-md-2">￥${f[4] }</h5>
									</div>
								</c:forEach>
								
								<div class="col-md-12">
								<button type="button" class="btn btn-danger" style="width:100%; margin:10px 0px 0px 8px;" onClick="addToWish(${sampleId})">加入装修心愿单</button>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<input type="hidden" value ="${session }" name="session"/>
	</div>

	<script src="${ctx }/static/js/jquery.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/js/js-shelter/sample_detail.js"></script>
</body>
</html>