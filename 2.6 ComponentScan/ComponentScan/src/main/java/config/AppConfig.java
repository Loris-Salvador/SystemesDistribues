package config;

import be.hepl.componentscan.model.MessageGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MessageGenerator messageGenerator()
    {
        return new MessageGenerator();
    }
}
