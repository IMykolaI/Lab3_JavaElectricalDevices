package ua.lviv.iot.home.electrical.devices.models;

public class Microwave extends HomeElectricalDevice {

    private ControlType controlType;
    private double turntableDiametr;

    public Microwave() {
    }

    public Microwave(String nameOfDevice, boolean isTurnedOn, double power, double volume, double weight,
                     Purpose purpose, ControlType controlType, double turntableDiametr) {
        super(nameOfDevice, isTurnedOn, power, volume, weight, purpose);
        this.controlType = controlType;
        this.turntableDiametr = turntableDiametr;
    }

    public ControlType getControlType() {
        return controlType;
    }

    public void setControlType(ControlType controlType) {
        this.controlType = controlType;
    }

    public double getTurntableDiametr() {
        return turntableDiametr;
    }

    public void setTurntableDiametr(double turntableDiametr) {
        this.turntableDiametr = turntableDiametr;
    }
}
