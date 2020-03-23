package com.es.user.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.es.user.jwt.entity"})
@EnableJpaRepositories(basePackages = {"com.es.user.jwt.repository"})
@EnableJpaAuditing
@EnableDiscoveryClient
public class ESchoolServiceUserOauth2JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ESchoolServiceUserOauth2JwtApplication.class, args);
    }

}
