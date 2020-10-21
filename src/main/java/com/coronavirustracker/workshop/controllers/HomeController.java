package com.coronavirustracker.workshop.controllers;

import com.coronavirustracker.workshop.models.LocationStats;
import com.coronavirustracker.workshop.services.CoronaVirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusService coronaVirusService;

    @GetMapping("/")
    public String index(Model model) {
        List<LocationStats> allStats = coronaVirusService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);

        return "index";
    }
}
