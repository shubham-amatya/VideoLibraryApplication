package com.Zipcode.Rocks.Services;

import com.Zipcode.Rocks.Models.User;
import com.Zipcode.Rocks.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //uses methods from User Repository to access, create, and edit Users in the repository

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        if (user.getUsername().equals(getCheckUserNameExists(user.getUsername())) || (user.getEmail().equals(getCheckUserEmailExists(user.getEmail())))){
            return null;
            // Have method listening for null on front end
            // if null returned, notify user they have to try again
        }
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
        if (user.getEmail().equals(getCheckUserEmailExists(user.getEmail()))){
            return null;
            // Have method listening for null on front end
            // if null returned, notify user they have to try again
        }
        return userRepository.save(user);
    }

    public String getCheckUserNameExists(String username){
        if (userRepository.findUserByUserName(username) != null){
            return username;
        }
        return "DOES NOT EXIST";
    }

    public String getCheckUserEmailExists(String email){
        if (userRepository.findUserByEmail(email) != null){
            return email;
        }
        return "DOES NOT EXIST";
    }
}
