package com.java.gasstation.controller;

import com.java.gasstation.model.User;
import com.java.gasstation.service.FuelService;
import com.java.gasstation.service.OrderService;
import com.java.gasstation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;


@Controller
public class MainController {
    @Autowired
    private FuelService fuelService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        Date date = new Date(System.currentTimeMillis());
        model.addAttribute("listFuel", fuelService.getAllFuel());
        model.addAttribute("date", date);
        return "index";
    }

    @GetMapping("/personalAccount")
    public String viewPersonalAccountPage(Model model) {
        model.addAttribute("listOrders", orderService.getOrdersByUserId(userService.getAuthenticatedUser().get().getId()));
        model.addAttribute("auth", userService.getAuthenticatedUser());
        return "personal_account";
    }
}
