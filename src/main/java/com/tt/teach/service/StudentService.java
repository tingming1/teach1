package com.tt.teach.service;

import com.tt.teach.pojo.Student;

import java.util.List;

public interface StudentService {
    Student doLogin(Student student);

    List<Student> getStudentList();

    int deleteStudent(Integer stuNo);

    int updateStudent(Student student);

    Student getStuByNo(Integer stuNo);
}
