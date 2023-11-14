/* DEMARRAGE PROJET : spring intializer et ajouter dependances web*/


//Ajouter un record

package com.example.restservice;

public record Greeting(long id, String content) { }

/*Un record est une classe imuable (ces donnees ne peuvent etre modifie et on ne peux pas en heriter) mais elle comporte des avantages : 

-Elle est serializable
-Elle est parsable en Json (parfait pour le projet)
-getter deja fournis
-ToString fournis
-etc*/

//Controller

package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}

/*

@RequestParam permet de pouvoir rentrer des parametre dans l'url (?<nom param>=<value>) ici la valeur se mettra dans name
