package ru.pavel2107.otus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.pavel2107.otus.config.ApplicationProperties;
import ru.pavel2107.otus.service.TestService;
import ru.pavel2107.otus.service.TestServiceImpl;

@SpringBootApplication
@EnableConfigurationProperties( ApplicationProperties.class)
public class Hw03Application {

    public static void main(String[] args) {
       ApplicationContext context=  SpringApplication.run( Hw03Application.class, args);

        TestService testService = context.getBean( TestServiceImpl.class);

        testService.init();
        testService.inviteStudent();
        testService.processTest();
        testService.showResult();

    }


//    @Bean
//    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
//        return new PropertySourcesPlaceholderConfigurer();
//    }

}
