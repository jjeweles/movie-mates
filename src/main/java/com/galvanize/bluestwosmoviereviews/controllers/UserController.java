package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.UserModel;
import com.galvanize.bluestwosmoviereviews.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserModel> getUserByID(@PathVariable Integer id) {
        UserModel user = userService.getUserByID(id);

        return user == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(user);
    }

}
