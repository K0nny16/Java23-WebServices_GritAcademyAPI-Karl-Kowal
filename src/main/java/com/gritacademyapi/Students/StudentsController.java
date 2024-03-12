package com.gritacademyapi.Students;
import com.gritacademyapi.Courses.Course;
import com.gritacademyapi.Courses.StudentCoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> studentsList = studentsService.getAllStudents();
        return ResponseEntity.ok(studentsList);
    }
    @GetMapping("/Attendance")
    public ResponseEntity<List<StudentCoursesDTO>> attendance(){
       List<StudentCoursesDTO> dtos = studentsService.getAllStudentCourses();
       return ResponseEntity.ok(dtos);
    }
    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentCoursesDTO> getStudentCourses(@PathVariable int studentId) {
        StudentCoursesDTO dto = studentsService.getStudentWithCourses(studentId);
        return ResponseEntity.ok(dto);
    }
}
