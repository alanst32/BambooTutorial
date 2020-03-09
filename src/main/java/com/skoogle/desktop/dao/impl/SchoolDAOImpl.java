package com.skoogle.desktop.dao.impl;

import com.skoogle.desktop.dao.SchoolDAO;
import com.skoogle.desktop.model.School;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.TypedSort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@Repository("SchoolDAO")
public class SchoolDAOImpl implements SchoolDAO {

    @Autowired
    @Qualifier("mongoTemplate")
    private MongoTemplate mongoTemplate;

    @Override
    public void insertSchool(School model) throws Exception {
        mongoTemplate.save(model);
    }

    @Override
    public void updateSchool(School model) throws Exception {
        mongoTemplate.save(model);
    }

    @Override
    public List<School> listSchools() {
        TypedSort<School> typedSort = Sort.sort(School.class);
        typedSort.by(School::getName).ascending();

        Query query = new Query();
        query.with(typedSort);

        return this.mongoTemplate.find(query, School.class);
    }
}
