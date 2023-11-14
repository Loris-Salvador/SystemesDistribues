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
