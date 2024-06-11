package com.surikat.documents.notifyservice.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@ComponentScan({"com.surikat"})
@EnableTransactionManagement
public class NotifyServiceApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(NotifyServiceApp.class);
        app.run(args);
    }
}
