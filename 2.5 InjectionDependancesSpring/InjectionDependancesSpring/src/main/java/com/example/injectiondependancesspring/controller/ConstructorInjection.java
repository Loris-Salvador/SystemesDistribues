package com.example.injectiondependancesspring.controller;

import com.example.injectiondependancesspring.service.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjection {

    private final GreetingService service;

    public ConstructorInjection(GreetingService service)
    {
        this.service = service;
    }

    public String sayHello()
    {
        return service.sayHello();
    }


}
