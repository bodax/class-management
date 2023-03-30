package com.bodax.home.managment.db.repository;

import com.bodax.home.managment.db.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
