package org.registration.config;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.registration.config.entity.User;
import org.registration.config.service.LogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class HandlerConfiguration {
    private final LogService logService;

    @Bean
    @ExternalTaskSubscription(topicName = "SaveRegistration")
    public ExternalTaskHandler saveRegistration() {
        return (externalTask, externalTaskService) -> {
            logService.saveUser(new User(externalTask.getVariable("nickname"),
                    externalTask.getVariable("email"),
                    ((LocalDateTime) externalTask.getVariable("birthday")).toLocalDate()));

            System.out.println(logService.getUser(externalTask.getVariable("nickname")));

            externalTaskService.complete(externalTask);
        };
    }


}