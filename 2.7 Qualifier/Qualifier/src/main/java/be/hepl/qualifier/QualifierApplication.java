package be.hepl.qualifier;

import be.hepl.qualifier.controller.ConstructorController;
import be.hepl.qualifier.controller.PrimaryController;
import be.hepl.qualifier.controller.PropertyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QualifierApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(QualifierApplication.class, args);

        ConstructorController controller1 = (ConstructorController) ctx.getBean("constructorController");
        PrimaryController controller2 = (PrimaryController) ctx.getBean("primaryController");
        PropertyController controller3 = (PropertyController) ctx.getBean("propertyController");

        System.out.println(controller1.getMessage());
        System.out.println(controller2.getMessage());
        System.out.println(controller3.getMessage());



    }

}
