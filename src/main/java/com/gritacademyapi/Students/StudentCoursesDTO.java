package com.gritacademyapi.Students;
import com.gritacademyapi.Courses.CourseDTO;
import lombok.*;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCoursesDTO { //DTO Data transfer object
    private int id;
    private String fName;
    private String lName;
    private List<CourseDTO> courses;
}
