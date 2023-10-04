package com.rest.webservices.restfullwebservices.jpa;

import com.rest.webservices.restfullwebservices.User.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


}
