$(document).ready(function(){
    getCarts();
});

function getCarts() {
    //ajax get请求
    $.ajax({
        url: "/tCart",
        type: "get",
        dataType: "json",
        success: function (data) {
            display(data);
        }
    })
}
