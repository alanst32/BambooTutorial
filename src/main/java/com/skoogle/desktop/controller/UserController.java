package com.skoogle.desktop.controller;

import com.skoogle.desktop.dto.SchoolUserDto;
import com.skoogle.desktop.exception.AccessDeniedException;
import com.skoogle.desktop.security.Secured;
import com.skoogle.desktop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value ="Register User to the school", response =  ResponseEntity.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "School successfully inserted"),
        @ApiResponse(code = 400, message = "Error on the request parameters"),
        @ApiResponse(code = 401, message = "Missing authorization key/value")
    })
    @Secured
    @RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
    public ResponseEntity<Void> registerSchoolUser(@RequestBody SchoolUserDto schoolUserDto) {

        try {
            if (schoolUserDto == null) {
                throw new Exception();
            }

            userService.insertSchoolUser(schoolUserDto);

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
