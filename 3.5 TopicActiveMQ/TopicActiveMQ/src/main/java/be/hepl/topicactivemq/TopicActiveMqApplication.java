package be.hepl.topicactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class TopicActiveMqApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TopicActiveMqApplication.class, args);

        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");

        template.convertAndSend("mytopic", new Email("John", "coucou"), messagePostProcessor -> {
            messagePostProcessor.setStringProperty("priority", "high");
            return messagePostProcessor;
        });
    }
}
