package com.skoogle.desktop.service.impl;

import com.skoogle.desktop.dao.UserDAO;
import com.skoogle.desktop.dto.SchoolUserDto;
import com.skoogle.desktop.model.User;
import com.skoogle.desktop.service.UserService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void insertSchoolUser(SchoolUserDto dto) throws Exception {
        User model = fillModelClasses(dto, true);
        userDAO.insertSchoolUser(model);
    }

    private User fillModelClasses(SchoolUserDto dto, boolean isInsertion) {
        User user = new User();

        if (isInsertion) {
            user.setId(UUID.randomUUID().toString());
        }
        user.setCrendential(dto.getCredential());
        user.setName(dto.getName());
        user.setSchoolId(dto.getSchoolId());
        return user;
    }
}
