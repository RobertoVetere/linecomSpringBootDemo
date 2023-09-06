package com.holidevs.demoSpring.services;

import com.holidevs.demoSpring.models.Greeting;
import com.holidevs.demoSpring.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    GreetingRepository greetingRepository;

    public Greeting getGreeting(String name) {
        String template = "Hola %s";
        return new Greeting(String.format(template,name));
    }
}
