package com.sb.inclass.project.sbinclassproject1.controller.e2e;

import com.sb.inclass.project.sbinclassproject1.api.response.dto.UniversityDto;
import com.sb.inclass.project.sbinclassproject1.service.e2e.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restTemplateController")
public class RestTemplateController {

    private final RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/getUniversities")
    public List<UniversityDto> getUniversities() throws Exception {
        return restTemplateService.getUniversities();
    }
}
