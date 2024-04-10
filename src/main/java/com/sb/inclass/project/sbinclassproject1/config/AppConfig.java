package com.sb.inclass.project.sbinclassproject1.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class AppConfig {

    @Value("${app.university.host}")
    private String universityhost;

    @Value("${app.universities.url:}")
    private String universitiesUrl;

    @Value("${app.add.university.url}")
    private String addUniversityUrl;

    @Value("${app.get.university.id.url}")
    private String getUniversityByIdUrl;

    @Value("${app.get.university.address.name.url}")
    private String getUniversityAddressByNameUrl;
}
