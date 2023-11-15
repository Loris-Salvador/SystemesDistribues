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
