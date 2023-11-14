public class Main {
    public static void main(String[] args) {
        Switchable lamp = new Lamp();
        Switchable shaver = new ElectricShaver();
        Switch electricPowerSwitch = new ElectricPowerSwitch(lamp);

        System.out.println(electricPowerSwitch.isOn());
        electricPowerSwitch.press();
        System.out.println(electricPowerSwitch.isOn());
    }
}