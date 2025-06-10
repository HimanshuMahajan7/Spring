package com.springbatch.config;

import com.springbatch.models.Product;
import com.springbatch.models.ProductFieldSetMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class FlatFileItemReaderBatchConfiguration {

    @Bean
    public ItemReader<Product> flatFileItemReader() {
        FlatFileItemReader<Product> itemReader = new FlatFileItemReader<>();
        itemReader.setLinesToSkip(1);
        itemReader.setResource(new ClassPathResource("/data/product-details.csv"));

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("product_id", "product_name", "product_category", "product_price");

        DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(new ProductFieldSetMapper());

        itemReader.setLineMapper(lineMapper);

        return itemReader;
    }

    @Bean
    public Step flatFileItemReaderStep1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("Flat File Reader Step1", jobRepository)
                .chunk(3, transactionManager)
                .reader(flatFileItemReader())
                .writer(chunk -> {
                    System.out.println("Chunk Processing Started");
                    chunk.forEach(System.out::println);
                    System.out.println("Chunk Processing Ended");
                })
                .build();
    }

    @Bean("flatFileItemReaderJob")
    public Job flatFileItemReaderJob(JobRepository jobRepository, Step flatFileItemReaderStep1) {
        return new JobBuilder("Flat File Reader Job 1", jobRepository)
                .start(flatFileItemReaderStep1)
                .build();
    }
}
