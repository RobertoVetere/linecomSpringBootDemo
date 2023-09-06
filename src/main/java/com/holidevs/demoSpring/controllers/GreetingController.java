package com.holidevs.demoSpring.controllers;
import com.holidevs.demoSpring.models.Greeting;
import com.holidevs.demoSpring.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "name") String name){
        return greetingService.getGreeting(name);
    }
}
