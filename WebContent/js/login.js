// 保证登陆页面始终再最外一层
if (window != top) {
	top.location.href = location.href; 
}

var slideVerify;
layui.use(['form'], function() {
	var form = layui.form,
		layer = layui.layer;
	//自定义验证规则
	form.verify({
		account: function(value) {
			if (value == '') {
				return '用户名不能为空';
			}
		},
		userpwd: function(value) {
			if (value == '') {
				return '密码不能为空';
			} else if (value.length < 6 || value.length > 11) {
				return '请正确输入6~11位密码';
			}
		},
		captcha: function(value) {
			if (value == '') {
				return '验证码不能为空';
			}
		},
	});
	$(document).ready(function() {
		console.log("在这里准备数据");		
		// 写上密码
        console.log($('#username').val());
        console.log($('#userpwd').val());
		
		// 记住密码，填入密码
		checkCookie();
		// 滑动条初始化
		var SlideVerifyPlug = window.slideVerifyPlug;
		slideVerify = new SlideVerifyPlug('#verify-wrap', {
			wrapWidth: '318', //设置 容器的宽度 ，默认为 350 ，也可不用设，你自己css 定义好也可以，插件里面会取一次这个 容器的宽度
			initText: '请按住滑块，向右滑动', //设置  初始的 显示文字
			sucessText: '验证通过', //设置 验证通过 显示的文字
			getSucessState: function(res) {
				//当验证完成的时候 会 返回 res 值 true，只留了这个应该够用了
				console.log(res);
			}
		});
	});
	// 进行登录操作
	form.on('submit(login)', function(data) {
		if (!slideVerify.slideFinishState) {
			//未验证不提交
			layer.msg('请向右滑动滑块进行验证！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
		} else {
			var browser = getUserAgent();
			/*layer.msg("浏览器版本："+browser.type+"-"+browser.version+"<br>"
					+"Ip地址为："+returnCitySN.cip+"<br>"
					+" 地点为："+returnCitySN.cname
					,{icon: -1, offset: '100px',anim: 1, time:3000});*/
			
			var param = data.field;
			param.loginip = returnCitySN.cip;
			param.loginsite = returnCitySN.cname;
			// console.log(param);  
			$.ajax({
				type : "post",
				url : "LoginServlet?status=login",
				data : param,
				dataType : "json",//预期服务器返回的数据类型
				success : function(data){	
					console.log(data);
					if(data == '1'){
						layer.msg('登录成功！', {anim: 3, icon: 6, time: 2000, shade: 0.1});
						setTimeout(function() {
							window.location = 'index.html';
						}, 1000);
					} else if(data == '0') {
		                  layer.msg('密码错误，登录失败',{anim: 6, icon: 5, time: 1500, shade: 0.1});
		                  $('#userpwd').val("");
					} else if(data == '-1') {
		                  layer.msg('该用户已被被禁用！',{anim: 6, icon: 5, time: 1500, shade: 0.1});
		                  $('#username').val("");
		                  $('#userpwd').val("");
					} 
				},
				error:function(xhr){
					//alert("错误提示： " + xhr.status + " " + xhr.statusText);
					window.location = 'views/error/500.html';
				}
			});
		}
		return false;
	});
});

// 实现自动登陆
// 获取指定cookie的值
function getCookie(cname){
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) {
            return c.substring(name.length,c.length);
        }
    }
    return "";
}

// 获得cookie中存放的密码实现自动登陆
function checkCookie()
{  
    var username=getCookie("username");
    var userpwd=getCookie("userpwd");
    if (username!="" ) { $("#username").val(username); }
    if (userpwd!="") { $("#userpwd").val(userpwd); }
    
	//alert("username："+ username);
	//alert("userpwd："+ userpwd);
    
	if (username!="" && userpwd!="") {  
        var param = {
    		'username': username,
			'userpwd': userpwd
        }
        $.ajax({
			type : "post",
			url : "AutoLoginServlet",
			data : param,
			dataType : "json",//预期服务器返回的数据类型
			success : function(data){	
				console.log(data);
				if(data == true){
					window.location = 'index.html';
				} else {
					window.location = 'login.html';
				}
			},
			error:function(xhr){
				//alert("错误提示： " + xhr.status + " " + xhr.statusText);
				window.location = 'views/error/500.html';
			}
		});
    } 
} 

/* 获取浏览器信息 */
function getUserAgent(){  
    var Sys={};  
    var ua=navigator.userAgent.toLowerCase();  
    var s;  
    (s=ua.match(/msie ([\d.]+)/))?(Sys['type']='ie',Sys['version']=s[1]):  
    (s=ua.match(/firefox\/([\d.]+)/))?(Sys['type']='firefox',Sys['version']=s[1]):  
    (s=ua.match(/chrome\/([\d.]+)/))?(Sys['type']='chrome',Sys['version']=s[1]):  
    (s=ua.match(/opera.([\d.]+)/))?(Sys['type']='opera',Sys['version']=s[1]):  
    (s=ua.match(/version\/([\d.]+).*safari/))?(Sys['type']='safari',Sys['version']=s[1]):0;  
    return Sys;  
} 
