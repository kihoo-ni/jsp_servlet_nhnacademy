package com.nhnacademy.student.controller;

import com.nhnacademy.student.Command;
import com.nhnacademy.student.model.Student;
import com.nhnacademy.student.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class StudentListController implements Command {

    private StudentRepository studentRepository;


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        List<Student> studentList = studentRepository.getStudents();
        req.setAttribute("studentList", studentList);

        return "/student/list.jsp";

    }
}

