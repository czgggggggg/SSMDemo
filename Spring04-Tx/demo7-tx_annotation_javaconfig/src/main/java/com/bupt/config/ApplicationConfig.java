package com.bupt.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author czgggggggg
 * @Date 2021/12/6
 * @Description
 */
@Configuration
@ComponentScan(basePackages = "com.bupt")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class ApplicationConfig {
    //@Bean注解中可以指定组件的id
    //@Bean注解中如果没有指定id，以方法名作为默认的id
    //返回值可以写class也可以写其接口
    //@Bean("datasource") //id = datasource
    @Bean //id = druidDatasource方法
    public DataSource druidDatasource(){
        //方法体里面写一个实例化的过程
        //new后面跟的class与<bean>标签中的class属性一致
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/20_db?characterEncoding=utf-8&&serverTimezone=GMT");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    //如果我这个组件依赖于容器中的其他组件
    //通过传入形参的形式来进行引用,如果这个类型的组件不止一个，通过@Qualifier来指定id
    //使用方式就类似于Autowired
    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("druidDatasource") DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

//    @Bean
//    public DataSourceTransactionManager transactionManager(DataSource dataSource){
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
//        dataSourceTransactionManager.setDataSource(dataSource);
//        return dataSourceTransactionManager;
//    }
    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(druidDatasource());
        return dataSourceTransactionManager;
    }

}
