package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.UserModel;
import com.galvanize.bluestwosmoviereviews.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("users/add")
    public UserModel addUser(@RequestBody UserModel user) {
        return userService.addUser(user);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Integer id, @RequestBody UserModel user) {
        UserModel updatedUser = userService.updateUser(id, user);

        return updatedUser == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable Integer id) {
        UserModel deletedUser = userService.deleteUser(id);

        return deletedUser == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(deletedUser);
    }

}
