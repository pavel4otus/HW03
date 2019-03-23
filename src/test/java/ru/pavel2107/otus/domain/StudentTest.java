package ru.pavel2107.otus.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName( "Студент")
class StudentTest {

    @Test
    void getName() {
        Student student = new Student( "1", "2");
        assertEquals( "1", student.getName());
    }

    @Test
    void getSurname() {
        Student student = new Student( "1", "2");
        assertEquals( "2", student.getSurname());
    }

    @Test
    void getId() {
        Student student = new Student( "1", "2");
        assertEquals( "2:1", student.getId());

    }
}