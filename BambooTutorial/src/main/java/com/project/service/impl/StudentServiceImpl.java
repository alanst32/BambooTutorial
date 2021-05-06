package main.java.com.project.service.impl;

import main.java.com.project.dto.StudentSearchDto;
import main.java.com.project.model.Student;
import main.java.com.project.repository.StudentRepository;
import main.java.com.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findStudents(StudentSearchDto request) {
        return studentRepository.findStudents(request);
    }
}
