package com.coronavirustracker.workshop.controllers;

import com.coronavirustracker.workshop.services.CoronaVirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusService coronaVirusService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("LocationStats", coronaVirusService.getAllStats());
        return "index";
    }
}
