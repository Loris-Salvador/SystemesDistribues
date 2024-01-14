package be.hepl.artemis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class ArtemisApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ArtemisApplication.class, args);

        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");

        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
    }

}
