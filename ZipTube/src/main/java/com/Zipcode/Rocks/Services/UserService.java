package com.Zipcode.Rocks.Services;

import com.Zipcode.Rocks.Models.User;
import com.Zipcode.Rocks.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserByUserName(String username){
        userRepository.delete(getUserByUserName(username));
    }

    public void deleteUserByUserId(Long userId){
        userRepository.delete(getUserByUserId(userId));
    }

    public User getUserByUserId(Long userId){
        return userRepository.findUserByUserId(userId);
    }

    public User getUserByUserName(String username){
        return userRepository.findUserByUserName(username);
    }

    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

//    public User putUserUpdate(Long userId){
//        User user = getUserByUserId(userId);
//        if (user != null){
//            User newUser
//        }
//    }

    public User putUserUpdate(String username, String password, String email, String firstName, String lastName){
        Long id = getUserByUserName(username).getUserId();
        User user = getUserByUserId(id);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return userRepository.save(user);
    }

    public User getCheckUserNameExists(String username){
//        if (userRepository.findUserByUserName(username) != null){
//            return userRepository.findUserByUserName(username);
//        }
        return null;
    }

    public User getCheckUserEmailExists(String email){
        return null;
    }
}
