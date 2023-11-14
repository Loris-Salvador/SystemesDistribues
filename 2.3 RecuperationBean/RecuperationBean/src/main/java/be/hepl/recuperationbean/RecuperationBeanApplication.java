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
