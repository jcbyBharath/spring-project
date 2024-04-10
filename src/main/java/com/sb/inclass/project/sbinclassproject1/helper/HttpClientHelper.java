package com.sb.inclass.project.sbinclassproject1.helper;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class HttpClientHelper {

    @Autowired
    private CloseableHttpClient httpClient;

    public String get(String url) throws URISyntaxException, IOException {

        URI uri = new URIBuilder(url).build();
        HttpGet httpGet = new HttpGet(uri);

        HttpResponse response = httpClient.execute(httpGet);
        // here we should log both HTTP Statuscode and the error message ..
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity);

        return responseString;
    }

    public String post(String url, String requestBody) throws URISyntaxException, IOException {
        URI uri = new URIBuilder(url).build();
        HttpPost httpPost = new HttpPost(uri);

        httpPost.setEntity(new StringEntity(requestBody));
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("Authorization", "Basic c2ItcHJvamVjdDpQQVNTV09SRA==");

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity);

        return responseString;
    }

    public String put(String url, String requestBody) throws URISyntaxException, IOException {
        URI uri = new URIBuilder(url).build();
        HttpPut httpPut = new HttpPut(uri);
        httpPut.setEntity(new StringEntity(requestBody));
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(httpPut);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity);

        return responseString;
    }

    public String delete(String url) throws URISyntaxException, IOException {
        URI uri = new URIBuilder(url).build();
        HttpDelete httpDelete = new HttpDelete(uri);

        HttpResponse response = httpClient.execute(httpDelete);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity);

        return responseString;
    }



}
