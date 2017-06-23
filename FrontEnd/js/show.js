/**
 * Created by henry on 2017/6/11.
 */

function show() {
    var thisURL = document.URL;
    var  g =thisURL.split('?')[1];
    var  ss= g.split("&&")[0];
    var  ss1= ss.split("=")[1];
    var  s= g.split("&&")[1];
    var  s1= s.split("=")[1];

    var d={};
    d['id'] =  ss1;
    d['page'] = s1 ;
    // d.11page=
    $.ajax({
        type: "POST",
        url: '/XDLDB//SearchLostServlet',
        data : d,
        async: false,
        success: function login_return(data) {
            s = JSON.parse(data)
            document.getElementById("title").innerHTML = s['title'];
            document.getElementById("text").innerHTML = s['text'];
            document.getElementById("username").innerHTML = s['username'];
            document.getElementById("time").innerHTML = s['time'];
        }
    });
}