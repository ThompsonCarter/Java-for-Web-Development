Client connects to /ws → upgrades to WebSocket.
Sends CONNECT frame with headers (login, passcode).
Server replies with CONNECTED frame.
Client subscribes to topics (SUBSCRIBE to /topic/chat).
Client sends messages (SEND to /app/chat).
Server broadcasts to /topic/chat.