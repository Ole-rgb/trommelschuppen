package com.trommelschuppen.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "{userId}")
    public ResponseEntity<User> findById(@PathVariable("userId") Long id){
        return userService.findById(id);
    }
    
    @GetMapping() //TODO remove the optional, because all users are too much
    public ResponseEntity<List<User>> getUsers(@RequestParam("limit") Optional<Integer> limit){
        return userService.getUserswithLimit(limit);
    }

}
