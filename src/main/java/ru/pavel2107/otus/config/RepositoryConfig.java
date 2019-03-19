package ru.pavel2107.otus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.pavel2107.otus.repository.QuestionRepository;
import ru.pavel2107.otus.repository.inmemory.InMemoryQuestionRepositoryImpl;

@Configuration
public class RepositoryConfig {

    @Bean
    public QuestionRepository questionRepository(@Value( "${filename}") String fileName ){
        InMemoryQuestionRepositoryImpl questionRepository = new InMemoryQuestionRepositoryImpl();
        questionRepository.setFileName( fileName);

        return questionRepository;
    }

}
