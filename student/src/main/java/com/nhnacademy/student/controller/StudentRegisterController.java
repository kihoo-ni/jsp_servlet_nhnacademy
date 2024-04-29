package com.nhnacademy.student.controller;

import com.nhnacademy.student.Command;
import com.nhnacademy.student.model.Gender;
import com.nhnacademy.student.model.Student;
import com.nhnacademy.student.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegisterController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository=(StudentRepository)request.getServletContext().getAttribute("studentRepository");

        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String genderParam=request.getParameter("gender");
        String ageParam=request.getParameter("age");

        if (id == null || name == null || genderParam == null || ageParam == null) {
            request.setAttribute("error", "Please fill all the required fields");
            return "redirect:/student/register.do";

        }

        try{
            Gender gender=Gender.valueOf(genderParam);
            int age=Integer.parseInt(ageParam);

            Student student=new Student(id,name,gender,age);
            studentRepository.save(student);

            return "redirect:/student/view.do?id="+student.getId();
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "입력값이 유효하지 않습니다.");
            return "redirect:/student/register.do";
        }
    }
}
