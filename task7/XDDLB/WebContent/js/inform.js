/**
 * Created by henry on 2017/6/10.
 */
function a()
{
    d={}
    d['page']=1,
    $.ajax({
        type: "POST",
        url: '/XDLDB/SearchInformServlet',
        data: d,
        success: function login_return(data) {
            var aData =eval(data);
            oUl.innerHTML='';
            for(i=0;i<aData.length;i++)
            {
                var oLi=document.createElement('a');
                oLi.setAttribute("class","list-group-item");
                oLi.innerHTML='<strong>'+aData[i].title+'</strong><p class="text-right">'+aData[i].time+'</p>';
                oLi.href='show2.html'+'?id='+aData[i].id+'&&'+'page='+this.id;
                oLi.id=i;
                oUl.appendChild(oLi);

            }
        }
    });
    var oUl=document.getElementById('ul1');
    var aBtn=document.getElementById('flag').getElementsByTagName("a");
    var i=0;
    oUl.setAttribute("class","list-group");
    for(i=0;i<aBtn.length;i++)
    {
        //给每一个按钮附一个初值索引
        aBtn[i].index=aBtn[i].id;
        aBtn[i].onclick=function()
        {
            d={}
            d['page']=this.id,

            //调用AJAX函数
            $.ajax({
                type: "POST",
                url: '/XDLDB/SearchInformServlet',
                data: d,
                success: function login_return(data) {
                    var aData =eval(data);
                    oUl.innerHTML='';
                   
                    for(i=0;i<aData.length;i++)
                    {
                        var oLi=document.createElement('a');
                        oLi.setAttribute("class","list-group-item");
                        oLi.href='show2.html'+'?id='+aData[i].id+'&&'+'page='+this.id;
                        oLi.id=i;
                        oLi.innerHTML='<strong>'+aData[i].title+'</strong><p class="text-right">'+aData[i].time+'</p>';
                       
                        oUl.appendChild(oLi);

                    }
                }
            });
        };
    }
};

