package com.nhnacademy.student.listener;

import com.nhnacademy.student.model.Gender;
import com.nhnacademy.student.model.Student;
import com.nhnacademy.student.repository.JsonStudentRepository;
import com.nhnacademy.student.repository.StudentRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class WebApplicationListener  implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new JsonStudentRepository();

        for(int i=1; i<=10; i++){
            String id=Integer.toString(i);
            String name="student"+id;
            Gender gender;
            if(i%2==0){
                gender= Gender.M;
            } else {
                gender= Gender.F;
            }
            int age=(int)((Math.random()*(31-20)))+20;

            LocalDateTime now = LocalDateTime.now();

           Student student = new Student(id, name, gender, age, now);


            studentRepository.save(student);
        }
        // ... application scope에서 studentRepository 객체에 접근할 수 있도록 구현하기
        context.setAttribute("studentRepository", studentRepository);


    }
}