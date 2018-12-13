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
<title>建材详情 | Shelter</title>
<style>
</style>
</head>
<body>

	<!-- 所有类目 -->
	<div style="margin-top: 70px;">
		<div class="col-md-12 col-xs-12 ">
			<p class="category-head ">所有类目</p>

			<!-- 风格 -->
			<div class="panel panel-default category-border " id="style">
				<div class="panel" role="tab">
					<div class="col-md-1">
						<label class="category-head" onClick="selectStyle()"> 风格：
						</label>
					</div>

					<div class="col-md-1" id="stye1">
						<label class="radio-inline"> <input type="radio"
							name="style" id="inlineRadio1" value="现代"
							onclick="selectStyle(id)"> 现代
						</label>
					</div>
					<div class="col-md-1" id="style2">
						<label class="radio-inline"> <input type="radio"
							name="style" id="inlineRadio2" value="中式"
							onclick="selectStyle(id)"> 中式
						</label>
					</div>
					<div class="col-md-1" id="style3">
						<label class="radio-inline"> <input type="radio"
							name="style" id="inlineRadio3" value="欧式"
							onclick="selectStyle(id)"> 欧式
						</label>
					</div>
					<div class="col-md-1" id="style4">
						<label class="radio-inline"> <input type="radio"
							name="style" id="inlineRadio4" value="中式现代"
							onclick="selectStyle(id)"> 中式现代
						</label>
					</div>
					<div class="col-md-1" id="style5">
						<label class="radio-inline"> <input type="radio"
							name="style" id="inlineRadio5" value="欧式现代"
							onclick="selectStyle(id)"> 欧式现代
						</label>
					</div>
					<div class="col-md-1" id="style6">
						<label class="radio-inline"> <input type="radio"
							name="style" id="inlineRadio6" value="中式古典"
							onclick="selectStyle(id)"> 中式古典
						</label>
					</div>
					<div class="col-md-1" id="style7">
						<label class="radio-inline"> <input type="radio"
							name="style" id="inlineRadio7" value="欧式古典"
							onclick="selectStyle(id)"> 欧式古典
						</label>
					</div>
					<div class="col-md-1" id="style8">
						<label class="radio-inline"> <input type="radio"
							name="style" id="inlineRadio8" value="古典"
							onclick="selectStyle(id)"> 古典
						</label>
					</div>
					<div class="col-md-1" id="style9">
						<label class="radio-inline"> <input type="radio"
							name="style" id="inlineRadio9" value="田园"
							onclick="selectStyle(id)"> 田园
						</label>
					</div>
					<div class="col-md-1" id="style10">
						<label class="radio-inline"> <input type="radio"
							name="style" id="inlineRadio10" value="其他"
							onclick="selectStyle(id)"> 其他
						</label>
					</div>
				</div>
			</div>



			<!-- 材质 -->
			<div class="panel panel-default category-border" id="texture">
				<div class="panel" role="tab">
					<div class="col-md-1">
						<label class="category-head" onClick="selectTexture()">
							材质： </label>
					</div>

					<div class="col-md-1" id="stye1">
						<label class="radio-inline"> <input type="radio"
							name=texture id="textureRadio1" value="PVC"
							onclick="selectTexture(id)"> PVC
						</label>
					</div>
					<div class="col-md-1" id="texture2">
						<label class="radio-inline"> <input type="radio"
							name="texture" id="textureRadio2" value="枫木"
							onclick="selectTexture(id)"> 枫木
						</label>
					</div>
					<div class="col-md-1" id="texture3">
						<label class="radio-inline"> <input type="radio"
							name="texture" id="textureRadio3" value="橡木"
							onclick="selectTexture(id)"> 橡木
						</label>
					</div>
					<div class="col-md-1" id="texture4">
						<label class="radio-inline"> <input type="radio"
							name="texture" id="textureRadio4" value="木塑"
							onclick="selectTexture(id)"> 木塑
						</label>
					</div>
					<div class="col-md-1" id="texture5">
						<label class="radio-inline"> <input type="radio"
							name="texture" id="textureRadio5" value="PP"
							onclick="selectTexture(id)"> PP
						</label>
					</div>
					<div class="col-md-1" id="texture6">
						<label class="radio-inline"> <input type="radio"
							name="texture" id="textureRadio6" value="榆木"
							onclick="selectTexture(id)"> 榆木
						</label>
					</div>
					<div class="col-md-1" id="texture7">
						<label class="radio-inline"> <input type="radio"
							name="texture" id="textureRadio7" value="塑料"
							onclick="selectTexture(id)"> 塑料
						</label>
					</div>
					<div class="col-md-1" id="texture8">
						<label class="radio-inline"> <input type="radio"
							name="texture" id="textureRadio8" value="柚木"
							onclick="selectTexture(id)"> 柚木
						</label>
					</div>
					<div class="col-md-1" id="texture9">
						<label class="radio-inline"> <input type="radio"
							name="texture" id="textureRadio9" value="石塑"
							onclick="selectTexture(id)"> 石塑
						</label>
					</div>
					<div class="col-md-1" id="texture10">
						<label class="radio-inline"> <input type="radio"
							name="texture" id="textureRadio10" value="聚合木"
							onclick="selectTexture(id)"> 聚合木
						</label>
					</div>
					<label class="panel-title" style="float: right;"> <span
						id="spanTexture"
						class="glyphicon glyphicon-chevron-down category-more"
						onclick="showMoreTexture(id)"></span>
					</label>
				</div>
				<div id="collapseTexture" class="panel-collapse collapse"
					role="tabpanel" aria-labelledby="headingTwo">
					<div class="panel-body"
						style="padding-left: 0px; padding-right: 0px">
						<div class="col-md-offset-1 col-md-1" id="texture11">
							<label class="radio-inline"> <input type="radio"
								name="texture" id="textureRadio11" value="软木"> 软木
							</label>
						</div>
						<div class="col-md-1" id="texture12">
							<label class="radio-inline"> <input type="radio"
								name="texture" id="textureRadio12" value="松木"> 松木
							</label>
						</div>
						<div class="col-md-1" id="texture13">
							<label class="radio-inline"> <input type="radio"
								name="texture" id="textureRadio13" value="橡胶"> 橡胶
							</label>
						</div>
						<div class="col-md-1" id="texture14">
							<label class="radio-inline"> <input type="radio"
								name="texture" id="textureRadio14" value="其他"> 其他
							</label>
						</div>
					</div>
				</div>
			</div>



			<!-- 适用范围 -->
			<div class="panel panel-default category-border" id="fit">
				<div class="panel" role="tab">
					<div class="col-md-1">
						<label class="category-head"> 适用范围： </label>
					</div>

					<div class="col-md-1" id="stye1">
						<label class="radio-inline"> <input type="radio"
							name="fit" id="fitRadio1" value="客厅" onclick="selectFit(id)">
							客厅
						</label>
					</div>
					<div class="col-md-1" id="fit2">
						<label class="radio-inline"> <input type="radio"
							name="fit" id="fitRadio2" value="卧室" onclick="selectFit(id)">
							卧室
						</label>
					</div>
					<div class="col-md-1" id="fit3">
						<label class="radio-inline"> <input type="radio"
							name="fit" id="fitRadio3" value="走廊" onclick="selectFit(id)">
							走廊
						</label>
					</div>
					<div class="col-md-1" id="fit4">
						<label class="radio-inline"> <input type="radio"
							name="fit" id="fitRadio4" value="卫浴" onclick="selectFit(id)">
							卫浴
						</label>
					</div>
					<div class="col-md-1" id="fit5">
						<label class="radio-inline"> <input type="radio"
							name="fit" id="fitRadio5" value="其他" onclick="selectFit(id)">
							其他
						</label>
					</div>
				</div>
			</div>


			<!-- 价格 -->
			<div class="panel panel-default category-border" id="price">
				<div class="panel" role="tab">
					<div class="col-md-1">
						<label class="category-head" onClick="selectPrice()"> 价格：
						</label>
					</div>

					<div class="col-md-1" id="stye1">
						<label class="radio-inline"> <input type="radio"
							name="price" id="priceRadio1" value="0-100"
							onclick="selectPrice(id)"> 0-100
						</label>
					</div>
					<div class="col-md-1" id="price2">
						<label class="radio-inline"> <input type="radio"
							name="price" id="priceRadio2" value="100-200"
							onclick="selectPrice(id)"> 100-200
						</label>
					</div>
					<div class="col-md-1" id="price3">
						<label class="radio-inline"> <input type="radio"
							name="price" id="priceRadio3" value="200-500"
							onclick="selectPrice(id)"> 200-500
						</label>
					</div>
					<div class="col-md-1" id="price4">
						<label class="radio-inline"> <input type="radio"
							name="price" id="priceRadio4" value="500-1500"
							onclick="selectPrice(id)"> 500-1500
						</label>
					</div>
					<div class="col-md-1" id="price5" style="width: 125px;">
						<label class="radio-inline"> <input type="radio"
							name="price" id="priceRadio5" value="1500-60000"
							onclick="selectPrice(id)"> 1500-60000
						</label>
					</div>
					<div class="col-md-1" id="price6">
						<label class="radio-inline"> <input type="radio"
							name="price" id="priceRadio6" value="60000+"
							onclick="selectPrice(id)"> 60000+
						</label>
					</div>
					<div class="col-md-2" id="price7">
						<label class="radio-inline"> <input type="radio"
							name="price" id="priceRadio7" value="自定义"
							onclick="selectPrice(id)"> 自定义
						</label>
					</div>
				</div>
			</div>

			<div style="width: 10px; margin-bottom: 30px;">
				<button type="button" class="btn btn-danger" onClick="search()">搜索</button>
			</div>

		</div>
		<!-- Over: 所有类目 -->


		<!-- 建材列表 -->
		<div id=categoryList>
			<c:forEach items="${ categories}" var="c">
				<div class="col-md-3 col-xs-12">
					<img src=${c[11] } width="200" height="200">
					<div style="padding-left: 15px; padding-right: 15px;">
						<h4 class="price">
						       ￥${c[4] }
						   <span name="favor" id="favor_${c[0] }" class="${c[20] }" style="right: -100;" onClick="favor(${c[0] })"></span> 
						</h4>
						<h6>${c[3] }</h6>
						<h6 class="category-head">${c[5] }</h6>
					</div>
				</div>
			</c:forEach>
		</div>

        <input type="hidden" value ="${session }" name="session"/>
	</div>

	<script src="${ctx }/static/js/jquery.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/js/js-shelter/material_category.js"></script>

</body>
</html>




