package com.gritacademyapi.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepo  extends JpaRepository<Student,Integer> {
    List<Student> findByfNameIgnoreCase(String fname);
    List<Student> findBylNameIgnoreCase(String lName);
    List<Student> findBytownEqualsIgnoreCase(String town);
}
