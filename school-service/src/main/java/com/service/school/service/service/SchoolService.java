package com.service.school.service.service;

import com.service.school.service.client.StudentClient;
import com.service.school.service.dto.FullSchoolResponse;
import com.service.school.service.entity.School;
import com.service.school.service.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    public SchoolService(SchoolRepository repository, StudentClient client) {
        this.repository = repository;
        this.client = client;
    }

    public void saveSchool(School school) {
        repository.save(school);
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId)
                .orElse(School.builder()
                .name("NOT_FOUND")
                .email("NOT_FOUND")
                .build());
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
