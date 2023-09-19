package com.vb.userservice.services.impl;

import com.vb.userservice.entities.User;
import com.vb.userservice.exceptions.ResourceNotFoundException;
import com.vb.userservice.repositories.UserRepository;
import com.vb.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User by not found with id: "+ id));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
