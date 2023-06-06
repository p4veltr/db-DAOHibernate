package com.example.dbdaohibernate.controller;

import com.example.dbdaohibernate.model.Person;
import com.example.dbdaohibernate.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class Controller {
    Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping()
    public String get() {
        service.get();
        return "Table filled with demo data. Available cities: Moscow, Kazan";
    }

    @GetMapping("/persons/by-city")
    public List get(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List get(@RequestParam("age") Integer age) {
        return service.getPersonsWithAgeLessThen(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Person> get(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }

}
