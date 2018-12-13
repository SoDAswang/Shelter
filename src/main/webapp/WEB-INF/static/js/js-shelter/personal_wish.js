
function deleteWish (wishId) {
	var params = {};
	params.wishId = wishId;
	
	$.ajax({
		type     : "Post",
		url      : "/shelter/personal/wish/deleteWish/"+wishId,
		async    : false,
		data     : params,
		dataType : "json",
		success  : function (data) {
			if (data.result == '1') {
				console.log("移除成功！");
				window.location.href="/shelter/personal/wish";
			} 
		}
	});
}