package com.skoogle.desktop.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.skoogle.desktop.dto.SchoolRequestDto;
import com.skoogle.desktop.exception.AccessDeniedException;
import com.skoogle.desktop.model.School;
import com.skoogle.desktop.service.impl.SchoolServiceImpl;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@RunWith(MockitoJUnitRunner.class)
public class SchoolControllerTest {

    @Mock
    SchoolServiceImpl schoolService;

    @InjectMocks
    SchoolController controller;

    @Test
    public void test_insertSchool_accessDeniedException() throws Exception {

        SchoolRequestDto requestDto = new SchoolRequestDto();
        doThrow(new AccessDeniedException(("Exception"))).when(schoolService).insertSchool(requestDto);

        ResponseEntity<Void> response = this.controller.insertSchool(requestDto);

        Assert.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    public void test_insertSchool_shouldNotCallService() throws Exception {

        ResponseEntity<Void> response = this.controller.insertSchool(null);

        verify(schoolService, never()).insertSchool(any());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void test_insertSchool_shouldCallService() throws Exception {

        SchoolRequestDto requestDto = new SchoolRequestDto();
        requestDto.setName("Name");
        ResponseEntity<Void> response = this.controller.insertSchool(requestDto);

        verify(schoolService, times(1)).insertSchool(any());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void test_listSchools_accessDeniedException() throws Exception {

        doThrow(new AccessDeniedException("Ex")).when(schoolService).listSchools();

        ResponseEntity<List<School>> response = this.controller.listSchools();
        verify(schoolService, times(1)).listSchools();
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    public void test_listSchools_shoudCallService() throws Exception {
        ResponseEntity<List<School>> response = this.controller.listSchools();
        verify(schoolService, times(1)).listSchools();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
