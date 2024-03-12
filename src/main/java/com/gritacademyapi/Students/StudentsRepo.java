package com.gritacademyapi.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentsRepo  extends JpaRepository<Student,Integer> {
}
