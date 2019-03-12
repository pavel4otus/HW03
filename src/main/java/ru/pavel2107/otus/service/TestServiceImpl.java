package ru.pavel2107.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import ru.pavel2107.otus.domain.Question;
import ru.pavel2107.otus.domain.Student;
import ru.pavel2107.otus.domain.TestStore;
import ru.pavel2107.otus.repository.QuestionRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestServiceImpl implements TestService {

    private TestStore testStore;

    @Autowired
    private final QuestionRepository questionRepository;


    @Autowired
    private MessageSource messageSource;

    private Locale locale;


    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public TestServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public boolean init(){
        questionRepository.init();

        return true;
    }


    private String translated( String str, String[] arr){
        return messageSource.getMessage(str,  arr,  locale);
    }
    private String translated( String str){
        return messageSource.getMessage(str,  new String[]{},  locale);
    }
    private String translated( String str, String mess){
        return translated( str, new String[]{ mess});
    }


    public boolean inviteStudent(){
        String name;
        String surname;
        Scanner scanner = new Scanner( System.in);
        System.out.println( translated( "hello.user"));
        System.out.print( translated( "enter_u_name")); name    = scanner.next();
        System.out.print( translated("enter_u_surname")); surname = scanner.next();

        if( name == null || surname == null){
            return false;
        }

        testStore = new TestStore( new Student( name, surname));
        return true;
    }


    public void processTest(){
        List<Question> questionList = new ArrayList<>(questionRepository.getAll());
        Scanner scanner = new Scanner( System.in);
        for( int i = 0; i < questionList.size(); i++){
            Question question = questionList.get( i);
            System.out.println( translated( "question.say", new String[]{ question.getId(),  question.getQuestion()}) );
            System.out.println( translated( "question.variants"));
            for( int j = 0; j < question.getAnswers().size(); j++ ) {
                System.out.println( "  " + (j+1) + ")" + question.getAnswers().get( j )) ;
            }
            System.out.print( translated("question.enter_answer_number")); int answer = scanner.nextInt();
            testStore.addAnswer( question.getId(), answer);
        }
    }

    public void showResult(){
        List<Question> questionList = new ArrayList<>(questionRepository.getAll());
        int correctAnswers = 0;
        System.out.println( translated( "results.header", testStore.getStudent().toString()));
        for( Question question : questionList){
            System.out.print( question.toString() + ". ");
            int studentAnswer = testStore.getAnswers().get( question.getId());
            System.out.print( translated( "results.answer", Integer.toString( studentAnswer)) );
            if( question.getCorrectAnswer() == studentAnswer){
                correctAnswers++;
                System.out.println( translated("results.ok"));
            } else {
                System.out.println( translated( "results.error"));
            }
        }
        System.out.println( translated( "results.correct_answers", Integer.toString( correctAnswers)));

    }

}


