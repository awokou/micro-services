package com.service.student.service.service.impl;

import com.service.student.service.dto.StudentDto;
import com.service.student.service.entity.Student;
import com.service.student.service.repository.StudentRepository;
import com.service.student.service.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(StudentDto student) {

        Student studentEntity = new Student();
        studentEntity.setFirstname(student.getFirstname());
        studentEntity.setLastname(student.getLastname());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setSchoolId(student.getSchoolId());

        return studentRepository.save(studentEntity);
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getFirstname(),
                        student.getLastname(),
                        student.getEmail(),
                        student.getSchoolId()
                )).toList();
    }

    @Override
    public List<StudentDto> findAllStudentsBySchool(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId)
                .stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getFirstname(),
                        student.getLastname(),
                        student.getEmail(),
                        student.getSchoolId()
                )).toList();
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

}
