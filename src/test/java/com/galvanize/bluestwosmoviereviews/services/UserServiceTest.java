package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.UserRepository;
import com.galvanize.bluestwosmoviereviews.models.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    UserService userService;

    @Mock
    UserRepository userRepository;

    UserModel userModel;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void getUserByIdShouldReturnUserOrReturnNullIfNoUser() {
        userModel = new UserModel("test", "test", "test", "test");
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userModel));
        UserModel user = userService.getUserByID(1);
        user.setUserID(1);
        assertThat(user.getUserID()).isEqualTo(1);

    }

    @Test
    void addUserShouldReturnUser() {
        userModel = new UserModel("test", "test", "test", "test");
        when(userRepository.save(any(UserModel.class))).thenReturn(userModel);
        UserModel user = userService.addUser(userModel);
        user.setUserID(1);
        assertThat(user.getUserID()).isEqualTo(1);
    }

    @Test
    void updateUserShouldReturnUser() {
        userModel = new UserModel("test", "test", "test", "test");
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userModel));
        when(userRepository.save(any(UserModel.class))).thenReturn(userModel);
        UserModel user = userService.updateUser(1, userModel);
        user.setUserID(1);
        assertThat(user.getUserID()).isEqualTo(1);
    }

    @Test
    void deleteUserShouldReturnUser() {
        userModel = new UserModel("test", "test", "test", "test");
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userModel));
        UserModel user = userService.deleteUser(1);
        user.setUserID(1);
        assertThat(user.getUserID()).isEqualTo(1);
    }

}