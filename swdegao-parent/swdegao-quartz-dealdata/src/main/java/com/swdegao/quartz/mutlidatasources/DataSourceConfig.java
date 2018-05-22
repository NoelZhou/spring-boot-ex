//package com.swdegao.quartz.mutlidatasources;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;  
//import org.springframework.context.annotation.Configuration;  
//import org.springframework.context.annotation.Primary;  
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.transaction.PlatformTransactionManager;  
//  
//import javax.sql.DataSource;  
//import java.util.HashMap;  
//import java.util.Map;  
//  
///** 
// * 多数据源配置类 
// * Created by pure on 2018-05-06. 
// */  
//@Configuration  
//public class DataSourceConfig {  
//    //数据源1  
//	@Primary
//    @Bean(name = "db1")  
//	@Qualifier("db1")
//    @ConfigurationProperties(prefix = "spring.datasource.db1") // application.properteis中对应属性的前缀  
//    public DataSource dataSource1() {  
//        return DataSourceBuilder.create().build();  
//    }  
//  
//    //数据源2  
//    @Bean(name = "db2")  
//    @Qualifier("db2")
//    @ConfigurationProperties(prefix = "spring.datasource.db2") // application.properteis中对应属性的前缀  
//    public DataSource dataSource2() {  
//        return DataSourceBuilder.create().build();  
//    }  
//  
//    /** 
//     * 动态数据源: 通过AOP在不同数据源之间动态切换 
//     * @return 
//     */  
//    @Primary  
//    @Bean(name = "dynamicDataSource")  
//    public DataSource dynamicDataSource() {  
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();  
//        // 默认数据源  
//        dynamicDataSource.setDefaultTargetDataSource(dataSource1());  
//        // 配置多数据源  
//        Map<Object, Object> dsMap = new HashMap<>();  
//        dsMap.put("db2", dataSource2());  
//  
//        dynamicDataSource.setTargetDataSources(dsMap);  
//        return dynamicDataSource;  
//    }  
//    
//    public SqlSessionFactoryBean SqlSessionFactoryBean()
//    {
//    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//    	sqlSessionFactoryBean.setDataSource(dynamicDataSource());
//    	return sqlSessionFactoryBean;
//    }
//    /** 
//     * 配置@Transactional注解事物 
//     * @return 
//     */  
//    @Bean  
//    public PlatformTransactionManager transactionManager() {  
//        return new DataSourceTransactionManager(dynamicDataSource());  
//    }  
//}  