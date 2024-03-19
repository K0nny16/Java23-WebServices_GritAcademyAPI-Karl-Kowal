package com.gritacademyapi.Controller;
import com.gritacademyapi.DTOS.StudentCoursesDTO;
import com.gritacademyapi.Services.AttendanceService;
import com.gritacademyapi.Services.StudentsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private StudentsService studentsService;
    @GetMapping("/attendance/remove/student/{studentID}/course/{courseID}")
    public ResponseEntity<String> deleteAttendance(@PathVariable int studentID, Model model, @PathVariable int courseID){
        try {
            attendanceService.removeStudentFromCourse(studentID, courseID);
            return ResponseEntity.ok("Student removed from course successfully");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Check Student ID and Course ID and retry");
        }
    }
    @GetMapping("/attendance/add/student/{studentID}/course/{courseID}")
    public ResponseEntity<String> addAttendance(@PathVariable int studentID, @PathVariable int courseID, Model model){
        try {
            attendanceService.removeStudentFromCourse(studentID, courseID);
            return ResponseEntity.ok("Student add from course successfully");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Check Student ID and Course ID and retry");
        }
    }
    @GetMapping("/Attendance")
    public ResponseEntity<List<StudentCoursesDTO>> attendance(){
        List<StudentCoursesDTO> dtos = studentsService.getAllStudentCourses();
        if(dtos == null ||dtos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(dtos);
    }
}
