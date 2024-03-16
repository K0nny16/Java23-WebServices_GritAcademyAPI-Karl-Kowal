package com.gritacademyapi.Repos;

import com.gritacademyapi.Entitys.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoursesRepo extends JpaRepository<CourseEntity,Integer> {
    Optional<CourseEntity> findBynameIgnoreCase(String name);
    List<CourseEntity> findBynameContains(String name);
    List<CourseEntity> findBydescriptionContains(String description);
}
