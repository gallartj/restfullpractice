package com.rest.webservices.restfullwebservices.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "users_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
