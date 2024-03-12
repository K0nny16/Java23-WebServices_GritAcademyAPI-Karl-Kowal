package com.gritacademyapi.Courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursesService {

    @Autowired
    CoursesRepo coursesRepo;

    List<CourseDTO> getAllCourses(){
        return coursesRepo.findAll().stream().map(course -> new CourseDTO(
                course.getId(),
                course.getName(),
                course.getYhp(),
                course.getDescription()
        )).collect(Collectors.toList());
    }
}
