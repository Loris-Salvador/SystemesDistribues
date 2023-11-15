/*DEMARRAGE PROJET : SPRING INITIALIZER SANS DEPENDANCE*/

/*ici on va montrer l'utilite du profile qui serait utile par exemple si on avait plein de services differents selon les langues
à la place de changer chaque fois le nom du service dans le qualifier des controller on utilise Profile */

package be.hepl.profile.service;

public interface GreetingService {

    String sayHello();
}




package be.hepl.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("FR")
@Service("greetingService")
public class GreetingServiceFR implements GreetingService{
    @Override
    public String sayHello() {
        return "Bonjour";
    }
}



package be.hepl.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("greetingService")
public class GreetingServiceEN implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello";
    }
}




package be.hepl.profile.controller;

import be.hepl.profile.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    private final GreetingService service;

    public GreetingController(@Qualifier("greetingService")GreetingService service)
    {
        this.service = service;
    }

    public String getMessage()
    {
        return service.sayHello();
    }
}


//on voit ici que que les deux bean on le meme nom et donc ne sont differenciés que par le profile


//properties : 

spring.profiles.active=EN

//test :


package be.hepl.profile;

import be.hepl.profile.controller.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProfileApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(ProfileApplication.class, args);

        GreetingController controller = (GreetingController) ctx.getBean("greetingController");
        System.out.println(controller.getMessage());
    }

}

