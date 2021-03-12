package com.demo.userlogin.cotroller;

import com.demo.userlogin.model.User;
import com.demo.userlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    //@PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }
    //@PostMapping("/addUsers")
    public List<User> addUser(@RequestBody List<User> userList){
        return service.saveUsers(userList);
    }

    //@GetMapping("/users")
    public List<User>findAllUsers()
    {
        return service.getUsers();
    }

    //@GetMapping("/users/{id}")
    public User findUserById(@PathVariable String id){
        return service.getUserById(id);
    }
}
