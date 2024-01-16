package be.hepl.qualifier.service;

import org.springframework.stereotype.Service;

@Service
public class ConstructorService implements GreetingService{
    @Override
    public String message() {
        return "constructor service";
    }
}
