package com.gritacademyapi.Services;
import com.gritacademyapi.DTOS.CourseDTO;
import com.gritacademyapi.DTOS.StudentCoursesDTO;
import com.gritacademyapi.DTOS.StudentDTO;
import com.gritacademyapi.Entitys.StudentEntity;
import com.gritacademyapi.Repos.StudentsRepo;
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
        Optional<StudentEntity> studentOptional = studentsRepo.findById(studentId);
        if(studentOptional.isPresent()){
            StudentEntity studentEntity = studentOptional.get();
            List<CourseDTO> courseDTOS = studentEntity.getCourses().stream()
                    .map(course -> new CourseDTO(course.getId(), course.getName(),course.getYhp(),course.getDescription()))
                    .toList();
            return new StudentCoursesDTO(studentEntity.getId(), studentEntity.getFName(), studentEntity.getLName(),courseDTOS);
        }else {
            throw new RuntimeException("Student not found with ID: "+studentId);
        }
    }
    public List<StudentCoursesDTO> getAllStudentCourses(){
        List<StudentEntity> studentEntities = studentsRepo.findAll();
        return getStudentCoursesDTOS(studentEntities);
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
    public List<StudentCoursesDTO> fNameSearch(String fname){
        List<StudentEntity> studentEntities = studentsRepo.findByfNameIgnoreCase(fname);
        return getStudentCoursesDTOS(studentEntities);
    }
    public List<StudentCoursesDTO> lNameSearch(String lname){
        List<StudentEntity> studentEntities = studentsRepo.findBylNameIgnoreCase(lname);
        return getStudentCoursesDTOS(studentEntities);
    }
    public List<StudentCoursesDTO> townSearch(String town){
        List<StudentEntity> studentEntities = studentsRepo.findBytownEqualsIgnoreCase(town);
        return getStudentCoursesDTOS(studentEntities);
    }
    private List<StudentCoursesDTO> getStudentCoursesDTOS(List<StudentEntity> studentEntities) {
        return studentEntities.stream().map(student -> {
            List<CourseDTO> courseDTOS = student.getCourses().stream().map(course -> new CourseDTO(
                    course.getId(),
                    course.getName(),
                    course.getYhp(),
                    course.getDescription()
            )).toList();
            return new StudentCoursesDTO(student.getId(),student.getFName(),student.getLName(),courseDTOS);
        }).collect(Collectors.toList());
    }
    public void addStudent(StudentEntity studentEntity){
        studentsRepo.save(studentEntity);
    }
    public void deleteStudent(int id){
        studentsRepo.deleteById(id);
    }
}

