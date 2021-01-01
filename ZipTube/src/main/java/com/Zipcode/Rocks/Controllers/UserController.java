package com.Zipcode.Rocks.Controllers;

import com.Zipcode.Rocks.JWT.ValidationException;
import com.Zipcode.Rocks.Models.User;
import com.Zipcode.Rocks.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Zipcode.Rocks.Models.User;
import com.Zipcode.Rocks.Repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
public class UserController{
    final
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


//    private HashData hashData = new HashData();

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/user")
    public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
        String username = body.get("username");
        if (userRepository.existsByUserName(username)){

            throw new ValidationException("Username already existed");

        }

        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
//        String hashedPassword = hashData.get_SHA_512_SecurePassword(password);
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String email = body.get("email");
        userRepository.save(new User(username, encodedPassword, firstName, lastName, email));
        return true;
    }


    @DeleteMapping("deleteuserbyid/{userID}")
    public void deleteUserById(@PathVariable Long userID){userService.deleteUserByUserId(userID);}

    @DeleteMapping("deleteuserbyusername/{userName}")
    public void deleteUserByUserName(@PathVariable String userName){userService.deleteUserByUserName(userName);}

    @GetMapping("user/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName){return new ResponseEntity<>(userService.getUserByUserName(userName), HttpStatus.OK);}

    @GetMapping("user/{email}")
    public ResponseEntity<User> getUserByUserEmail(@PathVariable String email){return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);}

    @PutMapping("user/{userName}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userName) {
        return new ResponseEntity<>(userService.putUserUpdate(userName, user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName()), HttpStatus.OK);
    }
}
