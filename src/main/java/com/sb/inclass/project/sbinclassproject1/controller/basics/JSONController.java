package com.sb.inclass.project.sbinclassproject1.controller.basics;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.sb.inclass.project.sbinclassproject1.common.Employeedto;
import com.sb.inclass.project.sbinclassproject1.service.basics.JSONService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class JSONController {

    @Autowired
    private JSONService service;


    @GetMapping("/getJSONData")
    public List<Employeedto> getJsonDataAsObject() throws JsonProcessingException {
      return service.convertJSONStringToJavaObject();

    }

    @GetMapping("/getJSONDataAsString")
    public String getJsonDataAsString() throws JsonProcessingException {
        return service.getJsonDataAsString();

    }
}
