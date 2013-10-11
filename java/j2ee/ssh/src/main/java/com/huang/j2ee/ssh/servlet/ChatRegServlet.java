package com.huang.j2ee.ssh.servlet;

import com.huang.j2ee.ssh.service.ChatService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User : Morn
 * Date : 2013-10-10 16:27
 */
public class ChatRegServlet extends HttpServlet {
    private static final String REG_PAGE = "/jsp/chatreg.jsp";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        if (name == null || pass == null) {
            req.setAttribute("tip", "UserName or Password Must not be empty");
            forward(REG_PAGE, req, resp);
        }

        try {
            if (ChatService.instance().addUser(name, pass)) {
                req.setAttribute("tip", "Register successfully, please login!");
                forward(REG_PAGE, req, resp);
            } else {
                req.setAttribute("tip", "Register failed, please try again!");
                forward(REG_PAGE, req, resp);
            }

        } catch (Exception e) {
            req.setAttribute("tip", e.getMessage());
            forward(REG_PAGE, req, resp);
        }

    }

    private void forward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }

}
