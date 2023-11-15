package be.hepl.qualifier.controller;

import be.hepl.qualifier.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerServiceA {

    private final GreetingService greetingService;

    public ControllerServiceA(@Qualifier("greetingServiceA")GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }

    public String getMessage(){
        return greetingService.sayHello();
    }
}
