package com.nhnacademy.student.controller;

import com.nhnacademy.student.controllerfactory.RequestMapping;
import com.nhnacademy.student.model.Gender;
import com.nhnacademy.student.model.Student;
import com.nhnacademy.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@RequestMapping(value = "/student/update.do", method = RequestMapping.Method.POST)
public class StudentUpdateController implements Command {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");


        if (id == null || id.trim().isEmpty()) {
            log.error("ID is null or empty");
            return "redirect:/student/list.do";
        }

        Student student = studentRepository.getStudentById(id);
        if (student == null) {
            log.error("Student not found");
            return "redirect:/student/list.do";
        }

        student.setName(request.getParameter("name"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setGender(Gender.valueOf(request.getParameter("gender")));
        log.error("Student name is " + student.getName());
        log.error("Student Age is " + student.getAge());

        studentRepository.update(student);


        return "redirect:/student/view.do?id=" + student.getId();
    }
}
