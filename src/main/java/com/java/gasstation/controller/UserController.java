package com.java.gasstation.controller;

import com.java.gasstation.model.Role;
import com.java.gasstation.model.User;
import com.java.gasstation.service.StationService;
import com.java.gasstation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("admin/users")
    public String viewUserPage(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "user";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user, BindingResult result) {
        UserDetails existing = userService.loadUserByUsername(user.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        userService.saveUsers(user);
        return "redirect:/";
    }

    @PostMapping("/admin/users/adminSaveUser")
    public String adminSaveUser(@ModelAttribute("user") User user) {
        userService.saveAdminUsers(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/users/update/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "update_user";
    }

    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        this.userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


    @GetMapping("/admin")
    public String adminPanel(Model model) {
        return "admin";
    }

}

