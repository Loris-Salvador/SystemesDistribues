package be.hepl.qualifier.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("serviceA")
public class GreetingServiceB implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello from Service B";
    }
}
