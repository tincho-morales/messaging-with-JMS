package hello;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    //@JmsListener(destination = "mailbox") // Tambien funciona sin containerFactory
    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {

        // Escribe el mensaje que recibe
        System.out.println("Received <" + email + ">");
    }

}