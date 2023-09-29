package com.rest.webservices.restfullwebservices.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "users_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2, message = "name size could'nt be less than 2.")
    //@JsonProperty("users_name")
    private String name;
    @Past
    //@JsonProperty("birt_date")
    private LocalDate birtDate;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;
}
