function userupdatelist(){
    $("#welcome").html("欢迎 "+ _user.uname);
    $("#titlename").html(_user.uname);

    setTbody();
}

function setTbody(){
    // ajax get请求
    $.ajax({
        url:"/tUserContact",
        type:"GET",
        datatype:"json",
        data:{uId:_user.uid},
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