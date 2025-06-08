
// HelloServlet Java code
package com.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet {
  @Override
  public void init() throws ServletException {
    System.out.println("HelloServlet initialized");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain");
    try (PrintWriter out = res.getWriter()) {
      out.println("Hello, Jakarta EE!");
    }
  }

  @Override
  public void destroy() {
    System.out.println("HelloServlet destroyed");
  }
}
