package com.rest.webservices.restfullwebservices.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserResource {
    UserDaoService service;
    public UserResource(UserDaoService service){
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        System.out.println(service.findAll());
        return service.findAll();
    }
}
