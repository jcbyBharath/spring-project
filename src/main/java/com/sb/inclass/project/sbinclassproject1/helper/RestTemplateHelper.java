package com.sb.inclass.project.sbinclassproject1.helper;

import com.sb.inclass.project.sbinclassproject1.api.response.dto.UniversityDto;
import com.sb.inclass.project.sbinclassproject1.api.response.dto.UniversityDtoList;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestTemplateHelper {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * NOTES:
     *
     * getForObject() – retrieves a representation by doing a GET on the URL. The response (if any) is unmarshalled to the given class type and returned.
     * getForEntity() – retrieve a representation as ResponseEntity by doing a GET on the URL.
     * exchange() – execute the specified HttpEntity and return the response as ResponseEntity.
     * execute() – execute the HttpMethod to the given URI template, prepare the request with the RequestCallback, and read the response with a ResponseExtractor.
     * @return
     */
    public List<UniversityDto> get(String url) {
     //   ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
      //  RestTemplate restTemplate = new RestTemplate(requestFactory);

        UniversityDto[] universityDtoList = restTemplate.getForObject(url, UniversityDto[].class);
        System.out.println(universityDtoList);
        return Arrays.asList(universityDtoList);
    }


}
