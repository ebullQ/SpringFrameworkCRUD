package org.ebullq.controller;

import org.ebullq.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String main(Authentication authentication,
                       Model model){
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("isAdmin", user.isAdmin());
        return "/main";
    }

}
