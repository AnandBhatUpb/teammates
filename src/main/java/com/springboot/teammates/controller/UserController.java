package com.springboot.teammates.controller;

import com.springboot.teammates.model.User;
import com.springboot.teammates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path="/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(path="/user", method=RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @RequestMapping(path="/user/{id}", method =RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
        User updatedUser = userService.updateUser(Long.parseLong(id), user);
        if(updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path="/user/{id}", method =RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
        userService.deleteUser(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
