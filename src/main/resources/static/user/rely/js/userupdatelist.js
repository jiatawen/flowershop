function userupdatelist(){
    $("#welcome").html("欢迎 "+ _user.uname);
    $("#titlename").html(_user.uname);

    setTbody();
}

function setTbody(){
    $.ajax({
        url:"/tUserContact",
        success:function (data){
            user_block(data["id"]);
        }
    });
}