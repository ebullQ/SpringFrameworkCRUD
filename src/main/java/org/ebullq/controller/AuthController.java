package org.ebullq.controller;

import org.ebullq.model.Role;
import org.ebullq.model.User;
import org.ebullq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/auth/login";
    }

    @GetMapping("/registration")
    public String getRegistration(Model model){
        model.addAttribute("user", new User());
        return "/auth/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute User user){
        User checkUser = userService.getUserByLogin(user.getLogin());
        if(checkUser != null){
            return "/auth/registration";
        }
        user.getRoles().add(Role.ROLE_USER);
        userService.saveUser(user);
        return "redirect:/login";
    }

}
