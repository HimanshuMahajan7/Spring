package com.springbatch.config.writer;

import com.springbatch.models.Product;
import com.springbatch.models.ProductRowMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class FlatFileItemWriterBatchConfiguration {

    private static final String SQL_SELECT_CLAUSE = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_PRICE";
    private static final String SQL_FROM_CLAUSE = "FROM PRODUCT_DETAILS";
    private static final String SQL_SORT_KEY = "PRODUCT_ID";

    @Autowired
    DataSource dataSource;

    @Bean
    public ItemReader<Product> jdbcPagingItemReader() throws Exception {
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
    public ItemWriter<Product> flatFileItemWriter() throws Exception {
        FlatFileItemWriter<Product> flatFileItemWriter = new FlatFileItemWriter<>();
        flatFileItemWriter.setResource(new FileSystemResource("src/main/resources/data/output/product-details-output.csv"));

        DelimitedLineAggregator<Product> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");

        BeanWrapperFieldExtractor<Product> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[]{"productId", "productName", "productCategory", "productPrice"});
        lineAggregator.setFieldExtractor(fieldExtractor);

        flatFileItemWriter.setLineAggregator(lineAggregator);

        return flatFileItemWriter;
    }

    @Bean("flatFileItemWriterStep")
    public Step flatFileItemWriterStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        return new StepBuilder("Flat File Item Writer Step", jobRepository)
                .<Product, Product>chunk(2, transactionManager)
                .reader(jdbcPagingItemReader())
                .writer(flatFileItemWriter())
                .build();
    }

    @Bean("flatFileItemWriterJob")
    public Job flatFileItemWriterJob(JobRepository jobRepository, Step flatFileItemWriterStep) {
        return new JobBuilder("Flat File Item Writer Job", jobRepository)
                .start(flatFileItemWriterStep)
                .build();
    }
}
