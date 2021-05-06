package main.java.com.project.repository.impl;

import main.java.com.project.dto.StudentSearchDto;
import main.java.com.project.model.Student;
import main.java.com.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Student> findStudents(StudentSearchDto request) {
        Sort.TypedSort<Student> typedSort = Sort.sort(Student.class);
        typedSort.by(Student::getFirstName).ascending();

        Query query = new Query();
        query.addCriteria(Criteria.where("inactive").ne(true));
        if (!ObjectUtils.isEmpty(request.getName())) {
            query.addCriteria(Criteria.where("firstName").regex(request.getName()));
            query.addCriteria(Criteria.where("lastName").regex(request.getName()));
        }
        if (!ObjectUtils.isEmpty(request.getSkills())) {
            query.addCriteria(Criteria.where("skills").all(request.getSkills()));
        }
        query.with(typedSort);
        return this.mongoTemplate.find(query, Student.class);
    }
}
