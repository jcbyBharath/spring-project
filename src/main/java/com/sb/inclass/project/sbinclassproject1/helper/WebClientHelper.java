package com.sb.inclass.project.sbinclassproject1.helper;

import com.sb.inclass.project.sbinclassproject1.api.response.dto.UniversityDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class WebClientHelper {

    private final WebClient.Builder webClient;

    public WebClientHelper(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    public Mono<String> get(String url) {
        return webClient.build().
                get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<Void> post(String url, UniversityDto body) throws Exception {
        return webClient.build().post()
                .uri(new URI(url))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(body), UniversityDto.class)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<ResponseEntity<Void>> post1(String url, UniversityDto body) throws Exception {
        return webClient.build()
                .post()
                .uri(u -> u.path(url).build())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .toBodilessEntity();
    }

    public Mono<String> put(String url, Object body) {
        return webClient.build().put()
                .uri(url)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> delete(String url) {
        return webClient.build().delete()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }
}
