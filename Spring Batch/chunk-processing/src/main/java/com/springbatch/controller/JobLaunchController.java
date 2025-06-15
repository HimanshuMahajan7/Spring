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
    @Qualifier("itemReaderJob")
    Job itemReaderJob;

    @Autowired
    @Qualifier("flatFileItemReaderJob")
    Job flatFileItemReaderJob;

    @Autowired
    @Qualifier("jdbcCursorItemReaderJob")
    Job jdbcCursorItemReaderJob;

    @Autowired
    @Qualifier("jdbcPagingItemReaderJob")
    Job jdbcPagingItemReaderJob;

    @Autowired
    @Qualifier("flatFileItemWriterJob")
    Job flatFileItemWriterJob;

    @Autowired
    @Qualifier("jdbcBatchItemWriterJob")
    Job jdbcBatchItemWriterJob;

    @Autowired
    @Qualifier("simpleItemProcessorJob")
    Job simpleItemProcessorJob;

    @Autowired
    @Qualifier("filterItemProcessorJob")
    Job filterItemProcessorJob;

    @GetMapping("/launchItemReaderJobJob/{id}")
    public void launchItemReaderJobJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(itemReaderJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/launchFlatFileItemReaderJob/{id}")
    public void launchFlatFileItemReaderJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(flatFileItemReaderJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/launchJdbcCursorItemReaderJob/{id}")
    public void launchJdbcCursorItemReaderJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(jdbcCursorItemReaderJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/launchJdbcPagingItemReaderJob/{id}")
    public void launchJdbcPagingItemReaderJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(jdbcPagingItemReaderJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/launchFlatFileItemWriterJob/{id}")
    public void launchFlatFileItemWriterJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(flatFileItemWriterJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/launchJdbcBatchItemWriterJob/{id}")
    public void launchJdbcBatchItemWriterJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(jdbcBatchItemWriterJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/launchSimpleItemProcessorJob/{id}")
    public void launchSimpleItemProcessorJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(simpleItemProcessorJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/launchFilterItemProcessorJob/{id}")
    public void launchFilterItemProcessorJob(@PathVariable String id) {
        JobParameters jobParameters = new JobParametersBuilder().addString("param", id).toJobParameters();
        try {
            jobLauncher.run(filterItemProcessorJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }
}
