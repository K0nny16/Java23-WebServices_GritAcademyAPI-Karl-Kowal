package com.gritacademyapi.Repos;
import com.gritacademyapi.Entitys.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepo  extends JpaRepository<StudentEntity,Integer> {
    List<StudentEntity> findByfNameIgnoreCase(String fname);
    List<StudentEntity> findBylNameIgnoreCase(String lName);
    List<StudentEntity> findBytownEqualsIgnoreCase(String town);
}
