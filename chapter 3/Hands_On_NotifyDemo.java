public class NotifyDemo {
  public static void main(String[] args) {
    Notifier email = new EmailNotifier();
    Notifier sms = new SMSNotifier();

    email.send("Your order has shipped!");
    sms.send("Your code is 123456");
  }
}