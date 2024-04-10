package com.sb.inclass.project.sbinclassproject1.controller.basics;


import com.sb.inclass.project.sbinclassproject1.exception.CustomException;
import com.sb.inclass.project.sbinclassproject1.service.basics.TestExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *  1. Create a rest endpoint:
 *  GET
 *    /api/v1/exception?name=exception
 *          throw CustomException
 *    /api/v1/exception?name=java
 *
 *   -- java
 *
 *  controller -> service  {}
 *
 *
 *
 *
 *
 */

@RestController
@RequestMapping("/api/v1")
public class TestExceptionsController {

    @Autowired
    private TestExceptionService exceptionService;

    @GetMapping("/exception")
    public String test_custom_exception(@RequestParam String name) throws CustomException {
        String returnType = exceptionService.test_exception(name);
        return returnType;
    }

}
