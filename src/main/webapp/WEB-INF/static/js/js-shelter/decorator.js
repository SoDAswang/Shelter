$(function() {
	var error=$("#error").val();
	if( error != ""){
		$("#errorTip").text(error);
		$("#loginModal").modal('show');
	}
});

function register () {
			var username = $("#inputRegisterUserName")[0].value;
			var password = $("#inputRegisterPassword")[0].value;
			var confirmPassword = $("#confirmRegisterPassword")[0].value;
			
			if (username=="" || password=="" || confirmPassword=="") {
				$("#isSame")[0].innerText = "* 请确认所有项目填写完毕！"
				return;
			} else {
				if (password != confirmPassword) {
					$("#isSame")[0].innerText = "* 密码不一致！"
						return;
				} else {
					$("#isSame")[0].innerText = "";
					
					var params = {};
					params.username = username;
					params.password = password;
					params.confirmPassword = confirmPassword;
					
					$.ajax({
						type : "POST",
						dataType : "json",
						data: params,
						url : "/shelter/register",
						success : function(data) {
							if (data.statusCode == 200) {
								if (data.isExisted) {
									alert("该用户名已存在请前往登录！");
								} else {
									alert("注册成功请前往登录！");
									$("#loginModal").modal('hide');
								}
							}
						}
					});
				}
			}
			
			
		}

function login () {
	var username = $("#inputUserName")[0].value;
	var password = $("#inputPassword")[0].value;
	var jcaptchaCode = $("#jcaptchaCode")[0].value;
	
	if (username=="" || password=="" || jcaptchaCode=="") {
		$("#errorTip")[0].innerText = "* 请确认所有项目填写完毕！"
		return;
	} else {
		$("#url").val(window.location.href.split('shelter')[1]);
		$("#loginform").submit();
	}
}