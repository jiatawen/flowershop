$("#logout").click(function() {logout();})

function logout() {
    $.ajax({
        type: "get",
        url: "/logout",
        dataType: "json",
        success: function (data) {
            if (data == 0) {
                window.location.href = "/user/index/index.html";
            }
        },
    });
}