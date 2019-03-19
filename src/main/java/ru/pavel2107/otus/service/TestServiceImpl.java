package ru.pavel2107.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.otus.domain.Question;
import ru.pavel2107.otus.domain.Student;
import ru.pavel2107.otus.domain.TestStore;
import ru.pavel2107.otus.repository.QuestionRepository;

import java.util.*;

public class TestServiceImpl implements TestService {

    private TestStore testStore;

    private final QuestionRepository questionRepository;
    private final InviteStudent     inviteStudent;


    @Autowired
    private TransmitterService transmitterService;

    @Autowired
    public TestServiceImpl(
            QuestionRepository questionRepository,
            TransmitterService transmitterService,
            InviteStudent      inviteStudent
    ) {
        this.questionRepository = questionRepository;
        this.transmitterService = transmitterService;
        this.inviteStudent      = inviteStudent;
    }

    public boolean init(){
        questionRepository.init();

        return true;
    }




    public boolean inviteStudent(){

        Student student = inviteStudent.invite();
        testStore = new TestStore( student);
        return true;
    }


    public void processTest(){
        List<Question> questionList = new ArrayList<>(questionRepository.getAll());
        for( int i = 0; i < questionList.size(); i++){
            Question question = questionList.get( i);
            transmitterService.printlnResource( "question.say", question.getId(),  question.getQuestion());
            transmitterService.printlnResource( "question.variants");
            for( int j = 0; j < question.getAnswers().size(); j++ ) {
                transmitterService.printlnString( "  " + (j+1) + ")" + question.getAnswers().get( j )); ;
            }
            transmitterService.printResource("question.enter_answer_number"); int answer = transmitterService.getInt();
            testStore.addAnswer( question.getId(), answer);
        }
    }

    public void showResult(){
        List<Question> questionList = new ArrayList<>(questionRepository.getAll());
        int correctAnswers = 0;
        transmitterService.printlnResource( "results.header", testStore.getStudent().toString());
        for( Question question : questionList){
            transmitterService.printlnString( question.toString() + ". ");
            int studentAnswer = testStore.getAnswers().get( question.getId());
            transmitterService.printResource( "results.answer", Integer.toString( studentAnswer));
            if( question.getCorrectAnswer() == studentAnswer){
                correctAnswers++;
                transmitterService.printlnResource("results.ok");
            } else {
                transmitterService.printlnResource( "results.error");
            }
        }
        transmitterService.printlnResource( "results.correct_answers", Integer.toString( correctAnswers));

    }

}


