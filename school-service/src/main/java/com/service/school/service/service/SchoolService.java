package com.service.school.service.service;

import com.service.school.service.client.StudentClient;
import com.service.school.service.dto.SchoolResponse;
import com.service.school.service.dto.StudentDto;
import com.service.school.service.entity.School;
import com.service.school.service.entity.Student;
import com.service.school.service.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public SchoolService(SchoolRepository schoolRepository, StudentClient studentClient) {
        this.schoolRepository = schoolRepository;
        this.studentClient = studentClient;
    }

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public SchoolResponse findSchoolsWithStudents(Integer schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School not found"));

        List<StudentDto> students = studentClient.findAllStudentsBySchool(schoolId);

        return new SchoolResponse(
                school.getName(),
                school.getEmail(),
                students
        );
    }
}
