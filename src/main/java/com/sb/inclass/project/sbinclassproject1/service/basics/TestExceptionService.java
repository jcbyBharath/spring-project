package com.sb.inclass.project.sbinclassproject1.service.basics;

import com.sb.inclass.project.sbinclassproject1.exception.CustomException;
import org.springframework.stereotype.Service;

@Service
public class TestExceptionService {

    public String test_exception(String name) throws CustomException {

        if(name.equals("exception")) {
            throw new CustomException("Custom Exception is thrown");
        }

        return name;
    }
}
