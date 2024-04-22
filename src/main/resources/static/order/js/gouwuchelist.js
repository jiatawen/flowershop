function changenum(id){
    var num = document.getElementById(id+"_num").value;
    var reg1 =  /^\d+$/;
if (num.match(reg1) == null)
{
    alert("购买数量必须为正整数");
    return false;
}
    if (num == 0 )
{
    alert("购买数量必须大于0的正整数");
    return false;
}
    var now = new Date(); 
    var t = now.getTime()+''; 
    window.location.href="<%=basePath %>indexServlet/gouwucheupdate2?id="+id+"&number="+num+"&t="+t;
    
    
}