package com.example.toystoremvc.controller;

import com.example.toystoremvc.model.Toy;
import com.example.toystoremvc.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ToyController {

    @Autowired
    private ToyService toyService;

    @GetMapping("/toys")
    public String getAllToys(Model model) {
        List<Toy> toys = toyService.getAllToys();
        model.addAttribute("toys", toys);
        return "index";
    }

    @GetMapping("/toys/{id}")
    public String getToy(@PathVariable("id") Long id, Model model) {
        Toy toy = toyService.getToyById(id);
        model.addAttribute("toy", toy);
        return "toyDetail"; // Assuming you will create a toyDetail.html template
    }
}