function checkform() {
    if (document.getElementById("usernameid").value == "") {

        alert('用户名不能为空');
        return false;
    }

    var valid = /^\w+$/;
    if (!valid.test(document.getElementById("usernameid").value)) {
        alert('用户名必须是数字，字母或者下划线');
        return false;
    }

    if (document.getElementById("passwordid").value == "") {

        alert('密码不能为空');
        return false;
    }

    if (document.getElementById("passwordid").value.length < 6) {

        alert('密码长度必须大于6位');
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