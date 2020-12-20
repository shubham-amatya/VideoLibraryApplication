package com.Zipcode.Rocks.Repositories;

import com.Zipcode.Rocks.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //grants to access to built-in crud repo methods

    User findUserByUserName(String username);

    User findUserByEmail(String email);

    User findUserByUserId(Long userId);
}
