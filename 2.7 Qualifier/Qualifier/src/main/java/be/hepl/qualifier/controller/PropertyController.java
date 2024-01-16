package be.hepl.qualifier.controller;

import be.hepl.qualifier.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyController {

    @Qualifier("propertyService")
    @Autowired
    private GreetingService greetingService;



    public String getMessage(){
        return greetingService.message();
    }
}
