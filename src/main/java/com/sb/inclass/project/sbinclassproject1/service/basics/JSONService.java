package com.sb.inclass.project.sbinclassproject1.service.basics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.inclass.project.sbinclassproject1.common.Employeedto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class JSONService {

    private ObjectMapper objectMapper;

    public JSONService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Employeedto> convertJSONStringToJavaObject() throws JsonProcessingException {

        String jsonData = "[\n" +
                "  {\n" +
                "    \"firstName\": \"fName1\",\n" +
                "    \"lastName\": \"lName1\",\n" +
                "    \"dob\": \"2023-05-31\",\n" +
                "    \"employeeId\": 123456,\n" +
                "    \"ein\": 456789\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstName\": \"fName2\",\n" +
                "    \"lastName\": \"lName2\",\n" +
                "    \"dob\": \"2023-05-31\",\n" +
                "    \"employeeId\": 123456,\n" +
                "    \"ein\": 456789\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstName\": \"fName3\",\n" +
                "    \"lastName\": \"lName3\",\n" +
                "    \"dob\": \"2023-05-31\",\n" +
                "    \"employeeId\": 123456,\n" +
                "    \"ein\": 456789\n" +
                "  }\n" +
                "]";

      List<Employeedto> employees =   objectMapper.readValue(jsonData, new TypeReference<List<Employeedto>>(){});

      return employees;

    }

    public String getJsonDataAsString() throws JsonProcessingException {
        List<Employeedto> employees = new ArrayList<>();

        employees.add(new Employeedto("fName", "lName", LocalDate.now(), 121342134, 232342 ));

       return objectMapper.writeValueAsString(employees);
    }
}
