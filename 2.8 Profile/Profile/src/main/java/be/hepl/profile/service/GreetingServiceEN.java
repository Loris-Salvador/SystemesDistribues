package be.hepl.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("greetingService")
public class GreetingServiceEN implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello";
    }
}
