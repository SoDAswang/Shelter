var choosedMaterialId = "";
var choosedColor = "";
var choosedWishId = "";

$("#addMaterialToWish").addClass("disabled")

function openModal(materialId) {
	choosedMaterialId = materialId;
	
	$('#colors').empty();
	$
			.ajax({
				type : "POST",
				dataType : "json",
				url : "/shelter/personal/favorite/chooseWish/" + materialId,
				success : function(data) {
					if (data.statusCode == 200) {
						var colors = data.colors;

						// Add color option for materials with more then one
						// kinds of color.
						if (colors.length > 0 && colors[0] != null) {
							var div = "";
							colors
									.forEach(function(color) {
										// <input type="button" class="btn
										// btn-default" value=color>
										div += "<input type='button' class='btn btn-default' value='"
												+ color
												+ "' style='margin-right:10px;' onClick='changeButtonClazz()'>";
									});
							$('#colors').append(div);
						}

					}
				}
			});
	$("#myModal").modal('show');
}

function changeButtonClazz() {
	var targetButton = event.target;
	
	choosedColor = targetButton.value;

	var colorButtons = $("#colors").find('input');
	for (var i = 0; i < colorButtons.length; i++) {
		colorButtons[i].className = "btn btn-default";
	}

	targetButton.className = "btn btn-warning";

	judgeAvaiable();
	}

function changeWishClazz(wishId) {
	choosedWishId = wishId;

	var targetWish = $("#wish_" + wishId)[0];

	var wishDivs = $("#wishes").find('div');
	for (var i = 0; i < wishDivs.length; i++) {
		wishDivs[i].className = "col-md-12";
		
//		choosedWishId = wishDivs[i].id.slice(5);
	}

	targetWish.className = "col-md-12 choosedWish";

	judgeAvaiable();
}

function judgeAvaiable() {
	var flag1 = false;
	var flag2 = false;

	var color = $("#colors").find('input');
	var wish = $("#wishes").find('div');

	// Judging if color is chosen.
	if (color.length == 0) {
		flag1 = true;
	} else {
		if (color.hasClass("btn-warning")) {
			flag1 = true;
		}
	}

	// Juding if wish is chosen.
	if (wish.hasClass("choosedWish")) {
		flag2 = true;
	}

	if (flag1 && flag2) {
		$("#addMaterialToWish").removeClass("disabled")
	}

}

function addMaterialToWish() {
	if (choosedColor=="" || choosedWishId=="") {
		return;
	} else {
		params = {};
		params.materialId = choosedMaterialId;
		params.color = choosedColor;
		params.wishId = choosedWishId;
		$
		.ajax({
			type : "POST",
			dataType : "json",
			data: params,
			url : "/shelter/personal/favorite/addMaterialToWish",
			success : function(data) {
				if (data.statusCode == 200) {
					alert(data.isExisted ? "已添加至心愿单！" : "添加成功！")
				}
			}
		});
	}
}
