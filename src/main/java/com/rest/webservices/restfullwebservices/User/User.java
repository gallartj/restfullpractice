package com.rest.webservices.restfullwebservices.User;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    @Size(min = 2,message = "name size could'nt be less than 2.")
    private String name;
    @Past
    private LocalDate birtDate;
}
