var customerId = $("[name='session']")[0].value;

$(function(){  
	/**
	 * living
	 * */
	if($('#liv1').attr('src')=='0') {
		$("#living").remove();
	}
	
	if($('#liv2').attr('src')=='0') {
		$("#living2").remove();
		$("#living3").remove();
	}
	
	if($('#liv3').attr('src')=='0') {
		$("#living3").remove();
	}
	
    /**
     * bedroom
     * */	
	if($('#bed1').attr('src')=='0') {
		$("#bedroom").remove();
	}
	
	if($('#bed2').attr('src')=='0') {
		$("#bedroom2").remove();
		$("#bedroom3").remove();
	}
	
	if($('#bed3').attr('src')=='0') {
		$("#bedroom3").remove();
	}
	
	/**
	 * kitchen
	 * */
	if($('#kit1').attr('src')=='0') {
		$("#kitchen").remove();
	}
	
	if($('#kit2').attr('src')=='0') {
		$("#kitchen2").remove();
		$("#kitchen3").remove();
	}
	
	if($('#kit3').attr('src')=='0') {
		$("#kitchen3").remove();
	}
	
	/**
	 * tiolet
	 * */
	if($('#tio1').attr('src')=='0') {
		$("#tiolet").remove();
	}
	
	if($('#tio2').attr('src')=='0') {
		$("#tiolet2").remove();
		$("#tiolet3").remove();
	}
	
	if($('#tio3').attr('src')=='0') {
		$("#tiolet3").remove();
	}
	
	/**
	 * dinning
	 * */
	if($('#din1').attr('src')=='0') {
		$("#dinning").remove();
	}
	
	if($('#din2').attr('src')=='0') {
		$("#dinning2").remove();
		$("#dinning3").remove();
	}
	
	if($('#din3').attr('src')=='0') {
		$("#dinning3").remove();
	}
	
	/**
	 * child
	 * */
	if($('#chi1').attr('src')=='0') {
		$("#child").remove();
	}
	
	if($('#chi2').attr('src')=='0') {
		$("#child2").remove();
		$("#child3").remove();
	}
	
	if($('#chi3').attr('src')=='0') {
		$("#child3").remove();
	}
	
	/**
	 * study
	 * */
	if($('#stu1').attr('src')=='0') {
		$("#study").remove();
	}
	
	if($('#stu2').attr('src')=='0') {
		$("#study2").remove();
		$("#study3").remove();
	}
	
	if($('#stu3').attr('src')=='0') {
		$("#study3").remove();
	}
});


function addToWish (sampleId) {
	if (customerId == "") {
		loginModel();
	} else {
		var params = {};
		params.sampleId = sampleId;
		params.subject = event.target.parentElement.parentElement.parentElement.id;

		$.ajax({
			type     : "Post",
			url      : "/shelter/sample/addToWish",
			async    : false,
			data     : params,
			dataType : "json",
			success  : function (data) {
				if (data.status == '200') {
					alert("添加成功！");
				} else if (data.status == '0') {
					alert("已添加至心愿单！");
				} else {
					alert("添加失败，请稍后再试！")
				}
			}
		});
	}
}
