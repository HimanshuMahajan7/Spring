package com.springbatch.config.reader;

import com.springbatch.models.Product;
import com.springbatch.models.ProductRowMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JdbcCursorItemReaderBatchConfiguration {

    private static final String SQL_SELECT_PRODUCTS = "SELECT * FROM PRODUCT_DETAILS ORDER BY PRODUCT_ID;";

    @Autowired
    DataSource dataSource;

    @Bean
    public ItemReader<Product> JdbcCursorItemReader() {
        JdbcCursorItemReader<Product> jdbcCursorItemReader = new JdbcCursorItemReader<>();
        jdbcCursorItemReader.setDataSource(dataSource);
        jdbcCursorItemReader.setSql(SQL_SELECT_PRODUCTS);
        jdbcCursorItemReader.setRowMapper(new ProductRowMapper());
        return jdbcCursorItemReader;
    }

    @Bean
    public Step jdbcCursorItemReaderStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("JDBC Cursor Item Reader Step", jobRepository)
                .chunk(2, transactionManager)
                .reader(JdbcCursorItemReader())
                .writer(chunk -> {
                    System.out.println("JDBC Chunk Processing Started");
                    chunk.forEach(System.out::println);
                    System.out.println("JDBC Chunk Processing Ended");
                })
                .build();
    }

    @Bean("jdbcCursorItemReaderJob")
    public Job jdbcCursorItemReaderJob(JobRepository jobRepository, Step jdbcCursorItemReaderStep) {
        return new JobBuilder("JDBC Cursor Item Reader Job", jobRepository)
                .start(jdbcCursorItemReaderStep)
                .build();
    }
}
