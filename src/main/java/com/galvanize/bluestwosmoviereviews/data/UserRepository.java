package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for the User model
 * @see UserModel
 * @see JpaRepository
 * @see Repository
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findById(Integer id);

    UserModel findByUsername(String username);
}
