package ru.pavel2107.otus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.pavel2107.otus.service.TestService;
import ru.pavel2107.otus.service.TestServiceImpl;

@SpringBootApplication
public class Hw03Application {



    public static void main(String[] args) {
       ApplicationContext context=  SpringApplication.run( Hw03Application.class, args);

        TestService testService = context.getBean( TestServiceImpl.class);

        testService.init();
        testService.inviteStudent();
        testService.processTest();
        testService.showResult();

    }

}
