/*DEMARRAGE PROJET : SPRING INITIALIZER PAS DE DEPENDANCES*/

/*on montre l'utilisation de qualifier imaginons un controller a besoid d'une dependance
vers un service (interface) si plusieurs classes implementent l'interface lequel va etre choisis par Spring?
2 maniere : soit on met annotation @Primary sur l'implementation qu'on veut prioriser soit avec des qualifier pour preciser
exactement lequel on veut */

package be.hepl.qualifier.service;

public interface GreetingService {

    String sayHello();
}



package be.hepl.qualifier.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceA implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello From Service A";
    }
}



package be.hepl.qualifier.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceB implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello from Service B";
    }
}




package be.hepl.qualifier.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryService implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello from Primary service";
    }
}






package be.hepl.qualifier.controller;

import be.hepl.qualifier.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerServiceA {

    private final GreetingService greetingService;

    public ControllerServiceA(@Qualifier("greetingServiceA")GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }

    public String getMessage(){
        return greetingService.sayHello();
    }
}





package be.hepl.qualifier.controller;

import be.hepl.qualifier.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerServiceB {

    private final GreetingService greetingService;

    public ControllerServiceB(@Qualifier("greetingServiceB")GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }

    public String getMessage(){
        return greetingService.sayHello();
    }
}






package be.hepl.qualifier.controller;

import be.hepl.qualifier.service.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerPrimary {

    private final GreetingService greetingService;

    public ControllerPrimary(GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }

    public String getMessage(){
        return greetingService.sayHello();
    }
}





//test en recuperant les bean

package be.hepl.qualifier;

import be.hepl.qualifier.controller.ControllerPrimary;
import be.hepl.qualifier.controller.ControllerServiceA;
import be.hepl.qualifier.controller.ControllerServiceB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QualifierApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(QualifierApplication.class, args);

        ControllerPrimary controllerPrimary = (ControllerPrimary) ctx.getBean("controllerPrimary");
        System.out.println(controllerPrimary.getMessage());

        ControllerServiceA controllerServiceA = (ControllerServiceA) ctx.getBean("controllerServiceA");
        System.out.println(controllerServiceA.getMessage());

        ControllerServiceB controllerServiceB = (ControllerServiceB) ctx.getBean("controllerServiceB");
        System.out.println(controllerServiceB.getMessage());
    }

}



// on se rend compte que quand on ne met pas de qualifier dans un controlleur il va chercher l'implementation avec @Primary
//et que quad on met des qualifier il va chercher l'implementation donc le nom correspond au nom de classe (Attention premiere lettre minuscule avec qualifier)
