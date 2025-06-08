
// Passing data from Servlet to JSP
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
  req.setAttribute("user", "Developer");
  RequestDispatcher rd = req.getRequestDispatcher("/greeting.jsp");
  rd.forward(req, res);
}
