/*DEMARRAGE PROJET : Spring initializer : pas de dependance*/

//Meme principe qu'avant sauf que Spring s'en occupe

//Pour ca il faut specifier que le service est un bean avec l'annotation @Service qui etend de @Component pareil pour les controller avec @Controller

//pour l'injection par constructeur pas besoin d'AutoWired (annotation qui fais l'injection) mais par propriete oui

package com.example.injectiondependancesspring.service;

public interface GreetingService {

    String sayHello();
}


package com.example.injectiondependancesspring.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

    @Override
    public String sayHello() {
        return "Hello World";
    }
}


package com.example.injectiondependancesspring.controller;

import com.example.injectiondependancesspring.service.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjection {

    private final GreetingService service;

    public ConstructorInjection(GreetingService service)
    {
        this.service = service;
    }

    public String sayHello()
    {
        return service.sayHello();
    }


}


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


//pour tester on recupere les bean de spring comme 2.3 car vu que @Controller et @Service Spring gere ces beans : 

package com.example.injectiondependancesspring;

import com.example.injectiondependancesspring.controller.ConstructorInjection;
import com.example.injectiondependancesspring.controller.PropertyInjection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InjectionDependancesSpringApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(InjectionDependancesSpringApplication.class, args);

        ConstructorInjection constructorInjection = (ConstructorInjection) ctx.getBean("constructorInjection");

        System.out.println(constructorInjection.sayHello());

        PropertyInjection propertyInjection = (PropertyInjection) ctx.getBean("propertyInjection");

        System.out.println(propertyInjection.sayHello());


    }

}


