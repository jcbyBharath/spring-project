package com.sb.inclass.project.sbinclassproject1.service.e2e;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.sb.inclass.project.sbinclassproject1.api.response.dto.UniversityDto;
import com.sb.inclass.project.sbinclassproject1.config.AppConfig;
import com.sb.inclass.project.sbinclassproject1.helper.WebClientHelper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class WebClientService {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private WebClientHelper webClientHelper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<UniversityDto>  getUniversities() throws Exception {


        List<ServiceInstance> instanceInfos = discoveryClient.getInstances("employee-education-service");
        instanceInfos.stream().forEach(System.out::println);

        Mono<String> response = webClientHelper.get(appConfig.getUniversityhost() + appConfig.getUniversitiesUrl());

        String universitesInResponse = response.block();

        log.info(universitesInResponse);

       return objectMapper.readValue(universitesInResponse, new TypeReference<List<UniversityDto>>() {});
    }

    public String addUniversity(UniversityDto universityDto) throws Exception {
       // String payload =  objectMapper.writeValueAsString(universityDto);

        Mono<ResponseEntity<Void>> responseEntityMono =  webClientHelper.post1("/api/v1/university/addUniversity", universityDto);
        return responseEntityMono.block().toString();
    }
}
