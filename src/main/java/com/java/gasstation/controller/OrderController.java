package com.java.gasstation.controller;

import com.java.gasstation.model.Fuel;
import com.java.gasstation.model.Order;
import com.java.gasstation.model.User;
import com.java.gasstation.service.FuelService;
import com.java.gasstation.service.OrderService;
import com.java.gasstation.service.StationService;
import com.java.gasstation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private FuelService fuelService;

    @Autowired
    private StationService stationService;

    @Autowired
    private UserService userService;

    @GetMapping("/personalAccount/newOrder")
    public String newOrder(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        model.addAttribute("listStations", stationService.getAllStations());
        model.addAttribute("listFuel", fuelService.getAllFuel());
        model.addAttribute("auth", userService.getAuthenticatedUser());
        return "new_order";
    }

    @GetMapping("/personalAccount/error")
    public String viewPersonalAccountPage(Model model) {
        return "pa_error";
    }

    @PostMapping("/personalAccount/saveOrder")
    public String saveOrder(@ModelAttribute("order") Order order) {
        if(order.getFuel().getCount() > order.getCount()) {
            orderService.saveOrder(order, order.getFuel());
            return "redirect:/personalAccount";
        }
        else {
            return "redirect:/personalAccount/error";
        }
    }

    @GetMapping("/admin/orders")
    public String viewAdminOrders(Model model) {
        model.addAttribute("listOrders", orderService.getAllOrders());
        return "order";
    }
}
