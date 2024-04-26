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
                $("#welcome").text("欢迎您，" + data.uname);
                online();
            }
        },
        error: function () {
            offline();
        }
    })
}

function online() {
    // 改变class为onlogin的css样式为可见
    $(".onlogin").css("display", "block");
    $(".unlogin").css("display", "none");
}

function offline() {
    // 改变class为onlogin的css样式为不可见
    $(".onlogin").css("display", "none");
    $(".unlogin").css("display", "block");
}