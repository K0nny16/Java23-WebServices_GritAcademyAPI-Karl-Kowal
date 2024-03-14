package com.gritacademyapi.Courses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoursesRepo extends JpaRepository<Course,Integer> {
    Optional<Course> findBynameIgnoreCase(String name);
}
