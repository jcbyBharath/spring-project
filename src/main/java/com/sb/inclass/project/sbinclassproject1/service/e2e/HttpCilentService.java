package com.sb.inclass.project.sbinclassproject1.service.e2e;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.inclass.project.sbinclassproject1.api.response.dto.AddressDto;
import com.sb.inclass.project.sbinclassproject1.api.response.dto.UniversityDto;
import com.sb.inclass.project.sbinclassproject1.config.AppConfig;
import com.sb.inclass.project.sbinclassproject1.helper.HttpClientHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HttpCilentService {
    private static final Logger logger = LoggerFactory.getLogger(HttpCilentService.class);


    @Autowired
    private AppConfig appConfig;

    @Autowired
    private HttpClientHelper httpClientHelper;

    @Autowired
    private ObjectMapper objectMapper;

    public List<UniversityDto> getUniversities() throws Exception {
        String url = appConfig.getUniversityhost() + appConfig.getUniversitiesUrl();
        logger.info("invoking url {}", url);

       String response =  httpClientHelper.get(url);
       return  objectMapper.readValue(response, new TypeReference<List<UniversityDto>>() {});
    }

    public String addUniversity(UniversityDto universityDto) throws Exception{
       String payload =  objectMapper.writeValueAsString(universityDto);


        httpClientHelper.post(appConfig.getUniversityhost() + appConfig.getAddUniversityUrl(), payload);
        return "Success";
    }

    /**
     *
     * @param id
     * @return
     *
     * Notes:
     * StringBuilder
     * StringBuffer
     *
     */
    public UniversityDto getUniversityById(Integer id) {

        //String url = appConfig.getUniversityhost() + appConfig.getGetUniversityByIdUrl() + "?id=" + id;

        StringBuilder urlsb = new StringBuilder(appConfig.getUniversityhost())
                .append(appConfig.getGetUniversityByIdUrl())
                .append("?id=")
                .append(id);

        logger.info("invoking url {}", urlsb.toString());
        try {
            String response = httpClientHelper.get(urlsb.toString());
            return objectMapper.readValue(response, new TypeReference<UniversityDto>() {});
        } catch (Exception ex) {
            logger.error("exception thrown while invoking  {}", ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     */

    public AddressDto getUniversityAddressByName(String name) {
        StringBuilder url = new StringBuilder(appConfig.getUniversityhost())
                .append(appConfig.getGetUniversityAddressByNameUrl())
                .append("?name=")
                .append(name);
        logger.info("Invoking url {}" , url.toString());

        try {
         String response =  httpClientHelper.get(url.toString());
         return objectMapper.readValue(response, new TypeReference<AddressDto>() {});

        } catch (Exception ex) {
            logger.error("Exception occurred while invoking {}", ex.getMessage());

        }
        return null;
    }
}
