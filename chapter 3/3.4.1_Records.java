public record UserRecord(String username, int id) {}

var u = new UserRecord("alice", 101);
System.out.println(u.username());