package com.gritacademyapi.Services;
import com.gritacademyapi.Entitys.CourseEntity;
import com.gritacademyapi.Repos.CoursesRepo;
import com.gritacademyapi.Entitys.StudentEntity;
import com.gritacademyapi.Repos.StudentsRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttendanceService {
    @Autowired
    private StudentsRepo studentsRepo;
    @Autowired
    private CoursesRepo coursesRepo;

    public void removeStudentFromCourse(int studentID,int courseID){
        StudentEntity studentEntity = studentsRepo.findById(studentID)          //findById returnar en optional så behöver throw delen
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentID));
        CourseEntity courseEntity = coursesRepo.findById(courseID)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with ID: "+courseID));
        courseEntity.getStudents().remove(studentEntity);
        studentEntity.getCourses().remove(courseEntity);
        coursesRepo.save(courseEntity);
    }
    public void addStudentToCourse(int studentID,int courseID) throws EntityNotFoundException{
        StudentEntity studentEntity = studentsRepo.findById(studentID)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID:"+studentID));
        CourseEntity courseEntity = coursesRepo.findById(courseID)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with ID:"+courseID));
        studentEntity.getCourses().add(courseEntity);
        studentsRepo.save(studentEntity);
    }
}
