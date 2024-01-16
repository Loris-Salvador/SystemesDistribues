package be.hepl.qualifier.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryService implements GreetingService{
    @Override
    public String message() {
        return "primary Service";
    }
}
