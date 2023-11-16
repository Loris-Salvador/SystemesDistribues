package be.hepl.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class ActiveMqApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ActiveMqApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"), messagePostProcessor -> {
            messagePostProcessor.setStringProperty("priority",
                    "high");
            return messagePostProcessor;
        });

    }
}
