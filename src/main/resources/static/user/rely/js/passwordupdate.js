$(document).ready(function () {
    $("#sub").attr("disabled", "disabled");
    $("#sub").css("cursor", "not-allowed");
    $("#sub").css("background-color", "gray");
    $("#code").css("border", "1px solid red");
    $("#password").css("border", "1px solid red");
    $("#password2").css("border", "1px solid red");
});

let arr = [0, 0, 0];
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
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1) {
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
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1) {
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
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1) {
            $("#sub").removeAttr("disabled");
            $("#sub").css("cursor", "pointer");
            $("#sub").css("background-color", "#7dc44e");
        }
    }
}

$("#code").blur(function () { checkCode(); });
$("#password").blur(function () { checkPassword(); });
$("#password2").blur(function () { checkPassword2(); });

$("#codebutton").click(function () {
    let email = _user.umail;
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
    let password = $("#password").val();
    let code = $("#code").val();
    let email = _user.umail;
    $.ajax({
        type: "POST",
        url: "/tUser/resetPassword",
        data: {
            password: password,
            code: code
        },
        success: function (data) {
            if (data == 1) {
                //成功
            } else {
                //失败
            }
        }
    })

});