package main.java.ua.lviv.iot.home.electrical.devices.models;

public class Microwave extends HomeElectricalDevice {

    private ControlType controlType;
    private double turntableDiametr;

    public Microwave() {
    }

    public Microwave(final String nameOfDevice, final boolean isTurnedOn, final double power, final double volume,
                     final double weight, final Purpose purpose, final ControlType pControlType,
                     final double pTurntableDiametr) {
        super(nameOfDevice, isTurnedOn, power, volume, weight, purpose);
        this.controlType = pControlType;
        this.turntableDiametr = pTurntableDiametr;
    }

    public final ControlType getControlType() {
        return controlType;
    }

    public final void setControlType(final ControlType pControlType) {
        this.controlType = pControlType;
    }

    public final double getTurntableDiametr() {
        return turntableDiametr;
    }

    public final void setTurntableDiametr(final double pTurntableDiametr) {
        this.turntableDiametr = pTurntableDiametr;
    }
}
