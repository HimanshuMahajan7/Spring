package com.springbatch.config;

import com.springbatch.models.Product;
import com.springbatch.models.ProductRowMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JdbcPagingItemReaderBatchConfiguration {

    private static final String SQL_SELECT_CLAUSE = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_PRICE";
    private static final String SQL_FROM_CLAUSE = "FROM PRODUCT_DETAILS";
    private static final String SQL_SORT_KEY = "PRODUCT_ID";

    @Autowired
    DataSource dataSource;

    @Bean
    public ItemReader<Product> jdbcPagingItemReader1() throws Exception {
        JdbcPagingItemReader<Product> jdbcPagingItemReader = new JdbcPagingItemReader<>();
        jdbcPagingItemReader.setDataSource(dataSource);

        SqlPagingQueryProviderFactoryBean queryFactory = new SqlPagingQueryProviderFactoryBean();
        queryFactory.setDataSource(dataSource);
        queryFactory.setSelectClause(SQL_SELECT_CLAUSE);
        queryFactory.setFromClause(SQL_FROM_CLAUSE);
        queryFactory.setSortKey(SQL_SORT_KEY);

        jdbcPagingItemReader.setQueryProvider(queryFactory.getObject());
        jdbcPagingItemReader.setRowMapper(new ProductRowMapper());
        jdbcPagingItemReader.setPageSize(2);
        return jdbcPagingItemReader;
    }

    @Bean
    public Step jdbcPagingItemReaderStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        return new StepBuilder("JDBC Paging Item Reader Step", jobRepository)
                .chunk(2, transactionManager)
                .reader(jdbcPagingItemReader1())
                .writer(chunk -> {
                    System.out.println("JDBC Chunk Processing Started");
                    chunk.forEach(System.out::println);
                    System.out.println("JDBC Chunk Processing Ended");
                })
                .build();
    }

    @Bean("jdbcPagingItemReaderJob")
    public Job jdbcPagingItemReaderJob(JobRepository jobRepository, Step jdbcPagingItemReaderStep) {
        return new JobBuilder("JDBC Paging Item Reader Job", jobRepository)
                .start(jdbcPagingItemReaderStep)
                .build();
    }
}
