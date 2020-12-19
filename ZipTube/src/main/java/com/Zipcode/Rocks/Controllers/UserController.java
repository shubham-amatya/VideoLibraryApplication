package com.Zipcode.Rocks.Controllers;

import com.Zipcode.Rocks.Models.User;
import com.Zipcode.Rocks.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("user/adduser")
    public ResponseEntity<User> addUser(@RequestBody User user){return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);}

    @DeleteMapping("delete/{userID}")
    public void deleteUserById(@PathVariable Long userID){userService.deleteUserByUserId(userID);}

    @DeleteMapping("delete/{userName}")
    public void deleteUserByUserName(@PathVariable String userName){userService.deleteUserByUserName(userName);}

    @GetMapping("user/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName){return new ResponseEntity<>(userService.getUserByUserName(userName), HttpStatus.OK);}

    @GetMapping("user/{email}")
    public ResponseEntity<User> getUserByUserEmail(@PathVariable String email){return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);}

    @PutMapping("user/{username}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String username) {
        return new ResponseEntity<>(userService.putUserUpdate(username, user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName()), HttpStatus.OK);
    }
}
