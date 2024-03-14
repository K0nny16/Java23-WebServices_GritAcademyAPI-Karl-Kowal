package com.gritacademyapi.Students;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gritacademyapi.Courses.Course;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "students")
@Table(name ="students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;
    @Column(name = "fName")
    private String fName;
    @Column(name ="lName")
    private String lName;
    @Column(name ="town")
    private String town;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name ="username")
    private String username;
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "students_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id")
    )
    private Set<Course> courses = new HashSet<>();
}
