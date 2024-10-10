var socket = new SockJS('/services/chat');
var stompClient = Stomp.over(socket);
const curPath = window.location.pathname;
const chatId = curPath.substring(curPath.lastIndexOf('/')+1, curPath.length);

stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    // Подписываемся на канал
    stompClient.subscribe(`/topic/messages/${chatId}`, function (message) {
        console.log(JSON.parse(message.body));
        showMessage(JSON.parse(message.body));
    });
});

document.getElementById("send-button").addEventListener("click", sendMessage);

function sendMessage() {
    var message = {
        content: document.getElementById('message-input').value,
        sentAt: null
    };

    // Отправляем сообщение на сервер
    stompClient.send(`/app/send_message/${chatId}`, {}, JSON.stringify(message));
}

function showMessage(message) {
    var messageHolder = document.getElementById('scroll-view');
    messageHolder.innerHTML += `<div id="message-id">
    <span>NONE</span>
    <span>${message.content}</span>
    <span>NONE</span>
    <hr/>
</div>`;
}