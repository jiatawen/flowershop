function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}

$(document).ready(function () {
    Start();
})

function Start() {
    $("span.pie").peity("pie");
    getName();
    getMessage();
    drawPicture();

}
function drawPicture(){
    let jsonData;
    $.ajax({
        url: "../MessageAction?action=getIndent",
        type:"post",
        data:{"id":getUrlParam("id")},
        success:function (data){
            jsonData = eval(data)

            // 提取前三个商品的数据
            var topThreeData = jsonData
                .sort((a, b) => b.amount - a.amount)
                .slice(0, 3);

            var labels = topThreeData.map(data => data.item);
            var amounts = topThreeData.map(data => data.amount);

// 创建条形图
            var ctx = document.getElementById('chart').getContext('2d');
            var chart = new Chart(ctx, {
                type: 'horizontalBar',
                data: {
                    labels: labels,
                    datasets: [{
                        data: amounts,
                        backgroundColor: 'rgba(54, 162, 235, 0.7)',
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: false,
                    legend: {
                        display: false
                    },
                    scales: {
                        xAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
        }
    });
// 模拟后台提供的JSON数据
    // jsonData = [
    //     {item: '商品A', amount: 150},
    //     {item: '商品B', amount: 250},
    //     {item: '商品C', amount: 100},
    //     {item: '商品D', amount: 200},
    //     {item: '商品E', amount: 180},
    //     {item: '商品F', amount: 120},
    // ];


}
function getMessage() {
    let AllMessage;
    let MonthMessage;
    $.ajax({
        url: "../MessageAction?action=getAll",
        type:"post",
        data:{"id":getUrlParam("id")},
        success:function (data){
            AllMessage = eval(data)
            $("#totalMoney").html("<span>总计购买金额</span>\n" +
                "          <div>\n" +
                AllMessage["buymoney"] +
                "          </div>")
        }
    });
    $.ajax({
        url: "../MessageAction?action=getMonth",
        type:"post",
        data:{"id":getUrlParam("id")},
        success:function (data){
            MonthMessage = eval(data)
            $("#searchcount").html(MonthMessage["searchcount"] + "次");
            $("#pie1").html(MonthMessage["searchcount"] + "/100");
            $("#buyCount").html(MonthMessage["buycount"] + "次");
            $("#pie2").html(MonthMessage["buycount"] + "/100");
            $("#headmoney").html(MonthMessage["buymoney"]);
            if (MonthMessage["buymoney"] < 100){
                $("#pie3").html(MonthMessage["buymoney"] + "/100");
            }else if(MonthMessage["buymoney"] < 1000){
                $("#pie3").html(MonthMessage["buymoney"] + "/1000");
            }else if(MonthMessage["buymoney"] < 10000){
                $("#pie3").html(MonthMessage["buymoney"] + "/10000");
            }else if(MonthMessage["buymoney"] < 20000){
                $("#pie3").html(MonthMessage["buymoney"] + "/20000");
            }else {
                $("#pie3").html(MonthMessage["buymoney"] + "/100000");
            }
            if (MonthMessage["searchcount"] == 0){
                $("#seaBuy").html("100");
                $("#pie4").html("100/100");
            }else {
                $("#seaBuy").html(MonthMessage["buycount"] /  MonthMessage["searchcount"]);
                $("#pie4").html(MonthMessage["buycount"] + "/" +  MonthMessage["searchcount"]);
            }
            $("span.pie").peity("pie");
            $("#MonthMoney").html("<span>本月购买金额</span>\n" +
                "          <div>" +
                MonthMessage["buymoney"]+
                "</div>")
        }
    });
}

function getName() {
    $.ajax({
        url: "../UserAction?action=findById",
        data: {"id": getUrlParam("id")},
        type: "POST",
        success: function (data) {
            $("#userName").html(eval(data)["name"])
        }
    })
}