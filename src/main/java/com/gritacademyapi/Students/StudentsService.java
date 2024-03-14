package com.gritacademyapi.Students;
import com.gritacademyapi.Courses.CourseDTO;
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
        return getStudentCoursesDTOS(students);
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
        List<Student> students = studentsRepo.findByfNameIgnoreCase(fname);
        return getStudentCoursesDTOS(students);
    }
    public List<StudentCoursesDTO> lNameSearch(String lname){
        List<Student> students = studentsRepo.findBylNameIgnoreCase(lname);
        return getStudentCoursesDTOS(students);
    }
    public List<StudentCoursesDTO> townSearch(String town){
        List<Student> students = studentsRepo.findBytownEqualsIgnoreCase(town);
        return getStudentCoursesDTOS(students);
    }
    private List<StudentCoursesDTO> getStudentCoursesDTOS(List<Student> students) {
        return students.stream().map(student -> {
            List<CourseDTO> courseDTOS = student.getCourses().stream().map(course -> new CourseDTO(
                    course.getId(),
                    course.getName(),
                    course.getYhp(),
                    course.getDescription()
            )).toList();
            return new StudentCoursesDTO(student.getId(),student.getFName(),student.getLName(),courseDTOS);
        }).collect(Collectors.toList());
    }
}

