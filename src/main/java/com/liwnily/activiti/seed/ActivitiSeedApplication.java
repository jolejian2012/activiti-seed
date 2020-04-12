package com.liwnily.activiti.seed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
        exclude = {
                org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
                org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
        }
)
@EnableSwagger2
public class ActivitiSeedApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivitiSeedApplication.class, args);
    }
}
