package com.huang.study.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeYou
 */
@WebServlet(name = "WelcomeYou",
            urlPatterns = "/welcome")
public class WelcomeYou extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String welcomeInfo = "Welcome you, " + user;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>");
		out.println("Welcome page");
		out.println("</title></head><body>");
		out.println(welcomeInfo);
		out.println("</body></html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
