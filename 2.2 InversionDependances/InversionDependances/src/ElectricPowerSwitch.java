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
