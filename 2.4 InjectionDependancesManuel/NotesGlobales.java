/* DEMARRAGE PROJET : INTELIJ SIMPLE*/

//2 maniere de faire par le constructeur et par propriete

//constructeur mieux car accessible une fois et c'est à l'initialisation, par propriete on peut le dependance peut etre null si on oublie et peut etre changer tout le temps car public (obligatoire...)

//On va injecter un service par constructeur et propriete (tout en faisant de l'inversion de dependances car on passe par un interface( abstractiobn) :) )

package service;

public interface GreetingService {
    String sayHello();
}


package service;

public class ServiceImpl implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello";
    }
}

//constructeur :


package controller;

import service.GreetingService;

public class ConstructorInjected {

    private final GreetingService service;

    public ConstructorInjected(GreetingService service)
    {
        this.service = service;
    }

    public String sayHello()
    {
        return service.sayHello();
    }
}


//propriete : 

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


//////////////

import controller.ConstructorInjected;
import controller.PropertyInjected;
import service.GreetingService;
import service.ServiceImpl;

public class Main {
    public static void main(String[] args) {
        GreetingService service = new ServiceImpl();

        ConstructorInjected constructorInjected = new ConstructorInjected(service);

        PropertyInjected propertyInjected = new PropertyInjected();

        propertyInjected.service = service;
    }
}

//on voit bien qu'on peut acceder a la dependance de n'importe ou et quand on veut par propriete car elle est public donc -bon