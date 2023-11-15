package be.hepl.componentscan.controller;

import be.hepl.componentscan.model.MessageGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MessageService;

@Controller
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService)
    {
        this.messageService = messageService;
    }

    @GetMapping("/servicemessage")
    public String getMessage(Model model)
    {
        model.addAttribute("message", messageService.getMessage());
        return "view";
    }

}
