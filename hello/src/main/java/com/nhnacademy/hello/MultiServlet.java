package com.nhnacademy.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;



@WebServlet(
        name = "multiServlet",
        urlPatterns = "/multi"
)
public class MultiServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(MultiServlet.class.getName());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
       String[]multi=req.getParameterValues("tool");
        String url = getServletContext().getInitParameter("url");
       PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
       for(int i=0;i<multi.length;i++){
        if(i==multi.length-1){
            out.print(multi[i]);
            break;
        }
       out.print(multi[i]);
       out.println(",");

       }
       out.printf("url: %s\n",url);
    }



}
