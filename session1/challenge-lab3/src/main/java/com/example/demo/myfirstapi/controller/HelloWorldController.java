package com.example.demo.myfirstapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController // Marks this class as a REST controller
public class HelloWorldController {

    @Value("${app.greeting.message}")
    private String customGreeting;

    @GetMapping("/hello") // Maps HTTP GET requests to the "/hello" URL
    public String sayHello() {
        return customGreeting;
        //return "Hello, Spring Boot gitLearners!";
    }

    @GetMapping("/greet/{name}") // This path now expects a dynamic 'name' part
    public String greetUser(@PathVariable String name) { // @PathVariable maps the URL part to this parameter
        return "Greetings, " + name + "!";
    }

    @GetMapping("/greeting")
    public String greetWithParam(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
    @GetMapping("/sum")
    public String sumWithParam(@RequestParam(value="int1") int int1, @RequestParam(value="int2") int int2) {
        int sum = int1 + int2;
        return "The sum of " + int1 + " and " + int2 + " is " + sum + ".";
    }

    @GetMapping("/info")
    public Map<String, String> getAppInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("appName", "MyFirstAPIDemo");
        info.put("version", "1.0.0");
        info.put("status", "running");
        return info;
    }

    @GetMapping("/features")
    public List<String> getFeature() {
        return Arrays.asList("REST API", "Spring Boot", "Fast Development");
    }
}

