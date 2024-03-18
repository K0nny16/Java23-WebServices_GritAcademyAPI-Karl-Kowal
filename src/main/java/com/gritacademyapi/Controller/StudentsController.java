package com.gritacademyapi.Controller;
import com.gritacademyapi.DTOS.StudentCoursesDTO;
import com.gritacademyapi.DTOS.StudentDTO;
import com.gritacademyapi.Entitys.StudentEntity;
import com.gritacademyapi.Services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> studentsList = studentsService.getAllStudents();
        if(studentsList == null ||studentsList.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(studentsList);
    }
    @GetMapping("/students/id/{studentId}")
    public ResponseEntity<StudentCoursesDTO> getStudentCourses(@PathVariable int studentId) {
        StudentCoursesDTO dto = studentsService.getStudentWithCourses(studentId);
        if(dto == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/students/fname/{name}")
    public ResponseEntity<List<StudentCoursesDTO>> getStudentsCoursesByfName(@PathVariable String name){
        List<StudentCoursesDTO> dto = studentsService.fNameSearch(name);
        if(dto == null||dto.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/students/lname/{name}")
    public ResponseEntity<List<StudentCoursesDTO>> getStudentsCoursesBylName(@PathVariable String name,RedirectAttributes redirectAttributes){
        List<StudentCoursesDTO> dto = studentsService.lNameSearch(name);
        if(dto == null|| dto.isEmpty()){
            redirectAttributes.addFlashAttribute("errorMessage","404 name not found");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/students/town/{town}")
    public ResponseEntity<List<StudentCoursesDTO>> getStudentsCoursesByTown(@PathVariable String town){
        List<StudentCoursesDTO> dto = studentsService.townSearch(town);
        if(dto == null|| dto.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/students/add")
    public ModelAndView addStudentForm(){
        return new ModelAndView("addStudent");
    }
    @PostMapping("/addStudent")
    public ModelAndView addStudent(@ModelAttribute StudentEntity studentEntity, RedirectAttributes redirectAttributes){
        try{
            studentsService.addStudent(studentEntity);
            return new ModelAndView("redirect:/students");
        }catch (Exception ex){
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage","Something went wrong! Try again");
            return new ModelAndView("redirect:error");
        }
    }
    @GetMapping("/students/remove/{id}")
    public ModelAndView deleteStudent(@PathVariable int id, Model model){
        try{
            studentsService.deleteStudent(id);
            return new ModelAndView("redirect:/students");
        }catch (Exception ex){
            ex.printStackTrace();
            model.addAttribute("error","That student id does not exist in the database");
            return new ModelAndView("redirect:error");
        }
    }
}
