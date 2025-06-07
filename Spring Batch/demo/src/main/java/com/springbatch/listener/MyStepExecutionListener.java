package com.springbatch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class MyStepExecutionListener implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Step Execution Started");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("Step Execution Finished");
        return new ExitStatus("TEST_STATUS");
    }
}
