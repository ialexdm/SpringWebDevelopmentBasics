package com.geekbrains.geekspringstart.controllers;

import com.geekbrains.geekspringstart.model.dao.repository.UserRepository;
import com.geekbrains.geekspringstart.model.entity.Role;
import com.geekbrains.geekspringstart.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb!=null){
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
