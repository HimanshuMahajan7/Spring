package com.springbatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobLaunchController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("job1")
    Job job;

    @Autowired
    @Qualifier("conditionalJob")
    Job conditionalJob;

    @Autowired
    @Qualifier("exitStatusJob")
    Job exitStatusJob;

    @GetMapping("/launchJob/{id}")
    public void launchJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/launchConditionalJob/{id}")
    public void launchConditionalJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(conditionalJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/launchExitStatusJobJob/{id}")
    public void launchExitStatusJobJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(exitStatusJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }
}
