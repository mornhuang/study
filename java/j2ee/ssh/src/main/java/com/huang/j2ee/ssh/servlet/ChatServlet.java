package com.huang.j2ee.ssh.servlet;

import com.huang.j2ee.ssh.service.ChatService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User : Morn
 * Date : 2013-10-10 17:38
 */
public class ChatServlet extends HttpServlet {
//    private static final String CHAT_PAGE = "/jsp/chat.jsp";
    private static final String CHAT_PAGE = "/html/chat.html";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String msg = req.getParameter("chatMsg");
        if ( msg != null &&  !msg.equals(""))
        {
            //取得当前用户
            String user = (String)req.getSession(true).getAttribute("user");

            //调用ChatService的addMsg来添加聊天消息
            ChatService.instance().addMsg(user, msg);
        }
        req.setAttribute("msg" , ChatService.instance().getMsg());

        //转发到聊天页面 (正常模式)
/*
        forward(CHAT_PAGE, req, resp);
*/

        // Ajax 1方式
/*
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(ChatService.instance().getMsg());
*/

        // Ajax 2方式
        req.setAttribute("chatList", ChatService.instance().getMsg());
        forward("/jsp/chatReply.jsp", req, resp);
    }

    private void forward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }

}
