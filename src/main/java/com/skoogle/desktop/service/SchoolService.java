package com.skoogle.desktop.service;

import com.skoogle.desktop.dto.SchoolRequestDto;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
public interface SchoolService {

    void insertSchool(SchoolRequestDto dto) throws Exception;
}
