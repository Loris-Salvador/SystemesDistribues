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
