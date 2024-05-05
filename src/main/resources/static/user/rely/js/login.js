$(document).ready(function () {
    $("#sub").attr("disabled", "disabled");
    $("#sub").css("cursor", "not-allowed");
    $("#sub").css("background-color", "gray");
});

let arr = [0, 0];
function checkEmail() {
    var email = $("#email").val();
    //验证邮箱格式是否正确
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if (!reg.test(email)) {
        $("#sub").attr("disabled", "disabled");
        $("#sub").css("cursor", "not-allowed");
        $("#sub").css("background-color", "gray");
        $("#codebutton").attr("disabled", "disabled");
        $("#codebutton").css("cursor", "not-allowed");
        $("#codebutton").css("background-color", "gray");
        $("#email").css("border", "1px solid red");
        arr[0] = 0;
    } else {
        arr[0] = 1;
        $("#codebutton").removeAttr("disabled");
        $("#codebutton").css("cursor", "pointer");
        $("#codebutton").css("background-color", "#efefef");
        //如果arr数组中的所有值都为1则可以提交
        if (arr[0] == 1 && arr[1] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
        $("#email").css("border", "1px solid #ccc");
    }
}

function checkPassword() {
    var password = $("#password").val();
    if (password == "" || password.length < 6) {
        $("#sub").attr("disabled", "disabled");
        $("#sub").css("cursor", "not-allowed");
        $("#sub").css("background-color", "gray");
        $("#password").css("border", "1px solid red");
        arr[1] = 0;
    } else {
        arr[1] = 1;
        //如果arr数组中的所有值都为1则可以提交
        if (arr[0] == 1 && arr[1] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
        $("#password").css("border", "1px solid #ccc");
    }
}

$("#password").blur(function () { checkPassword() });
$("#email").blur(function () { checkEmail() });

$("#sub").click(function () {
    onloading();
    var email = $("#email").val();
    var password = $("#password").val();
    $.ajax({
        type: "GET",
        url: "/login",
        data: {
            email: email,
            password: password
        },
        success: function (data) {
            removeload();
            if (data == null) {
                alert("用户名或密码错误");
            } else {
                window.location.href = "./index.html";
            }
        },
        error: function(message){
            alert("用户名或密码错误");
            removeload();
        }
    });
});

function onloading() {
    $("#overlay").show(); // 显示遮罩层
    $("#loading-text").show(); // 显示加载文本
}
function removeload() {
    $("#overlay").hide();
    $("#loading-text").hide(); // 隐藏加载文本
}