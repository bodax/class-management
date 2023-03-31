package com.bodax.home.managment.service;

import com.bodax.home.managment.db.model.Student;
import com.bodax.home.managment.db.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void findAll_should_return_student_list() {
        // Given
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("Ivan");
        student.setLastName("Recic");
        student.setEmailId("email@test.com");


        // When calling the mocked repository method
        when(studentRepository.findAll()).thenReturn(List.of(student));
        List<?> students = this.studentService.getAllStudents();

        // Then
        assertEquals(List.of(student), students);
        Mockito.verify(this.studentRepository).findAll();
    }

    @Test
    void findById_should_return_single_student() {
        // Given
        Student student = new Student();
        student.setId(2L);
        student.setFirstName("Ivan");
        student.setLastName("Recic");
        student.setEmailId("email@test.com");

        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));
        Student returnedStudent = this.studentService.getStudent(2L);

        assertNotNull(returnedStudent);
        Mockito.verify(this.studentRepository).findById(2L);
    }
}
