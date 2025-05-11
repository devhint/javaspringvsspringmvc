package com.example.toystoremvc.service;

import com.example.toystoremvc.model.Toy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToyService {

    private List<Toy> toys = new ArrayList<>();

    public ToyService() {
        // Sample data
        toys.add(new Toy(1, "Teddy Bear", 19.99));
        toys.add(new Toy(2, "Lego Set", 29.99));
        toys.add(new Toy(3, "Action Figure", 14.99));
    }

    public List<Toy> getAllToys() {
        return toys;
    }

    public Toy getToyById(int id) {
        return toys.stream()
                .filter(toy -> toy.getId() == id)
                .findFirst()
                .orElse(null);
    }
}