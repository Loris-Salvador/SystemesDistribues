package com.example.webservicespring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    static final String REQUEST_PATH_V1 = "/api/v1/hello";
    static final String REQUEST_PATH_V2 = "/api/v2/hello";
    static final String REQUEST_PATH_V3 = "/api/v3/hello";

    @GetMapping(REQUEST_PATH_V1)
    public ResponseEntity<String> sayHello(@RequestParam(name = "name", required = false) String name) {
        if (name == null || name.isEmpty()) {
            return ResponseEntity.badRequest().body("Le paramètre 'name' est obligatoire.");
        }
        return ResponseEntity.ok("Hello " + name);
    }

    @GetMapping(REQUEST_PATH_V2)
    public ResponseEntity<Message> sayHelloMessage(@RequestParam(name = "name", required = false) String name) {
        if (name == null || name.isEmpty()) {
            return ResponseEntity.badRequest().body(new Message("Le paramètre 'name' est obligatoire."));
        }
        String message = "Hello " + name;
        return ResponseEntity.ok(new Message(message));
    }

    @PostMapping(REQUEST_PATH_V3)
    public ResponseEntity<Message> sayHello(@RequestBody User user) {
        if (user == null || user.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(new Message("User dans le message body obligatoire."));
        }
        String message = "Hello " + user.getName();
        return ResponseEntity.ok(new Message(message));
    }
}