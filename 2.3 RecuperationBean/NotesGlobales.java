/*DEMARRAGE PROJET : Spring Initializer (pas de dependance)*/

//une ligne a reteneir 
aController controller = (aController) ctx.getBean("aController");

//attention peut importe la classe le nom en param de getBean commence par une minuscule
	
//ctx est le context  qui permet de savoir tout les bean utilisés par spring (conteneur de bean)

//classes au cas ou

package be.hepl.recuperationbean;

import be.hepl.recuperationbean.Controller.aController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RecuperationBeanApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(RecuperationBeanApplication.class, args);

        aController controller = (aController) ctx.getBean("aController");

        System.out.println(controller.sayHello());


    }

}


package be.hepl.recuperationbean.Controller;

import org.springframework.stereotype.Controller;

@Controller
public class aController {
    public String sayHello()
    {
        return "hello";
    }
}


//annotation Controller importante car elle extend de component qui specifie que c'est un bean

