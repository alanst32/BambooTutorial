package main.java.com.project.repository;

import main.java.com.project.dto.StudentSearchDto;
import main.java.com.project.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    List<Student> findStudents(StudentSearchDto request);
}