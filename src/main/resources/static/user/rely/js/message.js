var _user = null;
var uid = getUrlParam("uid");
$(document).ready(function () {
    Start();
    createLineChart();
    setTbody();
});
// 折线图
function createLineChart() {
    // ajaxget
    $.ajax({
        url: "/userMonthlyActivety?uId=" + uid,
        type: "get",
        dataType: "json",
        success: function (data) {
            //定义数组
            let month = [];
            let loginTimes = [];
            let orderCount = [];
            let totalSumPrice = [];

            data.forEach(function (lab) {
                //如果为null变为0
                if (lab.loginTimes == null) {
                    lab.loginTimes = 0;
                }
                if (lab.orderCount == null) {
                    lab.orderCount = 0;
                }
                if (lab.totalSumPrice == null) {
                    lab.totalSumPrice = 0;
                }
                if (lab.month == null) {
                    lab.month = 0;
                }

                // 添加进数组
                month.push(lab.month);
                loginTimes.push(lab.loginTimes);
                orderCount.push(lab.orderCount);
                totalSumPrice.push(lab.totalSumPrice);
            });
            var ctx = document.getElementById('lineChart').getContext('2d');
            var lineChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: month,
                    datasets: [{
                        label: '登录次数',
                        data: loginTimes,
                        borderColor: 'rgba(255, 99, 132, 1)',
                        borderWidth: 1
                    }, {
                        label: '消费金额',
                        data: totalSumPrice,
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 1
                    }, {
                        label: '消费次数',
                        data: orderCount,
                        borderColor: 'rgba(31, 31, 31)',
                        borderWidth: 1
                    }],

                }
            });
        }
    });


}

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

function setTbody() {
    //将#butt1设为不可点击
    $("#butt1").attr("disabled", "disabled");
    $("#butt1").css("cursor", "not-allowed");
    $("#butt1").css("background-color", "gray");
    $("#addresslist").css("display", "none");

    // ajax get请求
    $.ajax({
        url: "/tUserContact",
        type: "GET",
        datatype: "json",
        data: { uId: uid },
        success: function (data) {
            let records = data.data.records;
            let str = "";
            records.forEach(function (record) {
                str += '<tr class = "odd">';
                str += '<td>' + record.ucName + '</td>';
                str += '<td>' + record.ucTel + '</td>';
                str += '<td>' + record.ucAddress + '</td>';
                str += '<td><a href="./useraddressupdate.html?id=' + record.id + '">修改</a>&nbsp;<a href="del(' + record.id + ')">删除</a></td>';
                str += '</tr>';
            });
            $("#tbody").html(str);
        }
    });
}


function Start() {
    $.ajax({
        url: "/getSession",
        type: "get",
        dataType: "json",
        success: function (data) {
            if (data == null) {
                offline();
            } else {
                _user = data;
                let text = "";
                if (data.ustatus == 0) {
                    text = "<span>欢迎您，" + data.uname + "</span><a href=\"/user/controller/userlist.html\">控制台</a>";
                } else {
                    text = "欢迎您，" + data.uname;
                }
                $("#welcome").html(text);
                online(data);
            }
        },
        error: function () {
            offline();
        }
    })
}

function online(data) {
    // 改变class为onlogin的css样式为可见
    $(".onlogin").css("display", "block");
    $(".unlogin").css("display", "none");
}

function offline() {
    // 改变class为onlogin的css样式为不可见
    $(".onlogin").css("display", "none");
    $(".unlogin").css("display", "block");
}

$("#butt1").click(function () {
    $("#butt1").attr("disabled", "disabled");
    $("#butt1").css("cursor", "not-allowed");
    $("#butt1").css("background-color", "gray");
    $("#addresslist").css("display", "none");


    //将butt2恢复为可点击
    $("#butt2").removeAttr("disabled");
    $("#butt2").css("cursor", "pointer");
    $("#butt2").css("background-color", "#efefef");


    $("#money").css("display", "block");
});

$("#butt2").click(function () {
    $("#butt2").attr("disabled", "disabled");
    $("#butt2").css("cursor", "not-allowed");
    $("#butt2").css("background-color", "gray");
    $("#money").css("display", "none");

    //将butt1恢复为可点击
    $("#butt1").removeAttr("disabled");
    $("#butt1").css("cursor", "pointer");
    $("#butt1").css("background-color", "#efefef");

    $("#addresslist").css("display", "block");
});