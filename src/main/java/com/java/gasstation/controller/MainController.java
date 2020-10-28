package com.java.gasstation.controller;

import com.java.gasstation.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;


@Controller
public class MainController {
    @Autowired
    private FuelService fuelService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        Date date = new Date(System.currentTimeMillis());
        model.addAttribute("listFuel", fuelService.getAllFuel());
        model.addAttribute("date", date);
        return "index";
    }
}
