package com.bridgelabz.greetingMessage.service;

import com.bridgelabz.greetingMessage.entity.Greeting;
import com.bridgelabz.greetingMessage.entity.User;
import com.bridgelabz.greetingMessage.repository.IGreetingRepository;
import com.bridgelabz.greetingMessage.service.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceimpl implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingRepository greetingRepository;


    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
    }

    public Greeting getGreetingById(long id){
        return greetingRepository.findById(id).get();
    }
}