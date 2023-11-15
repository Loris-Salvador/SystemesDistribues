package com.example.injectiondependancesspring.controller;

import com.example.injectiondependancesspring.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjection {

    @Autowired
    public GreetingService service;

    public String sayHello()
    {
        return service.sayHello();
    }

}
