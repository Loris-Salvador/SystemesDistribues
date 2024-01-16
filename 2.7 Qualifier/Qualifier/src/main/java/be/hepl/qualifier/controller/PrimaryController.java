package be.hepl.qualifier.controller;

import be.hepl.qualifier.service.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class PrimaryController {
    private final GreetingService greetingService;

    public PrimaryController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    public String getMessage(){
        return greetingService.message();
    }
}
