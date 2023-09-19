package com.vb.userservice.services;

import com.vb.userservice.entities.User;

import java.util.List;

public interface UserService {
    List<User> getUsers() ;
    User getUser(String id);
    User save(User user);
}
