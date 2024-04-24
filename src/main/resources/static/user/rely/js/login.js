function checkform() {
    event.preventDefault();
    var flag = true;
    var txt = "";

    if($("#email").val() == "") {
        txt += "邮箱不能为空！\n";
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
        update();
    }
}

function update(){
    $.ajax({
        url: "../../tUserLoginBehavior/login",
        type: "POST",
        data: $("#formid").serialize(),
        success: function (data) {
            if (data == 0) {
                $("#wrong").css("display", "block");
            } 
        }
    });
}