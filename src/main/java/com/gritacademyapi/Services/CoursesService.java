package com.gritacademyapi.Services;
import com.gritacademyapi.Repos.CoursesRepo;
import com.gritacademyapi.DTOS.AttendanceDTO;
import com.gritacademyapi.DTOS.CourseDTO;
import com.gritacademyapi.DTOS.StudentDTO;
import com.gritacademyapi.Entitys.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursesService {

    @Autowired
    CoursesRepo coursesRepo;

    public List<CourseDTO> getAllCourses(){
        return coursesRepo.findAll().stream().map(course -> new CourseDTO(
                course.getId(),
                course.getName(),
                course.getYhp(),
                course.getDescription()
        )).collect(Collectors.toList());
    }
    public AttendanceDTO getCourseAndStudentsById(int id){
        Optional<CourseEntity> courseOptional = coursesRepo.findById(id);
        if(courseOptional.isPresent())
            return getAttendanceDTO(courseOptional);
        else
            throw new RuntimeException("Course not found with ID: "+id);
    }
    public AttendanceDTO getCourseAndStudentsByCoursename(String name){
        Optional<CourseEntity> courseOptional = coursesRepo.findBynameIgnoreCase(name);
        if(courseOptional.isPresent())
            return getAttendanceDTO(courseOptional);
        else
            throw new RuntimeException("Course not find with name: "+name);
    }
    public List<CourseDTO> getCourseLike(String name){
        return coursesRepo.findBynameContains(name).stream().map(course -> new CourseDTO(
                course.getId(),
                course.getName(),
                course.getYhp(),
                course.getDescription()
        )).collect(Collectors.toList());
    }
    public List<CourseDTO> getCourseLikeDescription(String description){
        return coursesRepo.findBydescriptionContains(description).stream().map(course -> new CourseDTO(
                course.getId(),
                course.getName(),
                course.getYhp(),
                course.getDescription()
        )).collect(Collectors.toList());
    }

    private AttendanceDTO getAttendanceDTO(Optional<CourseEntity> courseOptional) {
        CourseEntity courseEntity = courseOptional.get();
        List<StudentDTO> studentDTOS = courseEntity.getStudents().stream().map(student -> new StudentDTO(
                student.getId(),
                student.getFName(),
                student.getLName(),
                student.getTown(),
                student.getEmail(),
                student.getPhone(),
                student.getUsername(),
                student.getPassword()
        )).toList();
        return new AttendanceDTO(courseEntity.getId(), courseEntity.getName(), courseEntity.getYhp(), courseEntity.getDescription(), studentDTOS);
    }
    public void addCourse(CourseEntity courseEntity){
        coursesRepo.save(courseEntity);
    }
    public void deleteCourse(int id){
        coursesRepo.deleteById(id);
    }
}
