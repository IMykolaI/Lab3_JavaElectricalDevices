package ua.lviv.iot.home.electrical.devices.models;

import javax.persistence.Entity;

@Entity
public class Microwave extends HomeElectricalDevice {

    private ControlType controlType;
    private double turntableDiameter;

    public Microwave() {
    }

    public Microwave(final String nameOfDevice, final boolean isTurnedOn, final double power, final double volume,
            final double weight, final Purpose purpose, final ControlType pControlType,
            final double pTurntableDiameter) {
        super(nameOfDevice, isTurnedOn, power, volume, weight, purpose);
        this.controlType = pControlType;
        this.turntableDiameter = pTurntableDiameter;
    }

    public final String getHeaders() {

        return super.getHeaders() + ", " + "Control type, " + "Turntable diameter";
    }

    public final String toCSV() {

        return super.toCSV() + ", " + this.getControlType() + ", " + this.getTurntableDiametr();
    }

    @Override
    public final String toString() {
        return super.toString() + "controlType=" + controlType + ", turntableDiameter=" + turntableDiameter + "]";
    }

    public final ControlType getControlType() {
        return controlType;
    }

    public final void setControlType(final ControlType pControlType) {
        this.controlType = pControlType;
    }

    public final double getTurntableDiametr() {
        return turntableDiameter;
    }

    public final void setTurntableDiametr(final double pTurntableDiameter) {
        this.turntableDiameter = pTurntableDiameter;
    }
}
