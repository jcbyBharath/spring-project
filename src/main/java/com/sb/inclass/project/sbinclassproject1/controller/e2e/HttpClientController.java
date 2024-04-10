package com.sb.inclass.project.sbinclassproject1.controller.e2e;

import com.sb.inclass.project.sbinclassproject1.api.response.dto.AddressDto;
import com.sb.inclass.project.sbinclassproject1.api.response.dto.UniversityDto;
import com.sb.inclass.project.sbinclassproject1.service.e2e.HttpCilentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/httpclient")
public class HttpClientController {

    private final HttpCilentService httpCilentService;

    @Autowired
    public HttpClientController(HttpCilentService httpCilentService) {
        this.httpCilentService = httpCilentService;
    }

    @GetMapping("/getUniversities")
    public List<UniversityDto> getUniversities() throws Exception {
        return httpCilentService.getUniversities();
    }

    @GetMapping("/getUniversityById")
    public UniversityDto getUniversityById(@RequestParam Integer id) {
        return httpCilentService.getUniversityById(id);
    }

    @GetMapping("/getUniversityAddressByName")
    public AddressDto getUniversityAddressByName(@RequestParam String name) {
        return httpCilentService.getUniversityAddressByName(name);
    }

    @PostMapping("/addUniversity")
    public String  addUniversity(@RequestBody UniversityDto universityDto) throws Exception {
        return httpCilentService.addUniversity(universityDto);
    }
}
