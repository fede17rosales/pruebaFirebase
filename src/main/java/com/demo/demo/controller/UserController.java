package com.demo.demo.controller;

import com.demo.demo.object.Person;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/getUserDetails")
    public String getUserDetails(@RequestHeader String name) {
        return "Solicitud del usuario: " + name;
    }

    @PostMapping("/createUser")
    public String createNewUser(@RequestBody Person person) {
        return "Usuario Creado: " + person.getName() ;
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody Person person) {
        return "Usuario Actualizado: " + person.getName() ;
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody Person person) {
        return "Usuario Eliminado: " + person.getName();
    }
}
