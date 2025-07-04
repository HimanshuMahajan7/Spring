package com.springbatch.config.writer;

import com.springbatch.models.Product;
import com.springbatch.models.ProductItemPreparedStatementSetter;
import com.springbatch.models.ProductRowMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JdbcBatchItemWriterBatchConfiguration {

    private static final String SQL_SELECT_CLAUSE = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_PRICE";
    private static final String SQL_FROM_CLAUSE = "FROM PRODUCT_DETAILS";
    private static final String SQL_SORT_KEY = "PRODUCT_ID";
    private static final String SQL_INSERT_QUERY = "INSERT INTO PRODUCT_DETAILS_OUTPUT VALUES (?, ?, ?, ?)";
    private static final String SQL_NAMED_PARAM_INSERT_QUERY = "INSERT INTO PRODUCT_DETAILS_OUTPUT VALUES (:productId, :productName, :productCategory, :productPrice)";

    @Autowired
    DataSource dataSource;

    @Bean
    public ItemReader<Product> jdbcPagingItemReader3() throws Exception {
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
    public ItemWriter<Product> jdbcBatchItemWriter() {
        JdbcBatchItemWriter<Product> itemWriter = new JdbcBatchItemWriter<>();
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql(SQL_INSERT_QUERY);
        itemWriter.setItemPreparedStatementSetter(new ProductItemPreparedStatementSetter());
        return itemWriter;
    }

    @Bean
    public ItemWriter<Product> jdbcBatchNamedParamItemWriter() {
        JdbcBatchItemWriter<Product> itemWriter = new JdbcBatchItemWriter<>();
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql(SQL_NAMED_PARAM_INSERT_QUERY);
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return itemWriter;
    }

    @Bean("jdbcBatchItemWriterStep")
    public Step jdbcBatchItemWriterStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        return new StepBuilder("JDBC Batch Item Writer Step", jobRepository)
                .<Product, Product>chunk(2, transactionManager)
                .reader(jdbcPagingItemReader3())
//                .writer(jdbcBatchItemWriter())
                .writer(jdbcBatchNamedParamItemWriter())
                .build();
    }

    @Bean("jdbcBatchItemWriterJob")
    public Job jdbcBatchItemWriterJob(JobRepository jobRepository, Step jdbcBatchItemWriterStep) {
        return new JobBuilder("JDBC Batch Item Writer Job", jobRepository)
                .start(jdbcBatchItemWriterStep)
                .build();
    }
}
