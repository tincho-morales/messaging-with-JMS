package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class Controller {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/send")
    public String publish(){

        // Enviamos el mensaje a la cola "mailbox"
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));

        return "Ok";
    }
}
