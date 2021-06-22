package org.registration.task;

import net.bytebuddy.implementation.FixedValue;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("changeStatusInvalid")
public class ChangeStatusInvalid implements JavaDelegate {
    private Expression status;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("status", "INVALID");
        System.out.println("status: " + status.getValue(delegateExecution).toString() + "  " + delegateExecution.getVariable("status2"));
    }
}
