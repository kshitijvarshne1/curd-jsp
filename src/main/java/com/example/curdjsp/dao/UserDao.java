/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 22-Apr-23
 *   Time: 12:03 AM
 *   File: UserDao.java
 */

package com.example.curdjsp.dao;

import com.example.curdjsp.entity.User;
import com.example.curdjsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    @Autowired
    private UserRepository userRepository;

    public String addUser(User user) {
        userRepository.save(user);
        return "User Added Successfully";
    }

    public boolean validateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public int count() {
        return (int) userRepository.count();
    }

    public boolean isNewUser(String email) {
        User user = userRepository.findByEmail(email);
        return user == null;
    }

    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }
}

