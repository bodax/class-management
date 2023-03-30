package com.bodax.home.managment.service;

import com.bodax.home.managment.db.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent (Student student);

    List<Student> getAllStudents();

    Student getStudent (Long id);

    Student updateStudent (Long id, Student updateDetails);

    void deleteStudent (Long id);
}
