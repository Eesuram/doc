package com.personal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class KeyVaultConfig implements CommandLineRunner {

    @Value("${mysql.connection.string}")
    private String mysqlConnectionString;

    @Value("${mysql.user}")
    private String mysqlUser;

    @Value("${mysql.pwd}")
    private String mysqlPwd;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Override
    public void run(String... args) throws Exception {
        // -- default implementation
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(mysqlConnectionString);
        dataSourceBuilder.username(mysqlUser);
        dataSourceBuilder.password(mysqlPwd);
        return dataSourceBuilder.build();
    }

}
