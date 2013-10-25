package com.huang.j2ee.ch01.servlet;

import com.huang.j2ee.ch01.service.ChatService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User : Morn
 * Date : 2013-10-10 17:39
 */
public class ChatLoginServlet extends HttpServlet {
    private static final String LOGIN_PAGE = "/jsp/chatlogin.jsp";
//    private static final String CHAT_PAGE = "/jsp/chat.jsp";
    private static final String CHAT_PAGE = "/html/chat.html";

    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
        //设置使用utf-8字符集来解析请求参数
        req.setCharacterEncoding("utf-8");

        //取得用户的两个请求参数
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        //进行服务器端的输入校验
        if (name == null || pass == null)
        {
            req.setAttribute("tip", "用户名和密码都不能为空");
            forward(LOGIN_PAGE , req , resp);
        }

        //调用ChatService对象的validLogin方法来验证登录
        //如果登录成功
        if (ChatService.instance().validLogin(name , pass))
        {
            req.getSession(true).setAttribute("user" , name);
            req.setAttribute("msg", ChatService.instance().getMsg());
            forward(CHAT_PAGE ,req , resp);
        }
        //如果登录失败
        else
        {
            req.setAttribute("error", "用户名和密码不匹配");
            forward(LOGIN_PAGE , req , resp);
        }
    }
    //执行转发请求的方法
    private void forward(String url , HttpServletRequest request,
                         HttpServletResponse response)throws ServletException,IOException
    {
        //获取RequestDispatcher对象
        RequestDispatcher rd = request.getRequestDispatcher(url);

        //执行转发
        rd.forward(request,response);
    }
}
