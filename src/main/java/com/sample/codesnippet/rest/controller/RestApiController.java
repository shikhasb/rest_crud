package com.sample.codesnippet.rest.controller;

import com.sample.codesnippet.rest.model.User;
import com.sample.codesnippet.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String getWelcome(){
        return "Welcome Guest";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user)
    {
        userRepository.save(user);
        return "User saved in the Database";
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User wantedUser = userRepository.findById(id).get();
        wantedUser.setAge(user.getAge());
        wantedUser.setFirstName(user.getFirstName());
        userRepository.save(wantedUser);
        return "User data is updated";
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "User with id "+ id + " deleted";
    }
}
