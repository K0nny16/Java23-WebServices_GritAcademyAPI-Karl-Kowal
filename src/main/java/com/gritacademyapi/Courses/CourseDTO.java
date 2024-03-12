package com.gritacademyapi.Courses;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private int id;
    private String name;
    private int yhp;
    private String description;
}
