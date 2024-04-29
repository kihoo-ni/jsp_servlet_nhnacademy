package com.nhnacademy.student.controller;

import com.nhnacademy.student.Command;
import com.nhnacademy.student.model.Student;
import com.nhnacademy.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
public class StudentUpdateFormController implements Command{


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository=(StudentRepository) request.getServletContext().getAttribute("studentRepository");

        String id = request.getParameter("id");
        if(Objects.isNull(id) || id.isEmpty()){
            log.error("Student id is null or empty");
            return "redirect:/student/list.do";

        }
        Student student = studentRepository.getStudentById(id);
        if(Objects.isNull(student)){
            log.error("Student not found");
            return "redirect:/student/list.do";
        }

        request.setAttribute("student",student);


        return "/student/register.jsp";
    }
}

