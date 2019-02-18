package ua.lviv.iot.electrical.devices.models;

public class Microwave extends HomeElectricalDevice {

    private ControlType controlType;
    private double diametrOfTheTurntable;

    public Microwave() {
    }

    public Microwave(String nameOfDevice, boolean isTurnedOn, double power, double volume, double weight,
                     Purpose purpose, ControlType controlType, double diametrOfTheTurntable) {
        super(nameOfDevice, isTurnedOn, power, volume, weight, purpose);
        this.controlType = controlType;
        this.diametrOfTheTurntable = diametrOfTheTurntable;
    }

    public ControlType getControlType() {
        return controlType;
    }

    public void setControlType(ControlType controlType) {
        this.controlType = controlType;
    }

    public double getDiametrOfTheTurntable() {
        return diametrOfTheTurntable;
    }

    public void setDiametrOfTheTurntable(double diametrOfTheTurntable) {
        this.diametrOfTheTurntable = diametrOfTheTurntable;
    }
}
