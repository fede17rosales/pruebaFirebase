package com.demo.demo.controller;

import com.demo.demo.object.Person;
import com.demo.demo.service.FirebaseService;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/getUserDetails")
    public Person getUserDetails(@RequestHeader String name) throws InterruptedException, ExecutionException {
        return firebaseService.getUserDetails(name);
    }

    @PostMapping("/createUser")
    public String createNewUser(@RequestBody Person person) throws InterruptedException, ExecutionException {
        return firebaseService.saveUserDetails(person);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody Person person) throws InterruptedException, ExecutionException {
        return firebaseService.updateUserDetails(person);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestHeader String name) {
        return firebaseService.deleteUser(name);
    }
}
