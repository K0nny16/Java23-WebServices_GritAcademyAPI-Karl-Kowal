package com.gritacademyapi.Students;
import com.gritacademyapi.Courses.Course;
import com.gritacademyapi.Courses.CourseDTO;
import com.gritacademyapi.Courses.CoursesRepo;
import com.gritacademyapi.Courses.StudentCoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsService {
    @Autowired
    StudentsRepo studentsRepo;
    public StudentCoursesDTO getStudentWithCourses(int studentId){
        Optional<Student> studentOptional = studentsRepo.findById(studentId);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            List<CourseDTO> courseDTOS = student.getCourses().stream()
                    .map(course -> new CourseDTO(course.getId(), course.getName(),course.getYhp(),course.getDescription()))
                    .toList();
            return new StudentCoursesDTO(student.getId(),student.getFName(),student.getLName(),courseDTOS);
        }else {
            throw new RuntimeException("Student not found with ID: "+studentId);
        }
    }
    public List<StudentCoursesDTO> getAllStudentCourses(){
        List<Student> students = studentsRepo.findAll();
        return students.stream().map(student -> {
            List<CourseDTO> courseDTOS = student.getCourses().stream().map(course -> new CourseDTO(course.getId(),course.getName(),course.getYhp(),course.getDescription()))
                    .toList();
            return new StudentCoursesDTO(student.getId(),student.getFName(),student.getLName(),courseDTOS);
        }).collect(Collectors.toList());
    }

    public List<StudentDTO> getAllStudents(){
        return studentsRepo.findAll().stream().map(student -> new StudentDTO(
                student.getId(),
                student.getTown(),
                student.getEmail(),
                student.getPhone(),
                student.getUsername(),
                student.getPassword(),
                student.getFName(),
                student.getLName()
        )).collect(Collectors.toList());
    }
}

