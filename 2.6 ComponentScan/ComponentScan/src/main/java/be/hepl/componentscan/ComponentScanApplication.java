package be.hepl.componentscan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"config", "service", "be.hepl.componentscan"})
public class ComponentScanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponentScanApplication.class, args);
    }

}
