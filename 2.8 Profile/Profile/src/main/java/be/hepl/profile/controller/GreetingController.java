package be.hepl.profile.controller;

import be.hepl.profile.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    private final GreetingService service;

    public GreetingController(@Qualifier("greetingService")GreetingService service)
    {
        this.service = service;
    }

    public String getMessage()
    {
        return service.sayHello();
    }
}
