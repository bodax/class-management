package com.bodax.home.managment.service;

import com.bodax.home.managment.db.model.Student;

import java.util.List;

public interface StatisticService {

    List<Student> getAllStudentsFromCity (String cityName);

    List<Student> findAllStudentsByCourse (String courseName);

    int countAllStudentsByCourse (String courseName);

}
