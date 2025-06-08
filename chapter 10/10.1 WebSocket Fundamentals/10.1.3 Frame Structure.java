WebSocket frames carry application data:
Text frames (UTF-8 strings)
Binary frames (Blob, ArrayBuffer)
Ping/Pong for keep-alive
Close to shut down

A text frame looks like:

0x81 0x05 'H' 'e' 'l' 'l' 'o'
0x81 = FIN bit + text opcode
0x05 = payload length
Hello = message