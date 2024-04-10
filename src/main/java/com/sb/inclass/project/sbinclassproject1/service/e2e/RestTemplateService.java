package com.sb.inclass.project.sbinclassproject1.service.e2e;

import com.netflix.appinfo.InstanceInfo;
import com.sb.inclass.project.sbinclassproject1.api.response.dto.UniversityDto;
import com.sb.inclass.project.sbinclassproject1.config.AppConfig;
import com.sb.inclass.project.sbinclassproject1.helper.RestTemplateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class RestTemplateService {

    @Autowired
    private RestTemplateHelper restTemplateHelper;

    @Autowired
    private AppConfig appConfig;

   @Autowired
   DiscoveryClient client;


    public List<UniversityDto> getUniversities() {

       List<ServiceInstance> serviceInstances = client.getInstances("employee-education-service");
       serviceInstances.stream().forEach(System.out::println);

        return  restTemplateHelper.get(appConfig.getUniversityhost()+ appConfig.getUniversitiesUrl());
    }
}
