package com.nhnacademy.student.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Student implements Serializable {



    //아이디
    private  String id;
    //이름
    private  String name;
    //성별
    private  Gender gender;
    //나이
    private  int age;
    //생성일
    private LocalDateTime createdAt;


    // 기본 생성자
    public Student() {
    }

    public Student(String id, String name, Gender gender, int age) {
       this(id, name, gender, age, LocalDateTime.now());

    }
    // 생성자
    public Student(String id, String name, Gender gender, int age, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.createdAt = createdAt;
    }

    // 아이디 getter/setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // 이름 getter/setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 성별 getter/setter
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // 나이 getter/setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 생성일 getter/setter
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}