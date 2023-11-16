package be.hepl.topicactivemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Receiver {

    private Logger log = LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = "mytopic", containerFactory = "myFactory", selector = "priority = 'high'")
    public void receiveMessage(Email email, @Headers Map<String, Object> headers)
    {
        System.out.println(email.toString());
        System.out.println(headers.get("priority"));
    }
}
