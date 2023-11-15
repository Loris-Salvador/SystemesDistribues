package controller;

import service.GreetingService;

public class ConstructorInjected {

    private final GreetingService service;

    public ConstructorInjected(GreetingService service)
    {
        this.service = service;
    }

    public String sayHello()
    {
        return service.sayHello();
    }
}
