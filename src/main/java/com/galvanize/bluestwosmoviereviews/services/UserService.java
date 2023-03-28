package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.UserRepository;
import com.galvanize.bluestwosmoviereviews.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getUserByID(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

}
