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
    public ResponseEntity<AttendanceDTO> getAttendanceById(@PathVariable int id){
        AttendanceDTO dto = coursesService.getCourseAndStudentsById(id);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/courses/name/{name}")
    public ResponseEntity<AttendanceDTO> getAttendanceByName(@PathVariable String name){
        AttendanceDTO dto = coursesService.getCourseAndStudentsByCoursename(name);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/courses/like/name/{like}")
    public ResponseEntity<List<CourseDTO>> partialSearch(@PathVariable String like){
        List<CourseDTO> dto = coursesService.getCourseLike(like);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/courses/like/description/{like}")
    public ResponseEntity<List<CourseDTO>> descriptionSearch(@PathVariable String like){
        List<CourseDTO> dto = coursesService.getCourseLikeDescription(like);
        return ResponseEntity.ok(dto);
    }
}
