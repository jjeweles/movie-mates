package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.UserModel;
import com.galvanize.bluestwosmoviereviews.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public Iterable<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserModel> getUserByID(@PathVariable Integer id) {
        UserModel user = userService.getUserByID(id);

        return user == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(user);
    }

    @GetMapping("users/get/{username}")
    public ResponseEntity<UserModel> getUserByUsername(@PathVariable String username) {
        UserModel user = userService.getUserByUsername(username);

        return user == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(user);
    }

    @PostMapping("users/add")
    public UserModel addUser(@RequestBody UserModel user) {
        return userService.addUser(user);
    }

    @PutMapping("users/{id}")
    public UserModel updateUser(@PathVariable Integer id, @RequestBody UserModel user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable Integer id) {
        UserModel deletedUser = userService.deleteUser(id);

        return deletedUser == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(deletedUser);
    }

}
