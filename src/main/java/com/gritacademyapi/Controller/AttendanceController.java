package com.gritacademyapi.Controller;
import com.gritacademyapi.Services.AttendanceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @GetMapping("/attendance/remove/student/{studentID}/course/{courseID}")
    public ModelAndView deleteAttendance(@PathVariable int studentID, Model model, @PathVariable int courseID){
        try{
            attendanceService.removeStudentFromCourse(studentID,courseID);
            return new ModelAndView("redirect:/Attendance");
        }catch (EntityNotFoundException ex){
            ex.printStackTrace();
            model.addAttribute("error","Check Student ID and Course ID and retry");
            return new ModelAndView("redirect:error");
        }
    }
    @GetMapping("/attendance/add/student/{studentID}/course/{courseID}")
    public ModelAndView addAttendance(@PathVariable int studentID, @PathVariable int courseID, Model model){
        try {
            attendanceService.addStudentToCourse(studentID, courseID);
            return new ModelAndView("redirect:/Attendance");
        }catch (EntityNotFoundException ex){
            ex.printStackTrace();
            model.addAttribute("error","Check Student ID and Course ID and retry");
            return new ModelAndView("redirect:error");
        }
    }
}
