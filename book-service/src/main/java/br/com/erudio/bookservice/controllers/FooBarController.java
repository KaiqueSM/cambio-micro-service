package br.com.erudio.bookservice.controllers;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class FooBarController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    @Retry(name = "foo-bar")
    public String fooBar(){
        logger.info("Request of foo-bar is received");
        var response = new RestTemplate()
                .getForEntity("http://localhost:8080/foo-bar",String.class);
        return response.getBody();
    }
}
