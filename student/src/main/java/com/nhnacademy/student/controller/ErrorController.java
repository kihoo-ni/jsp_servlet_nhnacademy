package com.nhnacademy.student.controller;

import com.nhnacademy.student.controllerfactory.RequestMapping;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequestMapping(value = "/student/error.do", method = RequestMapping.Method.GET)
public class ErrorController implements Command{

    @Override
    public String execute(HttpServletRequest reuest, HttpServletResponse response) {
        final String ERROR_STATUS_CODE = "javax.servlet.error.status_code";
        final String ERROR_EXCEPTION_TYPE = "javax.servlet.error.exception_type";
        final String ERROR_MESSAGE = "javax.servlet.error.message";
        final String ERROR_EXCEPTION = "javax.servlet.error.exception";
        final String ERROR_REQUEST_URI = "javax.servlet.error.reuestuest_uri";
        reuest.setAttribute("status_code", reuest.getAttribute(ERROR_STATUS_CODE));
        reuest.setAttribute("exception_type", reuest.getAttribute(ERROR_EXCEPTION_TYPE));
        reuest.setAttribute("message", reuest.getAttribute(ERROR_MESSAGE));
        reuest.setAttribute("exception", reuest.getAttribute(ERROR_EXCEPTION));
        reuest.setAttribute("req_uri", reuest.getAttribute(ERROR_REQUEST_URI));

        return "/error.jsp";

    }
}
