package com.skoogle.desktop.dao;

import com.skoogle.desktop.model.School;
import java.util.List;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
public interface SchoolDAO {

    void insertSchool(School model) throws Exception;
    void updateSchool(School model) throws Exception;
    List<School> listSchools();
}
