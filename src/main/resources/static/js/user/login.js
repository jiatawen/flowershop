
var $ = jQuery.noConflict();
function checkform() {
    var flag = true;
    var txt = "";

    if($("#username").val() == "") {
        txt += "用户名不能为空！\n";
        flag = false;
    }

    if($("#password").val() == "") {
        txt += "密码不能为空！\n";
        flag = false;
    }

    if(flag == false) {
        alert(txt);
        return false;
    } else {
        return true;
    }
}