package com.skoogle.desktop.dao;

import com.skoogle.desktop.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@Repository("SchoolDAO")
@SuppressWarnings("unchecked")
public class SchoolDAOImpl implements SchoolDAO {

    @Autowired
    @Qualifier("mongoTemplate")
    private MongoTemplate mongoTemplate;

    @Override
    public void insertSchool(School model) throws Exception {
        mongoTemplate.save(model);
    }
}
