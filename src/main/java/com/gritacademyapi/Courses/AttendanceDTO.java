package com.gritacademyapi.Courses;

import com.gritacademyapi.Students.StudentDTO;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {
    private int id;
    private String name;
    private int yhp;
    private String description;
    private List<StudentDTO> studentDTOList;
}
