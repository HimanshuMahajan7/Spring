package com.example.controller;

import com.example.entity.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserRestController {

    @GetMapping("/user")
    public EntityModel<User> getUser() {
        User user = User.builder().id(101).name("Himanshu").email("emailofhim@gmail.com").build();

        return EntityModel.of(user,
                linkTo(methodOn(UserRestController.class).getUser()).withSelfRel(),
                linkTo(methodOn(UserRestController.class).getUser()).withRel("close"),
                linkTo(methodOn(UserRestController.class).getUser()).withRel("assign")
        );
    }
}
