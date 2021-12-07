package com.weling.we_are_traveling_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 시간 자동 변경이 가능하도록 합니다.
@SpringBootApplication
public class WeAreTravelingJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeAreTravelingJavaApplication.class, args);
    }

}