package com.demo.userlogin.service;

import com.demo.userlogin.model.User;
import com.demo.userlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> saveUsers(List<User> userList)
    {
        return userRepository.saveAll(userList);
    }

    public List<User>getUsers()
    {
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }
}
