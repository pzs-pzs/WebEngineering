/**
 * Created by Gaoyuan.
 */
Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function conserve3() {
    // body...
	var mydate=new Date().Format("yyyy-MM-dd hh:mm:ss");
	
    d={}
    d['title']=document.getElementById('title').value
    d['username']=document.getElementById('username').value
    d['text']=document.getElementById('text').value
    d['time']=mydate;
    
   
    $.ajax({
    	
        type:"POST",
        url:"/XDLDB/StoreTradeServlet",
        data:d,
        success: function conserve_return(data){
        result=JSON.parse(data)
                    if (result['success'] == 1) {
                    	alert("提交成功")
            }
            else {
                alert("提交失败")
            }
        }
        })
    location.reload();
}