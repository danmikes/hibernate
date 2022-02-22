package com.example.hibernate.controller;

import com.example.hibernate.entity.User;
import com.example.hibernate.service.IUserService;
import com.example.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

  @Autowired
  private IUserService userService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  User postUser(@Valid @RequestBody User user) {
    return userService.createUser(user);
  }

  @GetMapping("")
  List<User> getUserList() {
    return userService.fetchUsers();
  }

  @GetMapping("{id}")
  User getUser(@PathVariable("id") final Long id) {
    return userService.fetchUser(id);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  void deleteUser(@PathVariable("id") final Long id) {
    userService.deleteUser(id);
  }

  @GetMapping("location/{id}")
  List<User> getUserListByLocation(@PathVariable("id") final Long id) {
    return userService.fetchUsersByLocation(id);
  }
}
