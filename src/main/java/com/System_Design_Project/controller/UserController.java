package com.System_Design_Project.controller;

import com.System_Design_Project.dto.CreditCardDTO;
import com.System_Design_Project.dto.LoginDTO;
import com.System_Design_Project.dto.UserDTO;
import com.System_Design_Project.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.System_Design_Project.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDto) {
        Response registerResponse = userService.addUser(userDto);
        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        Response loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/userInfo/{telNumber}")
    public ResponseEntity<?> getUserInfo(@PathVariable String telNumber) {
        Response infoResponse = userService.getUserInfo(telNumber);
        return ResponseEntity.ok(infoResponse);
    }
}
