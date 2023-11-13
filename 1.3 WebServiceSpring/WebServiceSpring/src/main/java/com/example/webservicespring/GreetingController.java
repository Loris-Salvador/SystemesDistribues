package com.example.webservicespring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = GET, path = "/greetings")
    public Greeter greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeter(counter.incrementAndGet(), String.format(template, name));
    }


}