package fr.isika.al17.urbanisationsi.microservices_client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfig
{
    @Bean
    public BasicAuthRequestInterceptor mBasicAuthRequestInterceptor(){
        return  new BasicAuthRequestInterceptor("user", "pwd");
    }
}
