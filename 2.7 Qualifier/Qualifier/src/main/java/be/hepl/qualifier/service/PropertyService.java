package be.hepl.qualifier.service;

import org.springframework.stereotype.Service;

@Service
public class PropertyService implements GreetingService{
    @Override
    public String message() {
        return "property service";
    }
}
