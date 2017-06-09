/**
 * Created by Lan Lingxiang on 2017/6/6.
 */
function login(){
    d = {}
    d['username'] = document.getElementById("username").value
    d['pwd'] = $.md5(document.getElementById("pwd").value)
   
    // md5加密
    $.ajax({
        type:"POST",
        url:"/XDLDB/LoginServlet",
        data: d,
        
        
        
        success:function login_return(data){
        	 
            result = JSON.parse(data)
            if (result['success'] == 1){
                alert(" 登陆成功！ 欢迎来到西电大喇叭！")
                document.getElementById("GG").background="image/sulbg.jpg"
            }
            else{
                alert(" 咦？好像哪里不对 ")
            }
        }
    })
}

function register(){
    if (document.getElementById('pwd').value.length < 8 || document.getElementById('pwd').value.length > 16){
        alert('密码长度需要为8-16位')
        return
    }
    if (document.getElementById('pwd').value != document.getElementById('repwd').value){
        alert('密码不一致，请重新输入')
        return
    }

    d = {}
    d['username'] = document.getElementById('username').value
    d['pwd'] = $.md5(document.getElementById('pwd').value)
    // MD5 加密

    $.ajax({
        type:"POST",
        url:"/XDLDB/RegisterServlet",
        data: d,
        success:function reg_return(data){
            result = JSON.parse(data)
            if (result['success'] == 1){
                alert("注册成功！欢迎来到西电大喇叭！")
                window.location = '/XDLDB/index.html'
            }
            else{
                alert("用户已存在，请选择其他学号进行注册！")
            }
        }
    })
}