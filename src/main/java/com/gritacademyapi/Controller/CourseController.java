package com.gritacademyapi.Controller;
import com.gritacademyapi.Entitys.CourseEntity;
import com.gritacademyapi.Services.CoursesService;
import com.gritacademyapi.DTOS.AttendanceDTO;
import com.gritacademyapi.DTOS.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
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
    @GetMapping("/courses/add")
    public ModelAndView addCourseForm(){
        return new ModelAndView("addCourse");
    }
    @PostMapping("/addCourse")
    public ModelAndView addCourse(
            @RequestParam("name") String name,
            @RequestParam("YHP")String yhp,
            @RequestParam("description")String description,
            RedirectAttributes redirectAttributes){
        try{
            int yhpInt = Integer.parseInt(yhp);
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setName(name);
            courseEntity.setYhp(yhpInt);
            courseEntity.setDescription(description);
            coursesService.addCourse(courseEntity);
            return new ModelAndView("redirect:/courses");
        }catch (NumberFormatException ex){
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage","YHP has to written as number (ex 1,2,3)");
            return new ModelAndView("redirect:/courses/add");
        }
    }
    @GetMapping("/courses/remove/{id}")
    public ModelAndView deleteCourse(@PathVariable int id,
                                     Model model){
        try {
            coursesService.deleteCourse(id);
            return new ModelAndView("redirect:/courses");
        }catch (Exception ex){
            ex.printStackTrace();
            model.addAttribute("error","That course id does not exist in the database!");
            return new ModelAndView("redirect:error");
        }
    }
}
