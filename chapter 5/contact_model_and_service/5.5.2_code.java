
// Contact model and service
public class Contact {
  private String name;
  private String email;
  // getters and setters
}

@ApplicationScoped
public class ContactService {
  private final List<Contact> contacts = new ArrayList<>();

  public List<Contact> list() { return contacts; }
  public void add(Contact c) { contacts.add(c); }
}
