package com.skoogle.desktop.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.skoogle.desktop.dao.impl.SchoolDAOImpl;
import com.skoogle.desktop.dto.AddressDto;
import com.skoogle.desktop.dto.SchoolRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@RunWith(MockitoJUnitRunner.class)
public class SkoogleServiceImplTest {

    @Mock
    SchoolDAOImpl schoolDAO;

    @InjectMocks
    SchoolServiceImpl schoolService;

    @Test
    public void test_insertSchool_should_call_repo() throws Exception {

        AddressDto addressDto = new AddressDto();
        addressDto.setCountry("Australia");

        SchoolRequestDto dto = new SchoolRequestDto();
        dto.setName("school name");
        dto.setAddress(addressDto);
        this.schoolService.insertSchool(dto);

        verify(schoolDAO, times(1)).insertSchool(any());
    }

    @Test
    public void test_insertSchool_noAddress_call_repo() throws Exception {

        SchoolRequestDto dto = new SchoolRequestDto();
        dto.setName("school name");
        this.schoolService.insertSchool(dto);

        verify(schoolDAO, times(1)).insertSchool(any());
    }

    @Test
    public void test_listSchools_success() throws Exception {
        this.schoolService.listSchools();

        verify(schoolDAO, times(1)).listSchools();
    }
}
