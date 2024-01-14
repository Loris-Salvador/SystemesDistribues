package be.hepl.qualifier;

import be.hepl.qualifier.controller.ControllerServiceA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QualifierApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(QualifierApplication.class, args);

        ControllerServiceA controllerServiceA = (ControllerServiceA) ctx.getBean("controllerServiceA");
        System.out.println(controllerServiceA.getMessage());

    }

}
