package com.example.springjenkinsdockerhub.controller;

import com.example.springjenkinsdockerhub.domain.User;
import com.example.springjenkinsdockerhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        // retrieve the user with the given ID from the database
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        // retrieve the user with the given ID from the database
        User user = userService.findById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> saveUser(@ModelAttribute("user") User user) {
        // save the user to the database
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        // save the user to the database
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        // retrieve the user with the given ID from the database
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(
                    new CustomErrorMessage("User with id= " + id + " not available"), HttpStatus.NOT_FOUND);
        }
        userService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
