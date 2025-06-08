<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Live Chat</title>
  <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/sockjs.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/stompjs@2/stomp.min.js"></script>
</head>
<body>
  <div id="chat">
    <ul id="messages"></ul>
    <input id="msgInput" placeholder="Type a message..."/>
    <button id="sendBtn">Send</button>
  </div>
  <script>
    let stompClient;
    function connect() {
      const socket = new SockJS('/ws');
      stompClient = Stomp.over(socket);
      stompClient.connect({}, frame => {
        stompClient.subscribe('/topic/public', message => {
          showMessage(JSON.parse(message.body));
        });
        stompClient.send("/app/chat.addUser", {}, JSON.stringify({from: prompt('Your name?'), text: ''}));
      });
    }
    function sendMessage() {
      const text = document.getElementById('msgInput').value;
      stompClient.send("/app/chat.send", {}, JSON.stringify({from:'', text:text}));
    }
    function showMessage(msg) {
      const ul = document.getElementById('messages');
      const li = document.createElement('li');
      li.appendChild(document.createTextNode(msg.from + ": " + msg.text));
      ul.appendChild(li);
    }
    document.getElementById('sendBtn').onclick = sendMessage;
    connect();
  </script>
</body>
</html>