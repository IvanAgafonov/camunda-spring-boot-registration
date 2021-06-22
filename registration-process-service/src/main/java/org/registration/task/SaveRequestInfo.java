package org.registration.task;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.registration.entity.RecordInfo;
import org.registration.model.RequestInfo;
import org.registration.repository.CustomizedRecordInfoCrudRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Qualifier("saveRequestInfo")
public class SaveRequestInfo implements JavaDelegate {
    private final CustomizedRecordInfoCrudRepository recordInfoRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        recordInfoRepository.save(new RecordInfo(0,
                (Integer) execution.getVariable("clientId"),
                RequestInfo.StatusEnum.valueOf((String) execution.getVariable("status"))));
    }
}