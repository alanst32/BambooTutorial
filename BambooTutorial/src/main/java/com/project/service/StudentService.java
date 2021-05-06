package main.java.com.project.service;

import main.java.com.project.dto.StudentSearchDto;
import main.java.com.project.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findStudents(StudentSearchDto request);
}
