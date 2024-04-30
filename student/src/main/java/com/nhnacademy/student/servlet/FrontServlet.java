package com.nhnacademy.student.servlet;

import com.nhnacademy.student.controller.Command;
import com.nhnacademy.student.controllerfactory.ControllerFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 공통 처리 - 응답 content-type, character encoding 지정.
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try {


            ControllerFactory controllerFactory = (ControllerFactory) getServletContext().getAttribute("controllerFactory");
            System.out.println("comtrollerFactory :"+controllerFactory);
            log.error("method: {}", req.getMethod());
            log.error("servlet: {}", req.getServletPath());
            log.error("Controller Factory : {}", controllerFactory);
            Command command = (Command) controllerFactory.getBean(req.getMethod(), req.getServletPath());

            String view = command.execute(req, resp);


            if (view.startsWith(REDIRECT_PREFIX)) {
                log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length() + 1));
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length() + 1));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);

            }
        } catch (Exception ex) {
            //공통 error 처리
            req.setAttribute("status_code", req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
            req.setAttribute("exception_type", req.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE));
            req.setAttribute("message", req.getAttribute(RequestDispatcher.ERROR_MESSAGE));
            req.setAttribute("exception", req.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
            req.setAttribute("request_uri", req.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }

    }
}
