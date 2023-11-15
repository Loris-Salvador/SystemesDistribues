package be.hepl.qualifier.controller;

import be.hepl.qualifier.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerServiceB {

    private final GreetingService greetingService;

    public ControllerServiceB(@Qualifier("greetingServiceB")GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }

    public String getMessage(){
        return greetingService.sayHello();
    }
}
