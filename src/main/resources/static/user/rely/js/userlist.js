$(document).ready(function () {
    getUsers();
});

function getUsers() {
    //ajax get请求
    $.ajax({
        url: "/tUser",
        type: "get",
        dataType: "json",
        success: function (data) {
            display(data);
        }
    })
}

function display(data) {
    var str = "";
    let users = data.data.records;
    for (let i = 0; i < users.length; i++) {
        str += "<tr class=\"odd\">";
        str += "<td>" + users[i].uid + "</td>";
        if (users[i].ustatus == 0) {
            str += "<td>管理员</td>";
        } else if (users[i].ustatus == 1) {
            str += "<td>普通用户</td>";
        } else if (users[i].ustatus == 2) {
            str += "<td style=\"color:red;\">账户禁用</td>";
        }
        str += "<td>" + users[i].uname + "</td>";
        str += "<td>" + users[i].umail + "</td>";
        str += "<td>" + users[i].ucreatTime + "</td>";
        str += "<td>" + "<a href=\"./message.html?uid=" + users[i].uid + "\">查看用户</a><br>";
        if (users[i].ustatus == 1 ) {
            str += "<a href=\"#\" class=\"removeUser\" onclick=\"blocks(1," + users[i].uid + ",\'" + users[i].uname + "\')\">升为管理员</a>" + "</td>";
        } else if(users[i].ustatus == 0){
            str += "<a href=\"#\" class=\"removeUser\" onclick=\"blocks(0," + users[i].uid + ",\'" + users[i].uname + "\')\">降为一般用户</a>" + "</td>";
        }
        str += "</tr>";
    }
    $("tbody").html(str);
}

function blocks(flag, id, name) {
    if (flag == 1) {
        // 弹出是否删除提示框
        if (confirm("是否升级" + name)) {
            // ajax post请求
            $.ajax({
                url: "/tUser/setStatus",
                type: "post",
                dataType: "json",
                data: {
                    id: id,
                    status: 0
                },
                success: function (data) {
                    getUsers();
                }
            })
        }
    } else if (flag == 0) {
        // 弹出是否删除提示框
        if (confirm("是否降级" + name)) {
            // ajax post请求
            $.ajax({
                url: "/tUser/setStatus",
                type: "post",
                dataType: "json",
                data: {
                    id: id,
                    status: 1
                },
                success: function (data) {
                    getUsers();
                }
            })
        }

    }

}