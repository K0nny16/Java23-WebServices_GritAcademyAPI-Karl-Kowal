package com.gritacademyapi.DTOS;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private int id;
    private String fName;
    private String lName;
    private String town;
    private String email;
    private String phone;
    private String username;
    private String password;
}