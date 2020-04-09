package com.skoogle.desktop.service;

import com.skoogle.desktop.dto.SchoolUserDto;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
public interface UserService {

    void insertSchoolUser(SchoolUserDto dto) throws Exception;
}
