$(document).ready(function () {
    $("#sub").attr("disabled", "disabled");
    $("#sub").css("cursor", "not-allowed");
    $("#sub").css("background-color", "gray");
    $("#code").css("border", "1px solid red");
    $("#password").css("border", "1px solid red");
    $("#password2").css("border", "1px solid red");
    $("#codebutton").attr("disabled", "disabled");
    $("#codebutton").css("cursor", "not-allowed");
    $("#codebutton").css("background-color", "gray");
    $("#email").css("border", "1px solid red");
});

let arr = [0, 0, 0, 0];
function checkPassword() {
    var password = $("#password").val();
    if (password == "" || password.length < 6) {
        $("#sub").attr("disabled", "disabled");
        $("#sub").css("cursor", "not-allowed");
        $("#sub").css("background-color", "gray");
        $("#password").css("border", "1px solid red");
        arr[0] = 0;
    } else {
        arr[0] = 1;
        //如果arr数组中的所有值都为1则可以提交
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && arr[3] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
        $("#password").css("border", "1px solid #ccc");
    }
}
function checkPassword2() {
    var password = $("#password").val();
    var password2 = $("#password2").val();
    if (password2 == "" || password2 != password) {
        $("#sub").attr("disabled", "disabled");
        $("#sub").css("cursor", "not-allowed");
        $("#sub").css("background-color", "gray");
        $("#password2").css("border", "1px solid red");
        arr[1] = 0;
    } else {
        arr[1] = 1;
        //如果arr数组中的所有值都为1则可以提交
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && arr[3] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
        $("#password2").css("border", "1px solid #ccc");
    }
}

function checkCode() {
    var code = $("#code").val();
    if (code == "") {
        $("#sub").attr("disabled", "disabled");
        $("#sub").css("cursor", "not-allowed");
        $("#sub").css("background-color", "gray");
        $("#code").css("border", "1px solid red");
        // 获取arr中的第一个数据
        arr[2] = 0;
    } else {
        //将输入框，及提交变回正常
        $("#code").css("border", "1px solid #ccc");
        arr[2] = 1;
        //如果arr数组中的所有值都为1则可以提交
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && arr[3] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
    }
}

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
        arr[3] = 0;
    } else {
        arr[3] = 1;
        $("#codebutton").removeAttr("disabled");
        $("#codebutton").css("cursor", "pointer");
        $("#codebutton").css("background-color", "#efefef");
        //如果arr数组中的所有值都为1则可以提交
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && arr[3] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
        $("#email").css("border", "1px solid #ccc");
    }
}

$("#code").blur(function () { checkCode(); });
$("#password").blur(function () { checkPassword(); });
$("#password2").blur(function () { checkPassword2(); });

$("#email").blur(function () { checkEmail(); });

$("#codebutton").click(function () {
    var email = $("#email").val();
    $("#codebutton").val("60s后可再次获取");
    $("#codebutton").attr("disabled", "disabled");
    var time = 60;
    var timer = setInterval(function () {
        time--;
        $("#codebutton").val(time + "s后可再次获取");
        if (time == 0) {
            clearInterval(timer);
            $("#codebutton").removeAttr("disabled");
            $("#codebutton").val("获取验证码");
        }
    }, 1000);
    $.ajax({
        type: "GET",
        url: "/email/code",
        data: {
            email: email
        },
        dataType: "json",
        success: function (data) {

        }
    });
});

$("#sub").click(function () {
    $.ajax({
        type: "post",
        url: "/tUser/resetPassword",
        data: {
            password: $("#password").val(),
            email: $("#email").val(),
            code: $("#code").val(),
        },
        dataType: "json",
        success: function (data) {
            if (data == 1) {
                alert("修改成功");
                window.location.href = "/user/index/login.html";
            } else if(data == 0) {
                alert("验证码错误");
            }else if(data == -1) {
                alert("该邮箱未注册");
            }
        }
    });
});