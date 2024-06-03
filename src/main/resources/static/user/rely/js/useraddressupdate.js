$(document).ready(function () { Start(); });

let _user = null;
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
                $("#titlename").html(_user.uname);
                $("#uid").val(_user.uid);
                setData();
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
function setData() {
    // 从url地址栏中获取id值
    let id = getUrlParam("id");
    if (id != null) {
        // ajax请求获取数据
        $.ajax({
            url: "/tUserContact/" + id,
            type: "get",
            dataType: "json",
            success: function (data) {
                if (data == null) {
                    alert("获取数据失败");
                } else {
                    $("#id").val(data.data.id);

                    $("#ucName").val(data.data.ucName);
                    $("#ucAddress").val(data.data.ucAddress);
                    $("#ucTel").val(data.data.ucTel);
                }
            },
            error: function () {
                alert("获取数据失败");
            }
        })
    }

}

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

$("#formbotton").click(function () {
    // ajax put请求
    $.ajax({
        url: "/tUserContact",
        type: "put",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            id: $("#id").val(),
            uid: $("#uid").val(),
            ucName: $("#ucName").val(),
            ucAddress: $("#ucAddress").val(),
            ucTel: $("#ucTel").val(),
        }),
        success: function (data) {
            if (data == null) {
                alert("修改失败");
            } else {
                window.location.href = "./userupdatelist.html";
            }
        },
        error: function () {
            alert("修改失败");
        }
    })
});