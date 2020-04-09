package com.skoogle.desktop.service;

import com.skoogle.desktop.dto.SchoolUserDto;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
public interface AuthenticationService {

    void registerSchoolUser(SchoolUserDto schoolUserDto);
}
