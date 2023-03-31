package com.bodax.home.managment.service;

import com.bodax.home.managment.db.model.Student;
import com.bodax.home.managment.db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final StudentRepository studentRepository;

    @Autowired
    public StatisticServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudentsFromCity(String city) {
        List<Student> allStudents = studentRepository.findAll();

        return allStudents
                .stream()
                .filter(std -> std.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findAllStudentsByCourse(String course) {
        List<Student> allStudents = studentRepository.findAll();

        return allStudents
                .stream()
                .filter(std -> std.getCity().equalsIgnoreCase(course))
                .collect(Collectors.toList());
    }
}
