package ru.pavel2107.otus.repository.inmemory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.pavel2107.otus.domain.Question;
import ru.pavel2107.otus.repository.QuestionRepository;

import javax.validation.constraints.AssertTrue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName( "Репка")
class InMemoryQuestionRepositoryImplTest {


    @Autowired
    QuestionRepository questionRepository;


    @BeforeEach
    void beforeTests(){
        questionRepository.clear();
    }


    @Test
    void save() {
      Question question=  questionRepository.save(
                new Question( "1", "What is u name?", Arrays.asList( "Paul", "Max", "Petr"), 1 )
        );
        assertEquals( question, null);
    }

    @Test
    void getAll() {
        questionRepository.save( new Question( "1", "What is u name?", Arrays.asList( "Paul", "Max", "Petr"), 1 ));
        Collection<Question> list = questionRepository.getAll();
        assertEquals(  list.size(), 1);

    }
}