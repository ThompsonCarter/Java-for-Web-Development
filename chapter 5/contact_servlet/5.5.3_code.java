
// Contact servlet
public class ContactServlet extends HttpServlet {
  @Inject
  private ContactService service;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    req.setAttribute("contacts", service.list());
    req.getRequestDispatcher("/contacts.jsp").forward(req, res);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String name = req.getParameter("name");
    String email = req.getParameter("email");
    service.add(new Contact(name, email));
    res.sendRedirect(req.getContextPath() + "/contacts");
  }
}
