package com.northwind.customerservice;

import com.northwind.customerservice.adapter.OrderClient;
import com.northwind.customerservice.adapter.OrderClientImpl;
import com.northwind.customerservice.adapter.OrderConfig;
import com.northwind.customerservice.infrastructure.LoggerFactory;
import com.northwind.customerservice.infrastructure.LoggerFactoryImpl;
import com.northwind.customerservice.infrastructure.TraceContext;
import com.northwind.customerservice.repositories.CustomerRepository;
import com.northwind.customerservice.repositories.impl.AddressRowMapper;
import com.northwind.customerservice.repositories.impl.CustomerRowMapper;
import com.northwind.customerservice.repositories.impl.MySqlCustomerRepository;
import com.northwind.customerservice.services.CustomerService;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.statsd.StatsdConfig;
import io.micrometer.statsd.StatsdMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.northwind.customerservice"})
public class AppConfig {
    private Properties properties = new Properties();
    public AppConfig(){
        InputStream appPropsFile = AppConfig.class.getClassLoader()
                .getResourceAsStream("application.properties");
        try {
            properties.load(appPropsFile);
            appPropsFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Bean
    public DataSource datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(properties.getProperty("db.connectionString"));
        dataSource.setUsername("customers-user");
        dataSource.setPassword("password");

        return dataSource;
    }
    //DI Configuration goes here.

    @Bean
    public OrderConfig orderConfig(){
        OrderConfig orderConfig = new OrderConfig();
        orderConfig.setURL(properties.getProperty("order-service"));
        return orderConfig;
    }
    @Bean
    public CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerService(customerRepository);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public OrderClient orderClient(RestTemplate restTemplate, OrderConfig orderConfig){
        return new OrderClientImpl(restTemplate,orderConfig);
    }

    @Bean
    public CustomerRepository customerRepository(DataSource dataSource,
                                                 CustomerRowMapper customerRowMapper,
                                                 AddressRowMapper addressRowMapper,
                                                 LoggerFactory loggerFactory,
                                                 MeterRegistry meterRegistry,
                                                 TraceContext traceContext) {
        return new MySqlCustomerRepository(dataSource,
                customerRowMapper,
                addressRowMapper,
                loggerFactory,
                meterRegistry,
                traceContext);
    }

    @Bean
    public CustomerRowMapper customerRowMapper() {
        return new CustomerRowMapper();
    }

    @Bean
    public AddressRowMapper addressRowMapper() {
        return new AddressRowMapper();
    }

    @Bean
    public LoggerFactory loggerFactory() {
        return new LoggerFactoryImpl();
    }

    @Bean
    public MeterRegistry meterRegistry() {
        StatsdConfig statsdConfig = new StatsdConfig() {
            @Override
            public String get(String key) {
                return properties.getProperty(key);
            }



            @Override
            public String prefix() {
                return "metrics";
            }
        };

        MeterRegistry meterRegistry = new StatsdMeterRegistry(statsdConfig, Clock.SYSTEM);

        meterRegistry.config().commonTags("service","customer-service");
        new ClassLoaderMetrics().bindTo(meterRegistry);
        new JvmMemoryMetrics().bindTo(meterRegistry);
        new JvmGcMetrics().bindTo(meterRegistry);
        new ProcessorMetrics().bindTo(meterRegistry);
        new JvmThreadMetrics().bindTo(meterRegistry);
        return meterRegistry;
    }

    @Bean
    @RequestScope
    public TraceContext traceContext() {
        return new TraceContext();
    }


}









