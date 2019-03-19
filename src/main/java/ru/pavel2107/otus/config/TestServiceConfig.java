package ru.pavel2107.otus.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.pavel2107.otus.repository.QuestionRepository;
import ru.pavel2107.otus.service.*;


@Configuration
public class TestServiceConfig {

    @Bean
    public TestService testService(
            QuestionRepository questionRepository,
            TransmitterService transmitterService,
            InviteStudent      inviteStudent,
            @Value("${locale.language}") String lang,
            @Value("${locale.country}") String country
            ){
        TestServiceImpl testService = new TestServiceImpl( questionRepository, transmitterService, inviteStudent);

        return testService;
    }
}
