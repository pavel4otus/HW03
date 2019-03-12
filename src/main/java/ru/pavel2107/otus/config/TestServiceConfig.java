package ru.pavel2107.otus.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.pavel2107.otus.repository.QuestionRepository;
import ru.pavel2107.otus.service.TestService;
import ru.pavel2107.otus.service.TestServiceImpl;

import java.util.Locale;

@Configuration
public class TestServiceConfig {

    @Bean
    public TestService testService(
            QuestionRepository questionRepository,
            @Value("${locale.language}") String lang,
            @Value("${locale.country}") String country
            ){
        TestServiceImpl testService = new TestServiceImpl( questionRepository);
        Locale locale = new Locale( lang, country);
        testService.setLocale( locale);

        return testService;
    }
}
