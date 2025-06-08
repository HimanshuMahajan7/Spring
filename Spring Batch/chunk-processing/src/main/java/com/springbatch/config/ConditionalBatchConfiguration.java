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
public class ConditionalBatchConfiguration {

    @Bean
    public Step conditionalStep1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("Conditional Step1", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Conditional Step 1");
                    return RepeatStatus.FINISHED;
                }, transactionManager).build();
    }

    @Bean
    public Step conditionalStep2(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("Conditional Step2", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    boolean isFailure = true;
                    if (isFailure) {
                        throw new Exception("Test Exception");
                    }
                    System.out.println("Conditional Step 2");
                    return RepeatStatus.FINISHED;
                }, transactionManager).build();
    }

    @Bean
    public Step conditionalStep3(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("Conditional Step3", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Conditional Step 3");
                    return RepeatStatus.FINISHED;
                }, transactionManager).build();
    }

    @Bean
    public Step conditionalStep4(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("Conditional Step4", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Conditional Step 4");
                    return RepeatStatus.FINISHED;
                }, transactionManager).build();
    }

    @Bean(name = "conditionalJob")
    public Job conditionalJob(JobRepository jobRepository, Step conditionalStep1, Step conditionalStep2, Step conditionalStep3, Step conditionalStep4) {
        return new JobBuilder("Conditional Job 1", jobRepository)
                .start(conditionalStep1)
                    .on("COMPLETED").to(conditionalStep2)
                .from(conditionalStep2)
                    .on("COMPLETED").to(conditionalStep3)
                .from(conditionalStep2)
                    .on("FAILED").to(conditionalStep4)
                .end()
                .build();
    }
}
