package com.gritacademyapi.Students;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private int id;
    private String town;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String fName;
    private String lName;
}