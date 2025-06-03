package com.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfiguration {

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("Step1", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Step 1");
                    return RepeatStatus.FINISHED;
                }, transactionManager).build();
    }

    @Bean
    public Job job1(JobRepository jobRepository, Step step1) {
        return new JobBuilder("Job 1", jobRepository)
                .start(step1)
                .build();
    }
}
