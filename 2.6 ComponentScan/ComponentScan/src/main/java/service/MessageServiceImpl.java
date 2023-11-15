package service;

import be.hepl.componentscan.model.MessageGenerator;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageGenerator messageGenerator;
    public MessageServiceImpl(MessageGenerator messageGenerator)
    {
        this.messageGenerator = messageGenerator;
    }
    @Override
    public String getMessage() {
        return messageGenerator.generateMessage();
    }
}
