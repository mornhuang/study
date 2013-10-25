package com.huang.j2ee.ch01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutputInfo
 */
@WebServlet(name="OutputInfo",
        urlPatterns={"/info"})
public class OutputInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Enumeration<String> headNames = request.getHeaderNames();
		
		out.println("<html><head>");
		out.println("<title>Info Page</title>");
		out.println("</head>");
		out.println("<body><center>");
		out.println("<table border=1 align=center>");
		out.println("<caption>Servlet收到的http消息报头</caption>");
		out.println("<tr bgcolor=#999999>");
		out.println("<th>消息报头的名字</th>");
		out.println("<th>消息报头的值</th>");
		out.println("</tr>");
		
		while(headNames.hasMoreElements()) {
			String name = (String)headNames.nextElement();
			String value = request.getHeader(name);
			out.println("<tr>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");
		}
		
		out.println("</table><p>");
		
		
		out.println("</center></body></html>");
	}

}
