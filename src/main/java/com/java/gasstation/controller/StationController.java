package com.java.gasstation.controller;

import com.java.gasstation.model.Station;
import com.java.gasstation.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/list")
    public String viewList(Model model) {
        model.addAttribute("listStations", stationService.getAllStations());
        return "list";
    }

    @GetMapping("/admin/list")
    public String viewAdminList(Model model) {
        model.addAttribute("listStations", stationService.getAllStations());
        return "admin_list";
    }

    @PostMapping("/admin/list/saveStation")
    public String saveStation(@ModelAttribute("user") Station station) {
        stationService.saveStations(station);
        return "redirect:/admin/list";
    }

    @GetMapping("/admin/list/update/{id}")
    public String showStationFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Station station = stationService.getStationById(id);
        model.addAttribute("station",station);
        return "update_station";
    }

    @GetMapping("/admin/list/delete/{id}")
    public String deleteStation(@PathVariable(value = "id") Long id) {
        this.stationService.deleteStationById(id);
        return "redirect:/admin/list";
    }

    @GetMapping("/admin/list/addStation")
    public String addStation(Model model) {
        Station station = new Station();
        model.addAttribute("station", station);
        return "add_station";
    }
}
