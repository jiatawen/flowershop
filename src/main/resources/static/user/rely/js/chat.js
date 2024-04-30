function toggleChat() {
    var chatBox = document.getElementById("chat-box");
    if (chatBox.style.display === "none" || chatBox.style.display === "") {

        chatBox.style.display = "block";
    } else {
        chatBox.style.display = "none";
    }
}

function sendMessage() {
    var messageInput = $("#message-input");
    var messageContent = messageInput.val().trim();
    if (messageContent !== "") {
        var chatContent = $("#chat-content");
        var message = $('<div class="message sent"><span class="sender">' + messageContent + '</span></div>');
        chatContent.append(message)

        messageInput.val(""); // 清空输入框
        chatContent.scrollTop(chatContent.prop("scrollHeight")); // 滚动到底部

        $("#send-button").html("⏳. . .");
        // 禁用发送按钮并禁止点击事件
        var sendButton = $("#send-button");
        sendButton.prop("disabled", true);
        sendButton.find(".loading-icon").addClass("active");

        //ajaxpost亲求发送message
        $.ajax({
            type: "POST",
            url: "/chat",
            data: {
                message: messageContent
            },
            dataType: "json",
            success: function (data) {
                $("#send-button").html("Send");
                // 请求完成后解除发送按钮的禁用状态并恢复点击事件
                sendButton.prop("disabled", false);
                sendButton.find(".loading-icon").removeClass("active");

                let received = data.choices[0].message.content;
                var message = $('<div class="message received"><span class="sender">' + received + '</span></div>');
                chatContent.append(message)
                chatContent.scrollTop(chatContent.prop("scrollHeight")); // 滚动到底部
            },
            error: function () {
                $("#send-button").html("Send");
                // 请求完成后解除发送按钮的禁用状态并恢复点击事件
                sendButton.prop("disabled", false);
                sendButton.find(".loading-icon").removeClass("active");
                var message = $('<div class="message received"><span class="sender" style="color:red;">网络连接错误</span></div>');
                chatContent.append(message)
                chatContent.scrollTop(chatContent.prop("scrollHeight")); // 滚动到底部
            }
        });
    }


}

$("#message-input").keypress(function (e) {
    if (e.which == 13) {
        sendMessage();
    }
});

$("#send-button").click(function () {
    sendMessage();
});