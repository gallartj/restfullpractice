package com.rest.webservices.restfullwebservices.jpa;

import com.rest.webservices.restfullwebservices.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
