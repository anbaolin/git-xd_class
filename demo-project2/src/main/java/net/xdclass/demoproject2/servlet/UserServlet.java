package net.xdclass.demoproject2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用servlet3.0开发原生的接口
 */
@WebServlet(name ="userServlet" ,urlPatterns ="/api/v1/test/custons")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter   writer = resp.getWriter();
        writer.write("this is  my custons");
        writer.flush();
        writer.close();


    }
}
