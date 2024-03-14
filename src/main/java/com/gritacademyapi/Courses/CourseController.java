package com.gritacademyapi.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CoursesService coursesService;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        List<CourseDTO> courseList = coursesService.getAllCourses();
        return ResponseEntity.ok(courseList);
    }
    @GetMapping("/courses/id/{id}")
    public ResponseEntity<AttendanceDTO> getAttendance(@PathVariable int id){
        AttendanceDTO dto = coursesService.getCourseAndStudentsById(id);
        return ResponseEntity.ok(dto);
    }
}
