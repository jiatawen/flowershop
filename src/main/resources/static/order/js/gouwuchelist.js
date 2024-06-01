// ajax get请求

$.ajax({
    url: "/tCart?uId="+ 2,
    type: "get",
    dataType: "json",
    success: function (data) {
        let datas = data.data.records;
        let html = "";
        datas.forEach(function (cart) {
            html += '<tr class = "odd">';
            html += '<td align="left">'+  cart.fid +'</td>' ;
            html += '<td align="left">'+ cart.fid +'</td>';
            html += '<td align="left"><input style="width:30px;" type="text" name="number" value="'+ cart.ccount +'">&nbsp;<a href="" onclick="change('+cart.id+')">变更</a></td>';
            html += '<td align="left">￥'+ cart.fid*cart.ccount +'</td>';
            html += '<td align="left"><a href="deleteCart('+ cart.id +');">删除</a></td>';
        });
        $("#tbody").html(html);
    },
    error: function () {
        
    }
});

function deleteCart(id){
    $.ajax({
        url: "/tCart",
        type: "delete",
        dataType: "json",
        data: {
            id: id
        },
        success: function (data) {}})
}

function change(id){

}