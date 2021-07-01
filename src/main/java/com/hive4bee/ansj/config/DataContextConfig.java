package com.hive4bee.ansj.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.hive4bee.ansj.persistence"},
        entityManagerFactoryRef = "ansjEntityManager",
        transactionManagerRef = "ansjTransactionManager"
)
public class DataContextConfig {
    @Bean(name = "ansjDataSource")
    @ConfigurationProperties(prefix = "spring.datasource0")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ansjTransactionManager")
    public JpaTransactionManager jpaTransactionManager(
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){
//            @Qualifier(value = "ansjEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
        return transactionManager;
    }

    @Bean(name = "ansjEntityManager")
    public LocalContainerEntityManagerFactoryBean ansjEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            DataSource dataSource){
//            @Qualifier("ansjDataSource") DataSource dataSource){
        LocalContainerEntityManagerFactoryBean factoryBean = builder
                .dataSource(dataSource)
                .packages("com.hive4bee.ansj.domain")
                .persistenceUnit("ansjEntityManager")
                .build();
        factoryBean.setJpaProperties(jpaHibernateProperties());
        return factoryBean;
    }

    private Properties jpaHibernateProperties(){
        Properties props = new Properties();
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        props.setProperty("hibernate.jdbc.time_zone", "Asia/Seoul");
        return props;
    }

}
