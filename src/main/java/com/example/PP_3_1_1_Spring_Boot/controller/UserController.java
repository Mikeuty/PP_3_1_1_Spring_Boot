package com.example.PP_3_1_1_Spring_Boot.controller;

import com.example.PP_3_1_1_Spring_Boot.model.User;
import com.example.PP_3_1_1_Spring_Boot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        try {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("tableExists", true);
        } catch (Exception e) {
            model.addAttribute("tableExists", false);
        }
        return "list";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/new";
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PatchMapping()
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @PostMapping("/createTable")
    public String createTable() {
        userService.createUsersTable();
        return "redirect:/users";
    }

    @PostMapping("/dropTable")
    public String dropTable() {
        userService.dropUsersTable();
        return "redirect:/users";
    }

    @PostMapping("/cleanTable")
    public String cleanTable() {
        userService.cleanUsersTable();
        return "redirect:/users";
    }
}
