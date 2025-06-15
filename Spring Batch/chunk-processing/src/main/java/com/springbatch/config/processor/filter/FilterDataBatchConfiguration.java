package com.springbatch.config.processor.filter;

import com.springbatch.models.Product;
import com.springbatch.models.ProductRowMapper;
import com.springbatch.processor.filter.FilterItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
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
public class FilterDataBatchConfiguration {

    private static final String SQL_SELECT_CLAUSE = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_PRICE";
    private static final String SQL_FROM_CLAUSE = "FROM PRODUCT_DETAILS";
    private static final String SQL_SORT_KEY = "PRODUCT_ID";
    private static final String SQL_NAMED_PARAM_INSERT_QUERY = "INSERT INTO PRODUCT_DETAILS_OUTPUT VALUES (:productId, :productName, :productCategory, :productPrice)";

    @Autowired
    DataSource dataSource;

    @Bean
    public ItemReader<Product> jdbcPagingItemReader5() throws Exception {
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
    public ItemWriter<Product> jdbcBatchNamedParamItemWriter2() {
        JdbcBatchItemWriter<Product> itemWriter = new JdbcBatchItemWriter<>();
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql(SQL_NAMED_PARAM_INSERT_QUERY);
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return itemWriter;
    }

    @Bean
    public ItemProcessor<Product, Product> filterItemItemProcessor() {
      return new FilterItemProcessor();
    }

    @Bean("filterItemProcessorStep")
    public Step filterItemProcessorStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        return new StepBuilder("Filter Item Processor Step", jobRepository)
                .<Product, Product>chunk(2, transactionManager)
                .reader(jdbcPagingItemReader5())
                .processor(filterItemItemProcessor())
                .writer(jdbcBatchNamedParamItemWriter2())
                .build();
    }

    @Bean("filterItemProcessorJob")
    public Job filterItemProcessorJob(JobRepository jobRepository, Step filterItemProcessorStep) {
        return new JobBuilder("Filter Item Processor Job", jobRepository)
                .start(filterItemProcessorStep)
                .build();
    }
}
