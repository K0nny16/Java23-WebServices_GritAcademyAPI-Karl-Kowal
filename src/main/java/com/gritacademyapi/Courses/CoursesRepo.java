package com.gritacademyapi.Courses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepo extends JpaRepository<Course,Integer> {
}
