package com.association.College_project;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.association")
@MapperScan("com.association")
@EnableCaching

public class AssociationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssociationApplication.class, args);
        log.info("------------------------------AssociationApplication 启动完毕-----------------------------------");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
