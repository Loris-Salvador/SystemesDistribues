package be.hepl.componentscan.model;

import java.util.Random;


public class MessageGenerator {

    private String message;
    private Random r = new Random();

    public String generateMessage(){
        return "nombre aleatoire : " + r.nextInt(10);
    }
}
