/*DEMARRAGE PROJET : SPRING INITIALIZER DEPENDANCES THYMELEAF + WEB */

/*on montre l'utilisation component scan l'annotation SpringBootApplication fait deja un componenetScan fais seulement 
dans le package et sous package dans lequel il se trouve donc si on a d'autre bean ou config autre part il faut specifier ou ils sont*/

//voir projet pour l'architecture 

//classe config

package config;

import be.hepl.componentscan.model.MessageGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MessageGenerator messageGenerator()
    {
        return new MessageGenerator();
    }
}

//on annote avec Configuration pour specifier a spring que cette classe peut etre source de bean et don il va instancier un Message genrator qui sera utiliser des le service

//service

package service;

public interface MessageService { //toujours inversion dependance :)
    String getMessage();
}

package service;

import be.hepl.componentscan.model.MessageGenerator;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageGenerator messageGenerator;
    public MessageServiceImpl(MessageGenerator messageGenerator)
    {
        this.messageGenerator = messageGenerator;
    }
    @Override
    public String getMessage() {
        return messageGenerator.generateMessage();
    }
}


//avec annotation service qui etend de Component spring va initaliser Service et va automiquement vers la DI dans le constructeur (donc pas besoin AutoWired)

//Controller

package be.hepl.componentscan.controller;

import be.hepl.componentscan.model.MessageGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MessageService;

@Controller
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService)
    {
        this.messageService = messageService;
    }

    @GetMapping("/servicemessage")
    public String getMessage(Model model)
    {
        model.addAttribute("message", messageService.getMessage());
        return "view";
    }

}


//Pareill que Service annotation Controller etend de Component donc spring instancie

//html que renvoie le controller et donc on modifie l'attribut message dans le html dans le controller grace a thymeleaf qui permet des template

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Cool Message</title>
</head>
<body>
<p th:text="'Message  : ' + ${message}" />
</body>
</html>


//Enfin on specifie ou Spring doit chercher des Component (donc soit @Service, @Controller, @Component etc) ou des beans venant d'une classe @Configuration

package be.hepl.componentscan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"config", "service", "be.hepl.componentscan"})
public class ComponentScanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponentScanApplication.class, args);
    }

}


//si pas de component scan alors spring va instancier le controlleur puis va essayer d'instancier le service car le controlleur en a besoin mais ne va pas le trouver car pas dans meme package/sous package