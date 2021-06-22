package org.registration;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import java.util.Map;

@SpringBootApplication
@EnableProcessApplication
public class RegistrationProcessApplication {

    public static void main(String... args) {
        SpringApplication.run(RegistrationProcessApplication.class, args);
    }


}
