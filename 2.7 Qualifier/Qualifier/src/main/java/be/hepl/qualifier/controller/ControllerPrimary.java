package be.hepl.qualifier.controller;

import be.hepl.qualifier.service.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerPrimary {

    private final GreetingService greetingService;

    public ControllerPrimary(GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }

    public String getMessage(){
        return greetingService.sayHello();
    }
}
