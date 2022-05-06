package com.bridgelabz.greetingMessage.controller;

import com.bridgelabz.greetingMessage.entity.Greeting;
import com.bridgelabz.greetingMessage.entity.User;
import com.bridgelabz.greetingMessage.service.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService iGreetingService;

    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return iGreetingService.addGreeting(user);
    }
}
