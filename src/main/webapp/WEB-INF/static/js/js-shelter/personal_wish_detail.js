var wallcount = 1;
var check = false;

$(function() {
	var colors = $("[name='materialList_color']");
	for (var i = 0; i < colors.length; i++) {
		if (colors[i].innerText == "") {
			colors[i].parentElement.remove();
		}
	}
	
//	Calculate total.
	var total = 0;
	for(var i=0; i<$("[name='sum']").length; i++) {
		total += parseFloat($("[name='sum']")[i].textContent);	
	}
	total = total.toFixed(2);
	$("#total")[0].textContent = total;

});

$('body').on('click', function(event) {
	var children = $(".popover").find('*'); // 查询出popover下所有的子孙元素
	var target = $(event.target); // 当前点击的元素
	if (!target.hasClass("a")) {
		var bool = true;
		for (var i = 0; i < children.length; i++) {
			if (children[i] === event.target) { // 判断点击的元素是否在popover中
				bool = false;
			}
		}
		if (bool) {
			$(".popover").popover('hide');
		}
	}
});

function total() {
	var total = 0;
	
	for(var i=0; i<$("[name='sum']").length; i++) {
		total += parseFloat($("[name='sum']")[i].textContent);	
	}
	
	total = total.toFixed(2);
	
	$("#total")[0].textContent = total;
	
}

function hide(materialId, count, wishId) {
	console.log(materialId)
	var title = event.target.parentElement.parentElement.firstElementChild.textContent;
	var color = event.target.parentElement.firstElementChild.value
	$('#' + materialId.id).popover('hide');
	$('#wall' + count + '_kind').text(title + " " + color);
	$('#wall' + count + '_materialId').val(materialId.value);
	$('#wall' + count + '_color').val(color);
	
	var params = {};
	params.materialId = materialId.id.slice(8);
	params.color = color;
	params.wishId = wishId;
	$.ajax({
		type : "POST",
		dataType : "json",
		data: params,
		url : "/shelter/personal/wish/findOrderGoodsId",
		success : function(data) {
			console.log(data);
			$('#wall' + count + '_orderGoods').val("wall_orderGoodsId_" + data.orderGoodsId);
		}
	});
}

function hideMaterialListPopover(orderGoodsId) {
	var color = event.target.textContent;
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/shelter/personal/wish/orderGoods/" + orderGoodsId,
		success : function(data) {
			if (data.statusCode == 200) {
				var originalColor = data.orderGoods.color;
				// Original color not equals the selected color.
				if (originalColor != color) {
					var params = {};
					params.orderGoodsId = orderGoodsId;
					params.color = color;
					$.ajax({
						type : "POST",
						dataType : "json",
						data: params,
						url : "/shelter/personal/wish/editColor",
						success : function(data) {
							if (data.statusCode == 200) {
								if (data.orderGoodsIdConflicted != 0) {
									$("#material_" + data.orderGoodsIdConflicted).remove();
//									$("[value='wall_orderGoodsId_"+ orderGoodsId +"']")[0].parentElement.remove();
									var modelColors = $("[name='color']");
									for (var i=0; i<modelColors.length; i++) {
										if (modelColors[i].value == originalColor) {
											modelColors[i].parentElement.remove();
											wallcount --;
										}
									}
									$("#color_"+orderGoodsId)[0].firstChild.textContent  = "颜色："+color;
								}
							}
						}
					});
				}
			}
		}
	});
	
	$('#color_' + orderGoodsId).popover('hide');
}

function color(wishId, materialId, count) {
	$
			.ajax({
				type : "POST",// 方法类型
				dataType : "json",// 预期服务器返回的数据类型
				url : "/shelter/personal/wish/color/" + wishId + "/"
						+ materialId,
				success : function(data) {
					console.log(data);// 打印服务端返回的数据(调试用)
					if (data.statusCode == 200) {
						var div = "<p>" + data.title + "</p>";
						data.color
								.forEach(function(color) {
									div += "<p><input type='radio' name='"
											+ materialId
											+ $.trim(color)
											+ "' id='"
											+ materialId
											+ $.trim(color)
											+ "' value='"
											+ $.trim(color)
											+ "'><span style='cursor:pointer;' onClick='hide(wall_s"
											+ count + "_" + materialId + ", "
											+ count + ", "+ wishId +")'>" + color
											+ "</span></p>";
								});
						$('#wall_s' + count + '_' + materialId).attr(
								'data-content', div);
						$('#wall_s' + count + '_' + materialId).popover("show");
					}
					;
				},
				error : function() {
					alert("异常！");
				}
			});

}

function minus() {
	var amount = parseInt(event.target.parentElement.children[1].value) - 1;
	if (amount < 2)
		amount = 1;

	document.getElementById(event.target.parentElement.children[1].id).value = amount;

	var unitPrice = parseFloat(event.target.parentElement.parentElement.children[4].firstElementChild.textContent);
	var priceId = event.target.parentElement.parentElement.children[6].firstElementChild.id;

	var price = (unitPrice * amount).toFixed(2);
	;

	$("#" + priceId).text(price);

	total();
}

function plus() {
	var amount = parseInt(event.target.parentElement.children[1].value) + 1;
	document.getElementById(event.target.parentElement.children[1].id).value = amount;

	var unitPrice = parseFloat(event.target.parentElement.parentElement.children[4].firstElementChild.textContent);
	var priceId = event.target.parentElement.parentElement.children[6].firstElementChild.id;

	var price = (unitPrice * amount).toFixed(2);

	$("#" + priceId).text(price);
    
	total();
}

function openModal() {
	$("#myModal").modal('show');
}

function add_wall(wishId) {
	if (wallcount < 9) {
		wallcount = wallcount + 1;
		var wall = "<div class='form-group' id='wall" + wallcount
				+ "'  style='margin-bottom:10px;'>";
		/*wall += "<label class='control-label'>墙面" + wallcount + "</label>";*/
		wall += "<input type='number' class='form-control' id='wall_s"
				+ wallcount + "' name='wall_s" + wallcount + "'>";
		wall += "<span style='margin-left:2px'>㎡</span>";

		var params = {};
		params.wishId = wishId;
		$
				.ajax({
					type : "POST",
					dataType : "json",
					url : "/shelter/personal/wish/wallMaterial/" + wishId,
					data : params,
					success : function(data) {
						console.log(data);// 打印服务端返回的数据(调试用)
						if (data.statusCode == 200) {
							var distinctWallList = data.distinctWallList;
							for ( var item in distinctWallList) {
								wall += "<label class='radio-inline' onClick='color("
										+ wishId
										+ ", "
										+ distinctWallList[item][0]
										+ ", " + wallcount + ")'>";
								wall += "<input type='radio' id='wall_s"
										+ wallcount
										+ "_"
										+ distinctWallList[item][0]
										+ "' name='wallMaterial"
										+ distinctWallList[item][0]
										+ "' value='"
										+ distinctWallList[item][0]
										+ "' data-container='body' data-toggle='popover' data-placement='left' data-html='true' title='' data-content=''>";
								wall += "<img src='" + distinctWallList[item][1]
										+ "' title='" + distinctWallList[item][2]
										+ "' width='40' height='40'>";
								wall += "</label>";
							}
							wall += "<p id='wall" + wallcount
									+ "_kind' name='tip' style='color:grey'></p>";
							wall += "<input type='hidden' name='materialId' id='wall"
									+ wallcount + "_materialId'/>";
							wall += "<input type='hidden' name='color' id='wall"
									+ wallcount + "_color'/>";
							wall += "<input type='hidden' name='orderGoods' id='wall"
								+ wallcount + "_orderGoods'/>";
							wall += "</div>";
							$("#add_wall").append(wall);
						}
					},
					error : function() {
						alert("异常！");
					}
				});
	} else {
		alert("墙面数量已达上限！");
	}
	
}

function remove_wall() {
	if (wallcount > 1) {
		$("#wall" + wallcount).remove();
		wallcount = wallcount - 1;
	}
}

function submitCalculate() {
	var params = {};
	var wallInfo = new Array();
	var walls = $('div[id="add_wall"]').find('div');
	wallInfo.push([ walls.find('input[id="wall1_materialId"]')[0].value,
			walls.find('input[id="wall1_color"]')[0].value,
			walls.find('input[id="wall_s1"]')[0].value ]);
	for (var i = 2; i <= walls.length; i++) {
		var materialId = walls.find('input[id="wall' + i + '_materialId"]')[0].value;
		var color = walls.find('input[id="wall' + i + '_color"]')[0].value;
		var square = walls.find('input[id="wall_s' + i + '"]')[0].value;
		var flag = false;
		for (var j = 0; j < wallInfo.length; j++) {
			console.log(wallInfo[j][0]);
			console.log(wallInfo[j][1]);
			if (materialId === wallInfo[j][0] && color === wallInfo[j][1]) {
				wallInfo[j][2] = (parseInt(wallInfo[j][2]) + parseInt(square))
						.toString();
				flag = true;
				break;
			}
		}
		if (flag == false) {
			wallInfo.push([ materialId, color, square ]);
		}
	}
	params.wallInfo = JSON.stringify(wallInfo);
	params.floor_s = $('#floor_s').val();
	console.log(params);

	$.ajax({
		// 几个参数需要注意一下
		type : "POST",// 方法类型
		dataType : "json",// 预期服务器返回的数据类型
		url : event.target.parentElement.parentElement.action.slice(21), // url
		// data: $('#form_calculate').serialize(),
		data : params,
		success : function(data) {
			console.log(data);// 打印服务端返回的数据(调试用)
			if (data.statusCode == 200) {
				console.log(data.wallAccount);
				var wallAccount = data.wallAccount;
				for (var i = 0; i < wallAccount.length; i++) {
					$('#' + wallAccount[i][0]).val(wallAccount[i][1]);
				}
				$("#" + data.floor_amount_id).val(data.floor_amount);
				$("#myModal").modal('hide');
				
				total();
			}
			;
		},
		error : function() {
			alert("请确定所有项目填选完毕！");
		}
	});
}

function selectAll() {
//	document.getElementsByName("checkbox").forEach(function(item) {
//		if (check == false) {
//			item.checked = checked;
//		}
//		if (check == true) {
//			item.checked = !checked;
//		}
//		check = !check;
//		// item.checked = !item.checked;
//	});
	
//	 jQuery写法 
	 for(var i=0; i<$("[name='checkbox']").length; i++) {
		 if ($("[name='checkbox']")[i].checked == false) {
			 $("[name='checkbox']")[i].checked = true;
			}
			if ($("[name='checkbox']")[i].checked == true) {
				$("[name='checkbox']")[i].checked = false;
			}
//			check = !check;
//	 $("[name='checkbox']")[i].checked = !$("[name='checkbox']")[i].checked; 
	 }
	 
}

function manage() {
	$("#manage").popover("show");
	$(".popover").css("z-index", "999");
}

function removeSelected(wishId) {
	var params = {};
	var orderGoodsIds = new Array();
	for (var i = 0; i < $("[name='checkbox']").length; i++) {
		if ($("[name='checkbox']")[i].checked == true) {
			var orderGoodsId = $("[name='checkbox']")[i].id.slice(15);
			orderGoodsIds.push(orderGoodsId);
		}
	}
	if (orderGoodsIds.length > 0) {
		params.orderGoodsIds = JSON.stringify(orderGoodsIds);
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "/shelter/personal/wish/" + wishId + "/removeSelected/",
			data : params,
			success : function(data) {
				if (data.statusCode == 200) {
					orderGoodsIds.forEach(function(og) {
						$("#material_" + og).remove();
						data.colorByDeletedGoods.forEach(function (color) {
							
							// delete wall in Model
							var modelColors = $("[name='color']");
							for (var i=0; i<modelColors.length; i++) {
								if (modelColors[i].value == color) {
									if (wallcount < 2) {
										$("[name='tip']")[0].innerText = "";
										$("[name='materialId']").val("");
										$("[name='color']").val("");
										$("[name='orderGoods']").val("");
									} else {
										modelColors[i].parentElement.remove();
										wallcount --;
									}
									
								}
							} 
						});
					});
				}
			}
		});
	} else {
		alert("请先选中要删除的商品！");
	}

}

function removeMaterial(orderGoodsId) {
	var params = {};
	params.orderGoodsId = orderGoodsId;
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/shelter/personal/wish/removeMaterial",
		data : params,
		success : function(data) {
			if (data.statusCode == 200) {
				// delete material
				$("#material_" + orderGoodsId).remove();
				
				// delete wall in Model
				var item = $("[value='wall_orderGoodsId_"+ orderGoodsId +"']");
				if(item) {
					if (wallcount == 1) {
						$("[name='tip']")[0].innerText = "";
						$("[name='materialId']").val("");
						$("[name='color']").val("");
						$("[name='orderGoods']").val("");
					} 
					if (wallcount > 1) {
						var modelColors = $("[name='color']");
						for (var i=0; i<modelColors.length; i++) {
							if (modelColors[i].value == data.orderGoods.color) {
								modelColors[i].parentElement.remove();
								wallcount --;
							}
						}
					}
				}
			}
		}
	});
}

function edit(materialId, orderGoodsId) {
	var params = {};
	params.materialId = materialId;

	$
			.ajax({
				type : "POST",
				dataType : "json",
				url : "/shelter/personal/wish/color",
				data : params,
				success : function(data) {
					if (data.statusCode == 200) {
						var div = "";
						data.colors
								.forEach(function(color) {
									div += "<p><input type='radio' id='"
											+ materialId
											+ $.trim(color)
											+ "' value='"
											+ $.trim(color)
											+ "'><span style='cursor:pointer;' onClick='hideMaterialListPopover("
											+ orderGoodsId + ")'>" + color + "</span></p>";
								});
						$('#color_' + orderGoodsId).attr('data-content', div);
						$('#color_' + orderGoodsId).popover("show");
						$(".popover").css("z-index", "999");
					}
				}
			});
}


