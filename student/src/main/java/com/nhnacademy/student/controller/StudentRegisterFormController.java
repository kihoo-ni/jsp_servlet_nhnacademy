package com.nhnacademy.student.controller;

import com.nhnacademy.student.controllerfactory.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/student/register.do", method = RequestMapping.Method.GET)
public class StudentRegisterFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/student/register.jsp";
    }
}



