var lastStyle = "";
var lastTexture = "";
var lastFit = "";
var lastPrice = "";

var customerId = $("[name='session']")[0].value;

function favor(materialId) {
	var favorClass = $("#favor_" + materialId)[0].className;
	if (favorClass == "glyphicon glyphicon-star-empty") {
		if (customerId == "") {
			loginModel();
		} else {
			var params = {}
			params.materialId = materialId;
			$.ajax({
				type : "Post",
				url : "/shelter/personal/favorite/add/",
				async : false,
				data : params,
				dataType : "json",
				success : function(data) {
					if (data.statusCode == 200) {
						$("#favor_" + materialId)[0].className = "glyphicon glyphicon-star";
						alert("收藏成功！");
					}
				}
			});
		}
	}
	if (favorClass == "glyphicon glyphicon-star") {
		var params = {}
		params.materialId = materialId;
		$.ajax({
			type : "Post",
			url : "/shelter/personal/favorite/delete/",
			async : false,
			data : params,
			dataType : "json",
			success : function(data) {
				if (data.statusCode == 200) {
					if (data.result > 0) {
						$("#favor_" + materialId)[0].className = "glyphicon glyphicon-star-empty";
						alert("取消收藏！");
					}
					else {
						alert("请稍后再试...");
					}
				}
			}
		});
	}
	
	
}

function showMoreStyle(id) {
	$('#collapseStyle').collapse('toggle');
	toggleMore(id);
}

function showMoreTexture(id) {
	$('#collapseTexture').collapse('toggle');
	toggleMore(id);
}

function toggleMore(id) {
	var sign = document.getElementById(id);

	if (sign.className == "glyphicon glyphicon-chevron-down category-more") {
		sign.className = "glyphicon glyphicon-chevron-up category-more";
	} else {
		sign.className = "glyphicon glyphicon-chevron-down category-more";
	}

}

function selectStyle(id) {
	/* 得到被选中radio的父节点的父节点 */
	var selected = document.getElementById(id).parentNode.parentNode;
	if (lastStyle != "") {
		lastStyle.setAttribute('class', 'col-md-1');
	}

	selected.setAttribute('class', 'col-md-1 category-selected');

	lastStyle = selected;
}

function selectTexture(id) {
	/* 得到被选中radio的父节点的父节点 */
	var selected = document.getElementById(id).parentNode.parentNode;
	if (lastTexture != "") {
		lastTexture.setAttribute('class', 'col-md-1');
	}

	selected.setAttribute('class', 'col-md-1 category-selected');

	lastTexture = selected;
}

function selectFit(id) {
	/* 得到被选中radio的父节点的父节点 */
	var selected = document.getElementById(id).parentNode.parentNode;
	if (lastFit != "") {
		lastFit.setAttribute('class', 'col-md-1');
	}

	selected.setAttribute('class', 'col-md-1 category-selected');

	lastFit = selected;
}

function search() {
	var params = {};
	params.style = $("input[name='style']:checked").val();
	params.texture = $("input[name='texture']:checked").val();
	params.fit = $("input[name='fit']:checked").val();
	params.price = $("input[name='price']:checked").val();

	$.ajax({
		type : "Post",
		url : "/shelter/material/categoryByClass",
		async : false,
		data : params,
		dataType : "json",
		success : function(data) {
			if (data) {
				$("#categoryList").children().remove();

				for ( var c in data.categories) {
					var address = data.categories[c].coverAdd;
					var title = data.categories[c].title;
					var price = data.categories[c].price;
					var brand = data.categories[c].brand;

					var div1 = document.createElement('div');
					div1.setAttribute('class', 'col-md-3 col-xs-12');

					var img = document.createElement("img");
					img.setAttribute('src', address);
					img.setAttribute('width', '200');
					img.setAttribute('height', '200');

					var div2 = document.createElement('div');
					div2.setAttribute('style',
							'padding-left: 15px; padding-right: 15px;');

					var hPrice = document.createElement("h4");
					hPrice.setAttribute('style', 'color: #ff7300;');
					var nodePrice = document.createTextNode('￥' + price);
					hPrice.append(nodePrice);

					var hTitle = document.createElement("h6");
					var nodeTitle = document.createTextNode(title);
					hTitle.append(nodeTitle);

					var hBrand = document.createElement("h6");
					hBrand.setAttribute('style',
							'color: #888; font-weight: 100;');
					var nodeBrand = document.createTextNode(brand);
					hBrand.append(nodeBrand);

					div2.append(hPrice);
					div2.append(hTitle);
					div2.append(hBrand);

					div1.append(img);
					div1.append(div2);
					$("#categoryList").append(div1);

				}
			}
		}
	});
}