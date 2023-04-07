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

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

     /**
     * Get all users
     * @return Iterable<UserModel> list of all users returned
     * @see UserModel
     * @see UserService
     */
    @GetMapping("users")
    public Iterable<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Get user by id
     * @param id Integer id of user to be returned
     * @return UserModel user with matching id
     * @see UserModel
     * @see UserService
     */
    @GetMapping("users/{id}")
    public ResponseEntity<UserModel> getUserByID(@PathVariable Integer id) {
        UserModel user = userService.getUserByID(id);
        return user == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(user);
    }

    /**
     * Get user by username
     * @param username String username of user to be returned
     * @return UserModel user with matching username
     * @see UserModel
     * @see UserService
     */
    @GetMapping("users/get/{username}")
    public ResponseEntity<UserModel> getUserByUsername(@PathVariable String username) {
        UserModel user = userService.getUserByUsername(username);
        return user == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(user);
    }

    /**
     * Add user
     * @param user UserModel user to be added
     * @return UserModel user added
     * @see UserModel
     * @see UserService
     */
    @PostMapping("users/add")
    public UserModel addUser(@RequestBody UserModel user) {
        return userService.addUser(user);
    }

    /**
     * Update user
     * @param id Integer id of user to be updated
     * @param user UserModel user to be updated
     * @return UserModel user updated
     * @see UserModel
     * @see UserService
     */
    @PutMapping("users/{id}")
    public UserModel updateUser(@PathVariable Integer id, @RequestBody UserModel user) {
        return userService.updateUser(id, user);
    }

    /**
     * Delete user
     * @param id Integer id of user to be deleted
     * @return UserModel user deleted
     * @see UserModel
     * @see UserService
     */
    @DeleteMapping("users/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable Integer id) {
        UserModel deletedUser = userService.deleteUser(id);
        return deletedUser == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(deletedUser);
    }

}
