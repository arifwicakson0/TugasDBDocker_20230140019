package com.praktikumDB.deploy.controller;


import com.praktikumDB.deploy.model.User;
import com.praktikumDB.deploy.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody User request){
        userService.adduser(request);
        return "User created succesfully";
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "user deleted successfully";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User request) {
        userService.updateUser(id, request);
        return "user updated successfully";
    }
}