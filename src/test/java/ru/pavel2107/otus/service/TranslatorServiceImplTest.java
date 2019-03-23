package ru.pavel2107.otus.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.pavel2107.otus.config.ApplicationProperties;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName( "Транслятор")
class TranslatorServiceImplTest {


    @Autowired
    TranslatorService translatorService;

    @Test
    void translate() {
        String str = translatorService.translate( "hello.user");
        assertTrue  ( "Hello, student!".equals( str) );

    }

    @Test
    void translate1() {
        String str = translatorService.translate( "results.answer", new String[]{ "1"} );
        assertTrue( "Your answer is 1".equals( str));
    }
}