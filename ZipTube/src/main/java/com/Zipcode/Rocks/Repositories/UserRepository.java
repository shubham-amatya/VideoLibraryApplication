package com.Zipcode.Rocks.Repositories;

import com.Zipcode.Rocks.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //grants to access to built-in crud repo methods

    Boolean existsByUserName(String username);

    User findUserByUserName(String username);

    User findUserByEmail(String email);

    User findUserByUserId(Long userId);
}
