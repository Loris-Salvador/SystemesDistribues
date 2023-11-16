package be.hepl.activemq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Receiver{

    private static Logger log = LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = "mailbox", containerFactory = "myFactory", selector = "priority = 'high'")
    public void receiveMessage(Email email, @Headers Map<String, Object> headers)
    {
        System.out.println("Received <" + email + ">");
        log.info("priority=" + String.valueOf(headers.get("priority")));

    }
}