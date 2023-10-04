package com.rest.webservices.restfullwebservices.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 10)
    private String description;
   @JsonIgnore
   @ManyToOne(fetch = FetchType.LAZY)
    private User user;


}
