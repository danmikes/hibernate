package com.example.hibernate.service;

import com.example.hibernate.entity.User;

import java.util.List;

public interface IUserService {

  List<User> fetchUsers();

  User createUser(User user);

  User fetchUser(Long id);

  public void deleteUser(Long id);

  public List<User> fetchUsersByLocation(Long id);
}
