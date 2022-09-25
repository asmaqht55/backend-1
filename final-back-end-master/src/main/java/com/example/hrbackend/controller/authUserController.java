package com.example.hrbackend.controller;

import com.example.hrbackend.dto.ApiResponse;
import com.example.hrbackend.dto.RegisterForm;
import com.example.hrbackend.model.Hr;
import com.example.hrbackend.model.User;
import com.example.hrbackend.service.authUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class authUserController {
    private final authUserService authuserservice ;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm){
        authuserservice.register(registerForm);
        return ResponseEntity.status(201).body(new ApiResponse("New user registered !",201));
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back",200));
    }
    @GetMapping("/find-user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id){
User user=authuserservice.findUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/find-by-role/{role}")
    public ResponseEntity<List> findUserByRole(@PathVariable String role) {
        List<User> user = authuserservice.getUserByRole(role);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/find-by-username/{username}")
    public ResponseEntity findUserByUserName(@PathVariable String username) {
        User user = authuserservice.getUserByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }



    }