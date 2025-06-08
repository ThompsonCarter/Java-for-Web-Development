
// Contact JSP view
<%@ page contentType="text/html" %>
<html>
<head><title>Contacts</title></head>
<body>
  <h1>Your Contacts</h1>
  <ul>
    <c:forEach var="c" items="${contacts}">
      <li>${c.name} – ${c.email}</li>
    </c:forEach>
  </ul>
  <h2>Add Contact</h2>
  <form method="post" action="contacts">
    Name: <input name="name"/><br/>
    Email: <input name="email"/><br/>
    <button type="submit">Add</button>
  </form>
</body>
</html>
