$(document).ready(function () {
    $("#sub").attr("disabled", "disabled");
    $("#sub").css("cursor", "not-allowed");
    $("#sub").css("background-color", "gray");
    $("#codebutton").attr("disabled", "disabled");
    $("#codebutton").css("cursor", "not-allowed");
    $("#codebutton").css("background-color", "gray");
});
// 创建数组,其中5个元素都存储为0
let arr = [0, 0, 0, 0, 0];
function checkName() {
    var name = $("#name").val();
    if (name == "") {
        $("#sub").attr("disabled", "disabled");
        $("#sub").css("cursor", "not-allowed");
        $("#sub").css("background-color", "gray");
        $("#name").css("border", "1px solid red");
        // 获取arr中的第一个数据
        arr[0] = 0;
    } else {
        //将输入框，及提交变回正常
        $("#name").css("border", "1px solid #ccc");
        arr[0] = 1;
        //如果arr数组中的所有值都为1则可以提交
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && arr[3] == 1 && arr[4] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
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
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && arr[3] == 1 && arr[4] == 1) {
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
        arr[2] = 0;
    } else {
        arr[2] = 1;
        //如果arr数组中的所有值都为1则可以提交
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && arr[3] == 1 && arr[4] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
        $("#password2").css("border", "1px solid #ccc");
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
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && arr[3] == 1 && arr[4] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
        $("#email").css("border", "1px solid #ccc");
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
        arr[4] = 0;
    } else {
        //将输入框，及提交变回正常
        $("#code").css("border", "1px solid #ccc");
        arr[4] = 1;
        //如果arr数组中的所有值都为1则可以提交
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && arr[3] == 1 && arr[4] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
    }
}


$("#name").blur(function () { checkName() });
$("#password").blur(function () { checkPassword() });
$("#password2").blur(function () { checkPassword2() });
$("#email").blur(function () { checkEmail() });
$("#code").blur(function () { checkCode() });

$("#codebutton").click(function () {
    var email = $("#email").val();
    $.ajax({
        type: "get",
        url: "/tUser/email/" + email,
        dataType: "json",
        success: function (data) {
            if (data.code == 0) {
                if (data.data == null) {
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
                        type: "get",
                        url: "/email/code",
                        data: {
                            email: email
                        },
                        dataType: "json",
                        success: function (data) {
                        },
                    });
                } else {
                    alert("该邮箱已被注册");
                    // 让email获取焦点
                    $("#email").focus();
                }
            }
        },
    });
});

$("#sub").click(function () {
    var name = $("#name").val();
    var password = $("#password").val();
    var email = $("#email").val();
    var code = $("#code").val();
    var status = $("#status").val();
    $.ajax({
        type: "post",
        url: "/register",
        data: {
            name: name,
            password: password,
            email: email,
            code: code,
            status: status
        },
        success: function (data) {
            if (data == 0) {
                alert("注册失败");
            } else {
                //重定向至登录页面
                window.location.href = "./login.html";
            }

        }
    })
});