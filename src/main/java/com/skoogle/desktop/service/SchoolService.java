package com.skoogle.desktop.service;

import com.skoogle.desktop.dto.SchoolRequestDto;
import com.skoogle.desktop.model.School;
import java.util.List;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
public interface SchoolService {

    void insertSchool(SchoolRequestDto dto) throws Exception;
    List<School> listSchools() throws Exception;
}
