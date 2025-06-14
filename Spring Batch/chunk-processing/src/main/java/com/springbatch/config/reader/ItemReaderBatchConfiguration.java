package com.springbatch.config.reader;

import com.springbatch.reader.ProductNameItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ItemReaderBatchConfiguration {

    @Bean
    public ItemReader<String> itemReader() {
        List<String> productList = new ArrayList<>();
        productList.add("Apple");
        productList.add("Banana");
        productList.add("Orange");
        productList.add("Pear");
        productList.add("Grape");
        productList.add("Watermelon");
        productList.add("Mango");
        return new ProductNameItemReader(productList);
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("Chunk Based Step1", jobRepository)
                .chunk(3, transactionManager)
                .reader(itemReader())
                .writer(chunk -> {
                    System.out.println("Chunk Processing Started");
                    chunk.forEach(System.out::println);
                    System.out.println("Chunk Processing Ended");
                })
                .build();
    }

    @Bean("itemReaderJob")
    public Job itemReaderJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("Item Reader Job 1", jobRepository)
                .start(step1)
                .build();
    }
}
