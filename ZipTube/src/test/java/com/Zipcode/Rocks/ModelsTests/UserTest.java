package com.Zipcode.Rocks.ModelsTests;

import com.Zipcode.Rocks.Models.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;



public class UserTest {
    User user = new User("helloKitty", "H!K!tt3", "Tabitha", "Maroon", "tabbym@aol.com");

//   85% test coverage for class without the following:
//    @Test
//    public void nullaryUserTest(){}
//
//    @Test
//    public void overLoadedUserTest(){
//    }
//
//    @Test
//    public void getUserIdTest() {
//    }
//
//    @Test
//    public void setUserIdTest() {
//    }

    @Test
    public void getUserNameTest() {
        String expected = "helloKitty";
        String actual = user.getUsername();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setUserNameTest() {
        User newUser = new User();
        newUser.setUsername("MaybeLaterGator");
        Assert.assertEquals("MaybeLaterGator", newUser.getUsername());
    }

    @Test
    public void getPasswordTest() {
        String expected = "H!K!tt3";
        String actual = user.getPassword();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setPasswordTest() {
        User newUser = new User();
        newUser.setPassword("U!traSecur3");
        Assert.assertEquals("U!traSecur3", newUser.getPassword());
    }

    @Test
    public void getFirstNameTest() {
        String expected = "Tabitha";
        String actual = user.getFirstName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setFirstNameTest() {
        User newUser = new User();
        newUser.setFirstName("Gary");
        Assert.assertEquals("Gary", newUser.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        String expected = "Maroon";
        String actual = user.getLastName();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setLastNameTest() {
        User newUser = new User();
        newUser.setLastName("Higgins");
        Assert.assertEquals("Higgins", newUser.getLastName());
    }

    @Test
    public void getEmailTest() {
        String expected = "tabbym@aol.com";
        String actual = user.getEmail();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setEmailTest() {
        User newUser = new User();
        newUser.setEmail("larry@aol.com");
        Assert.assertEquals("larry@aol.com", newUser.getEmail());
    }


}
