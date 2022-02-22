package com.example.hibernate.service;

import com.example.hibernate.entity.User;
import com.example.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> fetchUsers() {
    return userRepository.findAll();
  }

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User fetchUser(Long id) {
      return userRepository.findById(id).get();
  }

  @Override
  public void deleteUser(Long id) {
    deleteUser(id);
  }

  @Override
  public List<User> fetchUsersByLocation(Long id) {
    List<User> userList = new ArrayList<>();

    userRepository.findByLocationId(id).stream()
    .forEach(userList::add);

    return userList;
  }
}
