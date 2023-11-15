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
