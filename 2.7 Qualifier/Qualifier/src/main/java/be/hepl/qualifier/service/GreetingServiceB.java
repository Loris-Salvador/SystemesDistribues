package be.hepl.qualifier.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceB implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello from Service B";
    }
}
