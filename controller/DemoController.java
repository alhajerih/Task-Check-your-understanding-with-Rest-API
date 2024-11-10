package com.example.demo.controller;

import com.example.demo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
        private List<User> users = new ArrayList<>();

                @PostMapping("/addContact")
                public Object addContact(@RequestBody User newUser){
                    for(User user:users){
                        if(user.getEmail().equals(newUser.getEmail())){
                            return "Contact already exists with this email!";
                        }
                    }

                users.add(newUser);
                return "Contact added successfully! ";
                }

                @GetMapping("/getContactDetails")
                public Object  getContactDetails(@RequestParam String name){
                    for(User user:users){
                        if(user.getName().equalsIgnoreCase(name)){
                            return ResponseEntity.ok(user);
                        }
                    }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find the user");
                }

}
