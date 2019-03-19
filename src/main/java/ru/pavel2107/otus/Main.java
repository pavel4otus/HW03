package ru.pavel2107.otus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.pavel2107.otus.config.RepositoryConfig;
import ru.pavel2107.otus.config.TestServiceConfig;
import ru.pavel2107.otus.domain.Question;
import ru.pavel2107.otus.service.TestService;
import ru.pavel2107.otus.service.TestServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@PropertySource( "classpath:application.properties")
@ComponentScan( basePackages = "ru.pavel2107.otus")
@Configuration
public class Main {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( Main.class);


        TestService testService = context.getBean( TestServiceImpl.class);

        testService.init();
        testService.inviteStudent();
        testService.processTest();
        testService.showResult();
    }
}
