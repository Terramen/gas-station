package com.java.gasstation.controller;

import com.java.gasstation.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuelController {
    @Autowired
    private FuelService fuelService;

    @GetMapping("admin/fuel")
    public String viewFuelList(Model model) {
        model.addAttribute("listFuel", fuelService.getAllFuel());
        return "fuel";
    }
}
