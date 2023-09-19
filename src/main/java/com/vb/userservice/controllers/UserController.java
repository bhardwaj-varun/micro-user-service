package com.vb.userservice.controllers;

import com.vb.userservice.entities.User;
import com.vb.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    ResponseEntity<List<User>> getAllUsers(){
        return  new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable String id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user){
        String id = UUID.randomUUID().toString();
        user.setId(id);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
}
