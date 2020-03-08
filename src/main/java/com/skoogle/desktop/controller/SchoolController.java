package com.skoogle.desktop.controller;

import com.skoogle.desktop.dto.SchoolRequestDto;
import com.skoogle.desktop.exception.AccessDeniedException;
import com.skoogle.desktop.security.Secured;
import com.skoogle.desktop.service.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@RestController
@RequestMapping("/skoogle")
@Api(value="skoogle", description = "Desktop Controller rest")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @ApiOperation(value ="Insert school", response =  ResponseEntity.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "School successfully inserted"),
        @ApiResponse(code = 400, message = "Error on the request parameters"),
        @ApiResponse(code = 401, message = "Missing authorization key/value")
    })
    @Secured
    @RequestMapping(value = "/insertSchool", method = RequestMethod.POST)
    public ResponseEntity<Void> insertSchool(
        @RequestBody SchoolRequestDto schoolRequestDto,
        HttpServletResponse response) {

        try {
            if (schoolRequestDto == null) {
                throw new Exception();
            }

            schoolService.insertSchool(schoolRequestDto);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception ex ) {
            if (ex instanceof AccessDeniedException) {
                return AccessDeniedException.AccessDeniedResponse(ex);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
    }
}
