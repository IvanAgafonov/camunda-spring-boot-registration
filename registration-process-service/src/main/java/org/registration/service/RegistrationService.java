package org.registration.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.model.bpmn.instance.TerminateEventDefinition;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.registration.model.Request;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final RuntimeService runtimeService;
    private final RepositoryService repositoryService;

    public static final String REGISTRATION_BPMN_KEY = "registration";
    public static final String VALIDATION_DMN_FILE = "validation.dmn";

    public void startRegistration(Request request, int clientId) {
        //        ObjectMapper oMapper = new ObjectMapper();
        //        oMapper.findAndRegisterModules();

        Map<String, Object> variables = new HashMap<>(); // oMapper.convertValue(request, Map.class);

        variables.put("nickname", request.getNickname());
        variables.put("email", request.getEmail());
        variables.put("birthday", request.getBirthday().atStartOfDay());
        variables.put("clientId", clientId);

        runtimeService.startProcessInstanceByKey(REGISTRATION_BPMN_KEY, variables);
    }


    public void cancelRequest(int clientId) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey(REGISTRATION_BPMN_KEY)
                .variableValueEquals("clientId", clientId)
                .singleResult();
        if (processInstance != null) {
            runtimeService.createMessageCorrelation("cancelRegistration")
                    .processInstanceId(processInstance.getProcessInstanceId()).correlate();
        }
    }

}
