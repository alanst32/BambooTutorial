package main.java.com.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import main.java.com.project.dto.StudentSearchDto;
import main.java.com.project.model.Student;
import main.java.com.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@Api(value="api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @ApiOperation(value = "List students", response = Student.class)
    @ApiResponses( value = {
        @ApiResponse(code = 200, message = "List Students successfully"),
        @ApiResponse(code = 400, message = "Bad Request")
    })
    @RequestMapping(value ="/list", method = RequestMethod.POST)
    public ResponseEntity<List<Student>> getStudents(@RequestBody StudentSearchDto request) {
        try {
            if(request == null) {
                throw new Exception();
            }

            List<Student> data = studentService.findStudents(request);
            return ResponseEntity.ok(data);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
