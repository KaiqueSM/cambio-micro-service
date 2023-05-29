package br.com.erudio.greetingservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@ConfigurationProperties("greeting-service")
@RefreshScope
@Component
@Data
public class GreetingConfiguration {

    private String greeting;
    private String defaultValue;
}
