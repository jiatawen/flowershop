$(document).ready(function () {
    changeButton(1);
    // 调用函数创建图表
    createPieChart();
    createBarChart();
    createLineChart();
});

function changeButton(flag){
    if(flag == 1){
        //jquery让#but1不能点击
        $("#but1").attr("disabled",true);
        $("#but2").attr("disabled",false);
        $("#but3").attr("disabled",false);
        $("#flower").css("display", "flex");
        $("#login").css("display", "none");
        $("#money").css("display", "none");

    }else if(flag == 2){
        //jquery让#but2不能点击
        $("#but1").attr("disabled",false);
        $("#but2").attr("disabled",true);
        $("#but3").attr("disabled",false);

        $("#flower").css("display", "none");
        $("#login").css("display", "block");
        $("#money").css("display", "none");
    }else if(flag == 3){
        //jquery让#but3不能点击
        $("#but1").attr("disabled",false);
        $("#but2").attr("disabled",false);
        $("#but3").attr("disabled",true);

        $("#flower").css("display", "none");
        $("#login").css("display", "none");
        $("#money").css("display", "block");
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