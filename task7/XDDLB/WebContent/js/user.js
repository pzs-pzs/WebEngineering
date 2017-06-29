/**
 * Created by Lan Lingxiang on 2017/6/6.
 */

function setCookie(sName, sValue) {
    var sCookie = sName + "=" + encodeURIComponent(sValue)+";";
    document.cookie = sCookie;
}

function getCookie(sName) {

    var sRE = "(?:; )?" + sName + "=([^;]*);?";
    var oRE = new RegExp(sRE);

    if (oRE.test(document.cookie)) {
        return decodeURIComponent(RegExp["$1"]);
    } else {
        return null;
    }

}




function clientSetCookies(){
    //setCookie("ClientCookie1", "ClientTest1", new Date(Date.parse("May 4, 2009")), "/CookieTest", "http://localhost:6581/CookieApplication", true);
    setCookie("ClientCookie1", "ClientTest1", new Date(Date.parse("May 4, 2009")), null, null, false);
    setCookie("ClientCookie2", "ClientTest2", new Date(Date.parse("May 4, 2009")));
    setCookie("ClientCookie3", "ClientTest3");

    var sCookie = "The cookies created by client are:<br />{<br />&nbsp;&nbsp;Client Cookie1: " + getCookie("ClientCookie1")
        + "<br />&nbsp;&nbsp;Client Cookie2: " + getCookie("ClientCookie2")
        + "<br />&nbsp;&nbsp;Client Cookie3: " + getCookie("ClientCookie3")
        + "<br />}";

    document.getElementById('<% =divClient.ClientID%>').innerHTML = sCookie;
    //deleteCookie("cookie1");
    //deleteCookie("cookie2");
    //deleteCookie("cookie3");
}


//get cookies which created by server
function clientGetCookies(){
    var sCookie = "The cookies read by client and created by server are:<br />" +
        "{<br />&nbsp;&nbsp;Server Cookie1: " + getCookie("ServerCookie1")
        + "<br />&nbsp;&nbsp;Server Cookie2: " + getCookie("ServerCookie2")
        + "<br />&nbsp;&nbsp;Server Cookie3: " + getCookie("ServerCookie3")
        + "<br />}";

    document.getElementById('<% =divClient.ClientID%>').innerHTML = sCookie;
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
            result = JSON.parse(data)
            if (result['success'] == 1) {
                //alert("登录成功！欢迎来到西电大喇叭！")
                // 记录
                setCookie("username",document.getElementById("username").value)

                window.location.href = "index.html"
            }
            if(document.getElementById("username").value==null){
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