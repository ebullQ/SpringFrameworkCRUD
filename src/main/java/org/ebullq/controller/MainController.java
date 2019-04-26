package org.ebullq.controller;

import org.ebullq.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String main(Authentication authentication,
                       Model model){
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user",user);
        return "/main";
    }

    @GetMapping("/denied")
    public String denied(Model model,
            Authentication authentication){
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user",user);
        return "/denied";
    }


}
