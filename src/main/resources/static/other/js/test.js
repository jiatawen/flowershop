$("#sub").click(function () {
    var a = $("#id").val();
    $.ajax({
    type: "GET",
    url: "../tUser/"+a,
    dataType: "json",
    success: function (data) {
       //将data数据中的name添加至id为name的标签中
       $("#name").html(data.data.uname);
       $("#mail").html(data.data.umail);
    },
    error: function (data) {
        console.log(data);
    }
});
});