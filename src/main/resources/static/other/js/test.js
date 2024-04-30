$(document).ready(function () {
    
});

var aaa;
let bbb;

$("#say1").click(function () {
    alert("2");
})

$("#aaa").click(function () {
    let uid = $("#uid").val();

    //ajax请求获取数据
    $.ajax({
        url: "/tUser/"+uid,
        type: "get",
        dataType: "json",
        success: function (data) {
             $("#say1").html("你好"+data.data.uname)
        },
    });
});

