package com.northwind.shippingservice;

import com.northwind.shippingservice.api.ShippingRatesRowMapper;
import com.northwind.shippingservice.repositories.ShippingRatesRepository;
import com.northwind.shippingservice.repositories.impl.ShippingRatesRepositoryImpl;
import com.northwind.shippingservice.services.ShippingRatesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.northwind.shippingservice"})
public class AppConfig {
    @Bean
    public DataSource datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/shipping-db");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        return dataSource;
    }

    @Bean
    public ShippingRatesService shippingRatesService(ShippingRatesRepository shippingRatesRepository){
        return new ShippingRatesService(shippingRatesRepository);
    }

    @Bean
    public ShippingRatesRowMapper shippingRatesRowMapper()
    {
        return new ShippingRatesRowMapper();
    }

    @Bean
    public ShippingRatesRepository shippingRatesRepository(DataSource dataSource, ShippingRatesRowMapper shippingRatesRowMapper){
        return new ShippingRatesRepositoryImpl(dataSource,shippingRatesRowMapper);
    }

}
