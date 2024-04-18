function checkform() {
    var txt = "";
    var flag = true;
    //正则表达式，验证用户名必须是数字，字母或者下划线，且只能以字母开头
    var reg = /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/;
    


    if($("#username").val() == "") {
        txt += "用户名不能为空\n";
        flag = false;
    }else if ($("#usernameid").val() == "") {
        txt += "用户名必须是数字，字母或者下划线，且只能以字母开头\n";
        flag = false;
    }
    // id为password不能为空
    if($("#passwordid").val() == "") {
        txt += "密码不能为空\n";
        flag = false;
    }else if ($("#passwordid").val().length < 6) {
        txt += "密码长度至少6位\n";
        flag = false;
    }
    // id为password不能为空
    if($("#password2id").val() == "") {
        txt += "确认密码不能为空\n";
        flag = false;
    }else if ($("#password2id").val()!= $("#passwordid").val()) {
        txt += "确认密码和原密码不一致\n";
        flag = false;
    }
    // id为password不能为空
    if($("#xingmingid").val() == "") {
        txt += "姓名不能为空\n";
        flag = false;
    }
    // id为password不能为空
    



    if (document.getElementById("passwordid").value == "") {

        alert('密码不能为空');
        return false;
    }
    if ($('#yanzhenmaid').val() == "") {
        alert('验证码不能为空');
        return false;
    }

    if (document.getElementById("passwordid").value.length < 6) {

        alert('密码长度至少6位');
        return false;
    }

    if (document.getElementById("passwordid").value != document.getElementById("password2id").value) {

        alert('确认密码和原密码不一致');
        return false;
    }

    if (document.getElementById("xingmingid").value == "") {

        alert('姓名不能为空');
        return false;
    }


    if (document.getElementById("dizhiid").value == "") {

        alert('收货地址不能为空');
        return false;
    }

    if (document.getElementById("dianhuaid").value == "") {

        alert('手机不能为空');
        return false;
    }

    valid = /^0?1[3,5,8][0,1,2,3,4,5,6,7,8,9]\d{8}$/;

    if (!valid.test(document.getElementById("dianhuaid").value)) {

        alert('请输入正确的手机格式');
        return false;
    }

    return true;
}