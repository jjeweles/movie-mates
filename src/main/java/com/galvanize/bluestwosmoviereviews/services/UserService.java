package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.UserRepository;
import com.galvanize.bluestwosmoviereviews.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getUserByID(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserModel addUser(UserModel user) {
        return userRepository.save(user);
    }

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

    public UserModel deleteUser(Integer id) {
        UserModel userToDelete = userRepository.findById(id).orElse(null);

        if (userToDelete != null) {
            userRepository.delete(userToDelete);
        }

        return userToDelete;
    }

    public UserModel getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Iterable<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
}
