package be.hepl.qualifier.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceA implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello From Service A";
    }
}
