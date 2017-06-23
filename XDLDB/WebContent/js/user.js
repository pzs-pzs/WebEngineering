/**
 * Created by Lan Lingxiang on 2017/6/6.
 */
function setCookie(sName, sValue) {
    var sCookie = sName + "=" + encodeURIComponent(sValue);
    document.cookie = sCookie;
}

// Get the value of a cookie by cookie name
function getCookie(sName) {
    var sRE = "(?:; )?" + sName + "=([^;]*);?";
    var oRE = new RegExp(sRE);
    if (oRE.test(document.cookie)) {
        return decodeURIComponent(RegExp["$1"]);
    } else {
        return null;
    }
}

function login() {
    d = {}
    d['username'] = document.getElementById("username").value
    d['pwd'] = $.md5(document.getElementById("pwd").value)
    
    	
    
    $.ajax({
        type: "POST",
        url: "/XDLDB/LoginServlet",
        data: d,
        success: function login_return(data) {
            result  = JSON.parse(data)
            if (result['success'] == 1) {
                //alert("登录成功！欢迎来到西电大喇叭！")
                // 记录
                setCookie("username",document.getElementById("username").value)

                window.location.href = "index.html"
            }
            else{
                alert("用户名密码错误！")
            }
        }
    })
}

function register() {
    
    var RegEx = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
    var e_mail = document.getElementById('eml').value
    
    if (!RegEx.test(e_mail)) {
        alert('请输入正确的邮箱格式！')
        return
    }

    if (document.getElementById('pwd').value.length < 8 || document.getElementById('pwd').value.length > 16) {
        alert('密码长度需要为8-16位')
        return
    }
    if (document.getElementById('pwd').value != document.getElementById('repwd').value) {
        alert('密码不一致，请重新输入')
        return
    }

   
    d = {}
    d['username'] = document.getElementById('username').value;
    d['pwd'] = $.md5(document.getElementById('pwd').value);

    d['email'] = document.getElementById('eml').value;
    
 
    
    $.ajax({
        type: "POST",
        url: "/XDLDB/RegisterServlet",
        data: d,
        success: function reg_return(data) {
            result = JSON.parse(data)
            if (result['success'] == 1) {
                alert("注册成功！欢迎来到西电大喇叭！")
                window.location = 'login.html'
            }
            else {
                alert("用户已存在，请选择其他学号进行注册！")
            }
        }
    })
}