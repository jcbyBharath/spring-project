package com.sb.inclass.project.sbinclassproject1.controller.e2e;

import com.sb.inclass.project.sbinclassproject1.api.response.dto.AddressDto;
import com.sb.inclass.project.sbinclassproject1.api.response.dto.UniversityDto;
import com.sb.inclass.project.sbinclassproject1.service.e2e.HttpCilentService;
import com.sb.inclass.project.sbinclassproject1.service.e2e.WebClientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/webclient")
public class WebClientController {

    private final WebClientService webClientService;

    @Autowired
    public WebClientController(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    /**
     * 1. resilience4j.retry.instances.employeeService.maxRetryAttempts=4
     * 2. resilience4j.retry.instances.employeeService.waitDuration=5000
     * 3. @Retry(name="", fallbackMethod="")
     *
     *
     * 1. resilience4j.bulkhead.instances.employeeService.maxWaitDuration=5000
     * 2. resilience4j.bulkhead.instances.employeeService.maxConcurrentCalls=5
     * 3. @Bulkhead(name="", fallbackMethod="")
     *
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getUniversities")
    @CircuitBreaker(name="employeeService", fallbackMethod = "getFallBackUniversities")
    public List<UniversityDto> getUniversities() throws Exception {
        return webClientService.getUniversities();
    }

    @PostMapping("/addUniversity")
    public String  addUniversity(@RequestBody UniversityDto universityDto) throws Exception {
        return webClientService.addUniversity(universityDto);
    }

    public  List<UniversityDto> getFallBackUniversities(Exception ex) {
        return Stream.of(
                new UniversityDto()
                        .setAddressDto(new AddressDto().setAddress1("add1").setAddress2("add2"))
                .setName("12344").setPhone("").setWebsiteAddress(""))
                .collect(Collectors.toList());

    }

}
