package controller;

import service.GreetingService;

public class PropertyInjected {

    public GreetingService service;

    public GreetingService getGreetingService()
    {
        return this.service;
    }

    public String sayHello()
    {
        return service.sayHello();
    }

}
