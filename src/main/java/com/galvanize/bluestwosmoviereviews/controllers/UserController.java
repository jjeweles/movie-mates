package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.UserModel;
import com.galvanize.bluestwosmoviereviews.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing user operations.
 * <p>
 * The {@code UserController} class handles HTTP requests for operations such as
 * creating, updating, retrieving, and deleting users.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserService userService;

     /** Constructs a new {@code UserController} with the specified {@code UserService}.
            *
            * @param userService the user service used to perform user-related operations
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users.
     *
     * @return an {@code Iterable} containing all {@code UserModel} instances
     */
    @GetMapping("users")
    public Iterable<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return a {@code ResponseEntity} containing the requested {@code UserModel} instance if found,
     *         or an empty {@code ResponseEntity} with a no-content status if not found
     */
    @GetMapping("users/{id}")
    public ResponseEntity<UserModel> getUserByID(@PathVariable Integer id) {
        UserModel user = userService.getUserByID(id);
        return user == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(user);
    }

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user to retrieve
     * @return a {@code ResponseEntity} containing the requested {@code UserModel} instance if found,
     *         or an empty {@code ResponseEntity} with a no-content status if not found
     */
    @GetMapping("users/get/{username}")
    public ResponseEntity<UserModel> getUserByUsername(@PathVariable String username) {
        UserModel user = userService.getUserByUsername(username);
        return user == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(user);
    }

    /**
     * Creates a new user.
     *
     * @param user the {@code UserModel} instance to create
     * @return the created {@code UserModel} instance
     */
    @PostMapping("users/add")
    public UserModel addUser(@RequestBody UserModel user) {
        return userService.addUser(user);
    }

    /**
     * Updates an existing user.
     *
     * @param id   the ID of the user to update
     * @param user the {@code UserModel} instance containing the updated data
     * @return the updated {@code UserModel} instance
     */
    @PutMapping("users/{id}")
    public UserModel updateUser(@PathVariable Integer id, @RequestBody UserModel user) {
        return userService.updateUser(id, user);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to delete
     * @return a {@code ResponseEntity} containing the deleted {@code UserModel} instance if found,
     *         or an empty {@code ResponseEntity} with a no-content status if not found
     */
    @DeleteMapping("users/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable Integer id) {
        UserModel deletedUser = userService.deleteUser(id);
        return deletedUser == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(deletedUser);
    }

}
