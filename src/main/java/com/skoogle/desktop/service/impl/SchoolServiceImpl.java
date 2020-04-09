package com.skoogle.desktop.service.impl;

import com.skoogle.desktop.dao.SchoolDAO;
import com.skoogle.desktop.dto.AddressDto;
import com.skoogle.desktop.dto.SchoolRequestDto;
import com.skoogle.desktop.model.Address;
import com.skoogle.desktop.model.School;
import com.skoogle.desktop.service.SchoolService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@Service("SchoolService")
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolDAO schoolDAO;

    @Override
    public void insertSchool(SchoolRequestDto dto) throws Exception {
        School model = fillModelClasses(dto, true);
        schoolDAO.insertSchool(model);
    }

    @Override
    public List<School> listSchools() throws Exception {
        return schoolDAO.listSchools();
    }


    private School fillModelClasses(SchoolRequestDto dto, boolean isInsertion) {
        School school = new School();

        if (isInsertion) {
            school.setId(UUID.randomUUID().toString());
        }
        school.setName(dto.getName());
        school.setAddress(convertAddressDtoToModel(dto.getAddress()));
        return school;
    }

    private Address convertAddressDtoToModel(AddressDto dto) {
        if (dto == null) {
            return null;
        }

        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setStreetNumber(dto.getStreetNumber());
        address.setCity(dto.getCity());
        address.setZipCode(dto.getZipCode());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        return address;
    }
}
