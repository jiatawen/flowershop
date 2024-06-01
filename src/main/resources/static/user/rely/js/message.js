var _user = null;
var uid = getUrlParam("uid");
$(document).ready(function () {
    Start();
    changeButton(1);
    // 调用函数创建图表
    createPieChart();
    createBarChart();
    createLineChart();
    setTbody();
});

function changeButton(flag){
    if(flag == 1){
        //jquery让#but1不能点击
        $("#but1").attr("disabled",true);
        $("#but2").attr("disabled",false);
        $("#but3").attr("disabled",false);
        $("#but4").attr("disabled",false);

        $("#flower").css("display", "flex");
        $("#login").css("display", "none");
        $("#money").css("display", "none");
        $("#adresslist").css("display", "none");

    }else if(flag == 2){
        //jquery让#but2不能点击
        $("#but1").attr("disabled",false);
        $("#but2").attr("disabled",true);
        $("#but3").attr("disabled",false);
        $("#but4").attr("disabled",false);

        $("#flower").css("display", "none");
        $("#login").css("display", "block");
        $("#money").css("display", "none");
        $("#adresslist").css("display", "none");
    }else if(flag == 3){
        //jquery让#but3不能点击
        $("#but1").attr("disabled",false);
        $("#but2").attr("disabled",false);
        $("#but3").attr("disabled",true);
        $("#but4").attr("disabled",false);

        $("#flower").css("display", "none");
        $("#login").css("display", "none");
        $("#money").css("display", "block");
        $("#adresslist").css("display", "none");
    }else if(flag == 4){
        //jquery让#but4不能点击
        $("#but1").attr("disabled",false);
        $("#but2").attr("disabled",false);
        $("#but3").attr("disabled",false);
        $("#but4").attr("disabled",true);

        $("#flower").css("display", "none");
        $("#login").css("display", "none");
        $("#money").css("display", "none");
        $("#adresslist").css("display", "block");
    }
}

function but1(){
    changeButton(1);
}

function but2(){
    changeButton(2);
}

function but3(){
    changeButton(3);
}

function but4(){
    changeButton(4);
}

// 创建柱状图
function createBarChart() {
    var ctx = document.getElementById('barChart').getContext('2d');
        var barChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July','August','September','October','November','December'],
                datasets: [{
                    label: 'Example Dataset',
                    data: [65, 59, 80, 81, 56, 55, 40, 60, 60, 60, 60, 60],
                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });
}

// 创建饼图
function createPieChart() {
    var ctx = document.getElementById('pieChart').getContext('2d');
    var pieChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
            datasets: [{
                data: [12, 19, 3, 5, 2, 3],
                backgroundColor: [
                    'red',
                    'blue',
                    'yellow',
                    'green',
                    'purple',
                    'orange'
                ]
            }]
        }
    });
}

function createLineChart() {
    var ctx = document.getElementById('lineChart').getContext('2d');
        var lineChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                datasets: [{
                    label: 'Example Dataset',
                    data: [65, 59, 80, 81, 56, 55, 40],
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 1
                }]
            }
        });
}

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

function setTbody(){
    // ajax get请求
    $.ajax({
        url:"/tUserContact",
        type:"GET",
        datatype:"json",
        data:{uId:uid},
        success:function (data){
            let records = data.data.records;
           let str = "";
           records.forEach(function(record){
            str += '<tr class = "odd">';
            str += '<td>'+record.ucName+'</td>';
            str += '<td>'+record.ucTel+'</td>';
            str += '<td>'+record.ucAddress+'</td>';
            str += '<td><a href="./useraddressupdate.html?id='+record.id+'">修改</a>&nbsp;<a href="del('+record.id+')">删除</a></td>';
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