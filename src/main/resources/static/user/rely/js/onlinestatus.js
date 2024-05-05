$(document).ready(function () { Start(); });

var _user = null;
function Start() {
    $.ajax({
        url: "/getSession",
        type: "get",
        dataType: "json",
        success: function (data) {
            if (data == null) {
                offline();
            } else {
                _user = data;
                let text = "";
                if (data.ustatus == 0) {
                    text = "<span>欢迎您，" + data.uname + "</span><a href=\"/user/controller/userlist.html\">控制台</a>";
                } else {
                    text = "欢迎您，" + data.uname;
                }
                $("#welcome").html(text);
                online(data);

                // 其他js文件中的函数
                userupdatelist();
            }
        },
        error: function () {
            offline();
        }
    })
}

function online(data) {
    // 改变class为onlogin的css样式为可见
    $(".onlogin").css("display", "block");
    $(".unlogin").css("display", "none");
}

function offline() {
    // 改变class为onlogin的css样式为不可见
    $(".onlogin").css("display", "none");
    $(".unlogin").css("display", "block");
}