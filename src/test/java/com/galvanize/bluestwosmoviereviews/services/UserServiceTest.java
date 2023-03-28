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
        userModel = new UserModel(1, "test", "test",
                "test", "test", null, null,null, null);
        when (userRepository.findById(anyInt())).thenReturn(Optional.of(userModel));
        UserModel user = userService.getUserByID(1);
        assertThat(user).isNotNull();
        assertThat(user.getUser_id()).isEqualTo(1);

    }

}