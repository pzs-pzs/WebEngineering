/**
 * Created by henry on 2017/6/10.
 */

function a()
{
    $.ajax({
        type: "POST",
        url: '/XDLDB/SearchLostServlet',
        data: d={page:1},
        
        success: function login_return(data) {
            var aData =eval(data);
            oUl.innerHTML='';
            for(i=0;i<aData.length;i++)
            {
                var oLi=document.createElement('a');
                oLi.setAttribute("class","list-group-item");
                oLi.href='show'+(i+1)+'.html'+'?id='+aData[i].id+'&&'+'page='+1;
                oLi.id=i;
                oLi.innerHTML='<strong><p style="color: #5cb85c">'+aData[i].title+'</p></strong><p class="text-right">'+aData[i].time+'</p>';
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

            //调用AJAX函数
            $.ajax({
                type: "POST",
                url: '/XDLDB/SearchLostServlet',
                data: d={page:this.id},
               
                success: function login_return(data) {
                    var aData =eval(data);
                    oUl.innerHTML='';
                    for(i=0;i<aData.length;i++)
                    {
                        var oLi=document.createElement('a');
                        oLi.setAttribute("class","list-group-item");
                        oLi.href='show'+(i+1)+'.html'+'?id='+aData[i].id+'&&'+'page='+this.id;
                        oLi.id=i;
                        oLi.innerHTML='<strong><p style="color: #5cb85c">'+aData[i].title+'</p></strong><p class="text-right">'+aData[i].time+'</p>';
                        oUl.appendChild(oLi);

                    }
                }
            });
        };
    }
};


