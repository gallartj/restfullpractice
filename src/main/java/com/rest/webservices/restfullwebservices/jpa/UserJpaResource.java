package com.rest.webservices.restfullwebservices.jpa;

import com.rest.webservices.restfullwebservices.User.User;
import com.rest.webservices.restfullwebservices.User.UserDaoService;
import com.rest.webservices.restfullwebservices.User.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    @Autowired
    UserDaoService service;
    @Autowired
    private UserRepository repository;


    @GetMapping(path = "jpa/users")
    public List<User> retrieveAllUsers() {
        System.out.println(service.findAll());
        return repository.findAll();
    }

    //EntityModel
    //WebMvcLinkBuilder.

    @GetMapping(path = "jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id" + id);
        }
        EntityModel<User> entityModel = EntityModel
                .of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this
                .getClass())
                .retrieveAllUsers());
        entityModel
                .add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity
                .created(location)
                .build();
    }

    @DeleteMapping("jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }
}



