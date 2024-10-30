package com.devsuperior.userdept.controller;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> Busca(){
       List<User> result = repository.findAll();
       return result;
    }

    @GetMapping(value = "/{id}")
    public User BuscaPorId(@PathVariable Long id){
        User result = repository.findById(id).get();
        return result;
    }

    @PostMapping(value = "/{id}")
    public User Inserir(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }

}
