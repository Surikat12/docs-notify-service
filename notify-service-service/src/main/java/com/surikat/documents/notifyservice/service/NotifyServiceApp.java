package com.surikat.documents.notifyservice.service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@ComponentScan({"com.surikat"})
@OpenAPIDefinition(info = @Info(title = "${info.app.name}", description = "${info.app.description}", version = "${info.app.version}"))
@EnableTransactionManagement
public class NotifyServiceApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(NotifyServiceApp.class);
        app.run(args);
    }
}
