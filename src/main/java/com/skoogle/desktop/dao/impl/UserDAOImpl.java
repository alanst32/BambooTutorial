package com.skoogle.desktop.dao.impl;

import com.skoogle.desktop.dao.UserDAO;
import com.skoogle.desktop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

    @Autowired
    @Qualifier("mongoTemplate")
    private MongoTemplate mongoTemplate;

    @Override
    public void insertSchoolUser(User model) throws Exception {
        mongoTemplate.save(model);
    }
}
