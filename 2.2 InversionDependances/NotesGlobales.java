/*DEMARRAGE PROJET SIMPLE PROJET INTELIJ (pas besoin de maven)*/

//Injection de dependances permet de moduler le projet dans l'exemple ici on montre ca avec un Rasoir qui a besoin d'un objet qui fait on et off
//On cree une interface qui repond a ce besoin et comme ca peut importe la classe qu'on fait tant qu'elle permet de faire on, off (et donc implement l'interface switchable dans le projet)
//ca marche

//L'exemple est un peu bateau mais on pourrais imaginer ca dans un gros projet ou en production on ferait un reposuitoryTest qui implemente un interface reposuitory
//et quand avoir aussi un "Bon repository qui lui aussi implemente l'interface on peux donc facilement interchanger les deux a des fin de test"

//les classes pour le projet : 

public interface Switch {

    boolean isOn();
    void press();
}

public interface Switchable {

    void on();
    void off();
}


public class Lamp implements Switchable{


    @Override
    public void on() {
        System.out.println("Lamp turn on");
    }

    @Override
    public void off() {
        System.out.println("Lamp turn off");

    }
}


public class ElectricShaver implements Switchable{
    @Override
    public void on() {

    }

    @Override
    public void off() {

    }
}

public class ElectricPowerSwitch implements Switch{

    private Switchable switchable;
    private boolean isOn;

    public ElectricPowerSwitch(Switchable switchable)
    {
        this.switchable = switchable;
        isOn = false;
    }
    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void press() {
        if(isOn == false)
        {
            switchable.on();
            isOn = true;
        }
        else
        {
            switchable.off();
            isOn = false;
        }
    }
}

//

public class Main {
    public static void main(String[] args) {
        Switchable lamp = new Lamp();
        Switchable shaver = new ElectricShaver();
        Switch electricPowerSwitch = new ElectricPowerSwitch(lamp);// ici qu'on injecte une lampe ou un electric switch ca marchera car il implemente tout les deux swtichable c'est ca l'inversion de dependances

        System.out.println(electricPowerSwitch.isOn());
        electricPowerSwitch.press();
        System.out.println(electricPowerSwitch.isOn());
    }
}



/*def : Les modules de haut niveau ne doivent pas dépendre des modules de bas niveau. Les deux doivent dépendre d'abstractions.
 De plus, les abstractions ne doivent pas dépendre des détails. Les détails doivent dépendre des abstractions.

 ici on ne depend pas de lampe ou de Rasoir on depend d'une abtraction qui repond au besoin (sans details qui sont dans les classes)*/

