package com.gritacademyapi.Courses;

import com.gritacademyapi.Students.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    AttendanceDTO getCourseAndStudentsById(int id){
        Optional<Course> courseOptional = coursesRepo.findById(id);
        if(courseOptional.isPresent())
            return getAttendanceDTO(courseOptional);
        else
            throw new RuntimeException("Course not found with ID: "+id);
    }
    AttendanceDTO getCourseAndStudentsByCoursename(String name){
        Optional<Course> courseOptional = coursesRepo.findBynameIgnoreCase(name);
        if(courseOptional.isPresent())
            return getAttendanceDTO(courseOptional);
        else
            throw new RuntimeException("Course not find with name: "+name);
    }
    List<CourseDTO> getCourseLike(String name){
        return coursesRepo.findBynameContains(name).stream().map(course -> new CourseDTO(
                course.getId(),
                course.getName(),
                course.getYhp(),
                course.getDescription()
        )).collect(Collectors.toList());
    }

    private AttendanceDTO getAttendanceDTO(Optional<Course> courseOptional) {
        Course course = courseOptional.get();
        List<StudentDTO> studentDTOS = course.getStudents().stream().map(student -> new StudentDTO(
                student.getId(),
                student.getFName(),
                student.getLName(),
                student.getTown(),
                student.getEmail(),
                student.getPhone(),
                student.getUsername(),
                student.getPassword()
        )).toList();
        return new AttendanceDTO(course.getId(),course.getName(),course.getYhp(), course.getDescription(), studentDTOS);
    }
}
