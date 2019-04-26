package org.ebullq.controller;

import org.ebullq.dao.RoleDao;
import org.ebullq.model.Role;
import org.ebullq.model.User;
import org.ebullq.service.RoleService;
import org.ebullq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;

    @GetMapping
    public String admin(Model model,
                        Authentication authentication){
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user",user);
        model.addAttribute("users",userService.getAllUsers());
        return "/admin";
    }

    @GetMapping("/add")
    public String getAddUser(Model model){
        model.addAttribute("user", new User());
        return "/admin/add";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user){
        user.getRoles().add(roleService.getRoleByName("ROLE_USER"));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateUser(@PathVariable("id") Integer id,
                             Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("roles", User.getRolesAsStringNames(user.getRoles()));
        model.addAttribute("allRoles", User.getRolesAsStringNames(roleService.getAllRoles()));
        return "/admin/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") Integer id,
                             @RequestParam Map<String, String> map,
                             @ModelAttribute User user){
        Set<String> roles = User.getRolesAsStringNames(roleService.getAllRoles());
        user.getRoles().clear();
        for (String key : map.keySet()) {
             if(roles.contains(key))
                 user.getRoles().add(roleService.getRoleByName(key));
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }


}
