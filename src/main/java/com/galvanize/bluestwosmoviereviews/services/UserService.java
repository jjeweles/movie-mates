package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.UserRepository;
import com.galvanize.bluestwosmoviereviews.models.UserModel;
import org.springframework.stereotype.Service;

/**
 * Provides user-related services using a {@code UserRepository}.
 * <p>
 * The {@code UserService} class handles operations such as creating, updating, retrieving, and
 * deleting users using a {@code UserRepository} instance.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    /**
     * Constructs a new {@code UserService} with the specified {@code UserRepository}.
     *
     * @param userRepository the repository used to perform user-related operations
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return the {@code UserModel} instance with the specified ID, or {@code null} if not found
     */
    public UserModel getUserByID(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new user.
     *
     * @param user the {@code UserModel} instance to create
     * @return the created {@code UserModel} instance
     */
    public UserModel addUser(UserModel user) {
        return userRepository.save(user);
    }

    /**
     * Updates an existing user.
     *
     * @param id   the ID of the user to update
     * @param user the {@code UserModel} instance containing the updated data
     * @return the updated {@code UserModel} instance
     */
    public UserModel updateUser(Integer id, UserModel user) {
        UserModel userToUpdate = userRepository.findById(id).orElse(null);

        if (userToUpdate != null) {
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setName(user.getName());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setUsername(user.getUsername());
        }

        assert userToUpdate != null;
        return userRepository.save(userToUpdate);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to delete
     * @return the deleted {@code UserModel} instance, or {@code null} if not found
     */
    public UserModel deleteUser(Integer id) {
        UserModel userToDelete = userRepository.findById(id).orElse(null);

        if (userToDelete != null) {
            userRepository.delete(userToDelete);
        }

        return userToDelete;
    }

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user to retrieve
     * @return the {@code UserModel} instance with the specified username, or {@code null} if not found
     */
    public UserModel getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Retrieves all users.
     *
     * @return an {@code Iterable} containing all {@code UserModel} instances
     */
    public Iterable<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
}
