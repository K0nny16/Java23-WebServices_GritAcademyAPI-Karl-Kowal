package com.gritacademyapi.Entitys;
import com.gritacademyapi.Entitys.StudentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "courses")
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "YHP")
    private int yhp;
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private Set<StudentEntity> students = new HashSet<>();
}
