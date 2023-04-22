/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 21-Apr-23
 *   Time: 12:47 AM
 *   File: RestController.java
 */

package com.example.curdjsp.controller;


import com.example.curdjsp.dao.UserDao;
import com.example.curdjsp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/check")
    public ResponseEntity check() {
        return new ResponseEntity("Hello", HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user) {
        String response= userDao.addUser(user);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}

