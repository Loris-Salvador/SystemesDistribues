package be.hepl.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("FR")
@Service("greetingService")
public class GreetingServiceFR implements GreetingService{
    @Override
    public String sayHello() {
        return "Bonjour";
    }
}
