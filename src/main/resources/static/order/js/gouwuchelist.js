//ajax get请求


//ajax get请求
$.ajax({
    url: "/tCart",
    type: "get",
    dataType: "json",
    success: function (data) {
        let datas = data.data.records
        let html = "";
        datas.forEach(function (cart) {
            $.ajax({
                url: "/tFlower/" + cart.fid,
                type: "get",
                dataType: "json",
                success: function (data) {
                    //start
                    //alert(data.data.fname)
                    html+="<td>"+data.data.fname+"&nbsp"+"</td>";
                    html+="<td>"+data.data.fprice+"&nbsp"+"</td>";
                    html+="<td>"+'<input type="text" name="number" value="data.data.conunt" id="${bean.id }_num" size="5" />'+"&nbsp";
                    '<a href="function();" onclick="">变更</a>'+"&nbsp"+"</td>";
                    html+="<td>"+data.data.fprice*+"&nbsp"+"</td>";
                    html+="<td>"+data.data.fname+"&nbsp"+"</td>";
                    //end
                },
                error: function () {
                    alert("请求失败")
                }
            });
        })

        $("#tbody").html(html);
    },
    error: function () {
        alert("请求失败")
    }
});

function change(id) {};

function del(id) {};

function showname(fid) {
    var name = "";
    //ajax get

    return name;
}
