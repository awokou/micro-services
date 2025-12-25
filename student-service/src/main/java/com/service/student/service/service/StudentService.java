package com.service.student.service.service;

import com.service.student.service.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> findAllStudents();
    List<Student> findAllStudentsBySchool(Integer schoolId);
    void deleteStudent(Integer id);
}
