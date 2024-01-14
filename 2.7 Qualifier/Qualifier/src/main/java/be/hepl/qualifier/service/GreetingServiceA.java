package be.hepl.qualifier.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("FR")
@Service("serviceA")
public class GreetingServiceA implements GreetingService{
    @Override
    public String sayHello() {
        return "Bonjour From Service A";
    }
}
