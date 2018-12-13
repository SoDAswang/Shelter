<%@page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>


<link href="${ctx }/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/static/css/shelter-style.css" rel="stylesheet">
<title>Shelter | 我的心愿单详情</title>

</head>
<body>
	<div class="container margin_head">
		<ul class="breadcrumb col-md-4" style="margin-left: -80px;">
			<li><a href="${ctx }/personal/wish">装修心愿单</a></li>
			<li>[${subject }]${title }</li>
			<li class="active"></li>
		</ul>

		<div class="col-md-8" style="margin-left: 80px;" align="right">
			输入实际房间尺寸，Shelter将为您生成最合适的材料清单。
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-danger experience"
				onclick="openModal()">立即体验</button>
		</div>

		<div id="list" class="col-md-12">
			<table class="table">
				<tr>
					<th><input type="checkbox"
						style="-webkit-appearance: checkbox" onClick="selectAll()">全选</input></th>
					<th colspan="3">商品信息</th>
					<th>单价</th>
					<th>数量</th>
					<th>金额</th>
					<th>
						<button id="manage" type="button" class="btn btn-warning a"
							data-toggle="popover" data-html="true" onclick="manage()"
							data-placement="bottom"
							data-content="
					         <a onClick='removeSelected(${wishId })'><span class='glyphicon glyphicon-trash' title='删除选中'></span></a>
					         <a href='${ctx }/personal/wish/restore/${wishId }' style='margin-left:10px;'><span class='glyphicon glyphicon-refresh' title='还原'></span></a>
				           ">管理</button>

					</th>
				</tr>
				<c:forEach items="${materialList }" var="m">
				    <!-- ${m[17] } sm.id  -->
					<tr id="material_${m[17] }" class="wishTable">
						<td><label class="checkbox-inline"> <input
								type="checkbox" id="inlineCheckbox_${m[17]}"
								value="option_${m[17]}" style="-webkit-appearance: checkbox"
								name="checkbox">
						</label></td>
						<td><img src=${m[11] } width="80" height="80"></td>
						<td style="width:200px;"><span title="${m[12] }">${m[3] }</span></td>
						<td style="width:150px;">
						   <div class="edit">
						         <div name="materialList_color" id="color_${m[17] }"  class="a" onClick="edit(${m[0] }, ${m[17] })"
													data-container="body" data-toggle="popover"
													data-placement="bottom" data-html="true" title=""
													data-content=''>
									       ${m[16] }
									       <span class="glyphicon glyphicon-pencil" style="z-index: 1;" ></span>
									       
								 </div>
						    </div>
						</td>
						<td>￥<span id="unitPrice_${m[17] }">${m[4] }</span></td>
						<td><span class="glyphicon glyphicon-minus" onClick="minus()"></span>
							<input id="amount_${m[17] }" value="1" class="detail-amount">
							<span class="glyphicon glyphicon-plus" onClick="plus()"></span></td>
						<td style="width:100px;">￥<span id="price_${m[17]}" name="sum">${m[4] }</span></td>
						<td><a href="#"><span class="glyphicon glyphicon-trash" title="删除"
							onClick="removeMaterial(${m[17]})"></span></a></td>
					</tr>
				</c:forEach>

			</table>
			
			<hr size='5' />
            <div align="right">
                <span>合计:</span>
                <span id="total"></span>
                <button type="button" class="btn btn-danger">提交订单</button>
            </div>
            
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Shelter 建材计算</h4>
				</div>
				<form class="form-horizontal" onsubmit="return false"
					action="${ctx }/personal/wish/calculate/${wishId }" method="post"
					id="form_calculate">
					<div class="modal-body">
						<div id="normal">
							<div class="form-group">
								<label class="col-sm-3 control-label">墙面面积</label>
								<div class="col-sm-9" style="left: 5px;">
									<input type="hidden" id="wishId" value=${wishId }>
									<div class="col-sm-12 form-inline" id="add_wall">
										<div class="form-group" id="wall1"
											style="margin-bottom: 10px;">
											<!-- <label class="control-label">墙面1</label>  --><input type="number"
												class="form-control" id="wall_s1"
												name="wall_s1"> <span>㎡</span>
											<c:forEach items="${distinctWallList }" var="dw">
												<label class="radio-inline a"
													onClick="color(${wishId }, ${dw[0] }, 1)"> <input
													class="a" type="radio" id="wall_s1_${dw[0] }"
													name="wallMaterial${dw[0] }" value=${dw[0] }
													data-container="body" data-toggle="popover"
													data-placement="left" data-html="true" title=""
													data-content=''> <img src=${dw[1] } title="${dw[2] }" width="40"
													class="a" height="40">
												</label>
											</c:forEach>
											<p id="wall1_kind" name="tip" style="color: grey"></p>
											<input type="hidden" name="materialId" id="wall1_materialId" />
											<input type="hidden" name="color" id="wall1_color" />
											<input type="hidden" name="orderGoods" id="wall1_orderGoods" />
										</div>
									</div>
									<div class="col-sm-12">
										<button type="button" class="btn btn-link"
											style="color: #65e63d;" onClick="add_wall(${wishId })">
											<span class="glyphicon glyphicon-plus"></span>添加墙面
										</button>
										<button type="button" class="btn btn-link"
											style="color: #fb3621;" onClick="remove_wall()">
											<span class="glyphicon glyphicon-minus"></span>删除墙面
										</button>
									</div>
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-sm-3 control-label">天花板面积</label>
								<div class="col-sm-9" style="left: 20px;">
									<div class="form-inline">
										<div class="form-group">
											<input type="number" class="form-control" name="ceiling_s"> <span>㎡</span>
										</div>
									</div>
								</div>
							</div> -->

							<div class="form-group">
								<label class="col-sm-3 control-label">地面面积</label>
								<div class="col-sm-9" style="left: 20px;">
									<div class="form-inline">
										<div class="form-group">
											<input type="number" class="form-control" name="floor_s"
												id="floor_s"> <span>㎡</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button onClick="submitCalculate()" class="btn btn-warning">开始计算</button>
					</div>
				</form>
			</div>
		</div>
		
		<input type="hidden" value ="${session }" name="session"/>
	</div>

	<script src="${ctx }/static/js/jquery.min.js"></script>
	<script src="${ctx }/static/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/js/js-shelter/personal_wish_detail.js"></script>

</body>
</html>