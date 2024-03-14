package com.gritacademyapi.Students;
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
    @GetMapping("/students/id/{studentId}")
    public ResponseEntity<StudentCoursesDTO> getStudentCourses(@PathVariable int studentId) {
        StudentCoursesDTO dto = studentsService.getStudentWithCourses(studentId);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/students/fname/{name}")
    public ResponseEntity<List<StudentCoursesDTO>> getStudentsCoursesByfName(@PathVariable String name){
        List<StudentCoursesDTO> dto = studentsService.fNameSearch(name);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/students/lname/{name}")
    public ResponseEntity<List<StudentCoursesDTO>> getStudentsCoursesBylName(@PathVariable String name){
        List<StudentCoursesDTO> dto = studentsService.lNameSearch(name);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/students/town/{town}")
    public ResponseEntity<List<StudentCoursesDTO>> getStudentsCoursesByTown(@PathVariable String town){
        List<StudentCoursesDTO> dto = studentsService.townSearch(town);
        return ResponseEntity.ok(dto);
    }
}
