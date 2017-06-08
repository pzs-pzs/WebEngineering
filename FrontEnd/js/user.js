/**
 * Created by Lan Lingxiang on 2017/6/6.
 */


function login() {
    d = {}
    d['username'] = document.getElementById("username").value
    d['pwd'] = $.md5(document.getElementById("pwd").value)
    $.ajax({
        type: "POST",
        url: "????????????",
        data: d,
        success: function login_return(data) {
            result = JSON.parse(data)
            if (result['success'] == 1) {
                alert("登录成功！欢迎来到西电大喇叭！")
            }
            else {
                alert("用户名密码错误！")
            }
        }
    })
}

function register() {
    alert('dadfafa')
    var RegEx = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
    var e_mail = document.getElementById('email').value

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
    d['username'] = document.getElementById('username').value
    d['pwd'] = $.md5(document.getElementById('pwd').value)
    // MD5 加密
    d['email'] = document.getElementsById('email').value;

    $.ajax({
        type: "POST",
        url: "????????????",
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