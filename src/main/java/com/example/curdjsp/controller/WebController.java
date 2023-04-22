package com.example.curdjsp.controller;

import com.example.curdjsp.dao.UserDao;
import com.example.curdjsp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcomePage(ModelMap model, @RequestParam String Email, @RequestParam String password) {
        boolean isValidUser = userDao.validateUser(Email, password);
        if (isValidUser) {
            return "redirect:/welcome";
        }
        model.put("errorMsg", "Please Provide Correct Credential");
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcome() {
        return "welcome";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") String id) {
        userDao.deleteUser(id);
        int count = userDao.count();
        if (count == 0) {
            return "redirect:/login";
        }
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(ModelMap map, @RequestParam("id") String id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            map.put("user", user);
            return "update";
        }
        map.put("errorMsg", "User Not Found");
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user, ModelMap map) {
        userDao.addUser(user);
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String signup(ModelMap model) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, ModelMap model) {
        System.out.println("user = " + user);
        boolean isNewUser = userDao.isNewUser(user.getEmail());
        if (!isNewUser) {
            model.put("errorMsg", "Email already exist");
            return "register";
        }
        userDao.addUser(user);
        model.put("errorMsg", "Success");
        return "redirect:/login";
    }
}
