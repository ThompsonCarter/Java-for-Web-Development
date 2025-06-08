public class ChatMessage {
  private String from;
  private String text;
  // getters/setters
}
@Controller
public class ChatController {
  @MessageMapping("/chat.send")
  @SendTo("/topic/public")
  public ChatMessage sendMessage(ChatMessage message) {
    return message;
  }

  @MessageMapping("/chat.addUser")
  @SendTo("/topic/public")
  public ChatMessage addUser(@Payload ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
    headerAccessor.getSessionAttributes().put("username", message.getFrom());
    message.setText(message.getFrom() + " joined!");
    return message;
  }
}