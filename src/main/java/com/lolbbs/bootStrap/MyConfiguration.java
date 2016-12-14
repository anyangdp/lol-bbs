package com.lolbbs.bootStrap;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

@Configuration
public class MyConfiguration {
	/*@Bean
    public HttpMessageConverters customConverters() {
        HttpMessageConverter<?> additional = 
        HttpMessageConverter<?> another = ...
        return new HttpMessageConverters(additional, another);
    }*/

}
