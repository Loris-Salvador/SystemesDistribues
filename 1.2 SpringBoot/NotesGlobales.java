/* DEMARRAGE PROJET : spring intializer et ajouter dependances web*/

//Ajouter controller

package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}

/*

@RestController : combinaise de l'annotation controller + responbody car on veut renvoyer des data plutot qu'une vue
@GetMapping : declinaison de RequestMapping qui pourrais etre utilise (@RequestMapping(value = GET, path = "/hello"))

*/

//APPLICATION

package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}

/*

@SpringBootApplication : combinaison de 3 chose : 
	
	-@EnableAutoConfig : dit a spring d'aller chercher des beans dans le classpath
	-Configuration : indique a spring que cette classes peut etre source de bean
	-ComponentScan : indique a spring de chercher des config dans un package et ses sous-packages

@Bean : indique a spring que cette methode retourne un bean qui sera gerer par Spring

CommandLineRunner est une interface qui implement une methode run et vu qu'on renvoie un bean et que SpringApplication est une configuration Spring va lancer cette methode run au demarrage

*/


// run l'application : mvn spring-boot:run