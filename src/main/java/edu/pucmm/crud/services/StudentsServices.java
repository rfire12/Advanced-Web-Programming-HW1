package edu.pucmm.crud.services;

import edu.pucmm.crud.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsServices extends JpaRepository<Student, Long> {
}
