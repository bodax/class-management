package com.bodax.home.managment.service;

import com.bodax.home.managment.db.model.Student;
import com.bodax.home.managment.db.repository.StudentRepository;
import com.bodax.home.managment.exceptions.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Not found student with this id : " + id));

    }

    @Override
    public Student updateStudent(Long studentId, Student updateDetails) {
        Student student = getStudent(studentId);
        student.setFirstName(updateDetails.getFirstName());
        student.setLastName(updateDetails.getLastName());
        student.setEmailId(updateDetails.getEmailId());
        student.setCourse(updateDetails.getCourse());
        student.setCountry(updateDetails.getCountry());
        student.setCity(updateDetails.getCity());

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(getStudent(id));
    }
}
