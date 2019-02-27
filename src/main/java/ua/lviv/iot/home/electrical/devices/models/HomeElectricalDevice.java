package main.java.ua.lviv.iot.home.electrical.devices.models;

public abstract class HomeElectricalDevice {

    private String nameOfDevice;
    private boolean isTurnedOn;
    private double power;
    private double volume;
    private double weight;
    private Purpose purpose;

    public HomeElectricalDevice() {
    }

    public HomeElectricalDevice(final String pNameOfDevice, final boolean pIsTurnedOn, final double pPower,
                                final double pVolume, final double pWeight, final Purpose pPurpose) {
        this.nameOfDevice = pNameOfDevice;
        this.isTurnedOn = pIsTurnedOn;
        this.power = pPower;
        this.volume = pVolume;
        this.weight = pWeight;
        this.purpose = pPurpose;
    }

    public final String getNameOfDevice() {
        return nameOfDevice;
    }

    public final void setNameOfDevice(final String pNameOfDevice) {
        this.nameOfDevice = pNameOfDevice;
    }

    public final boolean getTurnedOn() {
        return isTurnedOn;
    }

    public final void setTurnedOn(final boolean pTurnedOn) {
        isTurnedOn = pTurnedOn;
    }

    public final double getPower() {
        return power;
    }

    public final void setPower(final double pPower) {
        this.power = pPower;
    }

    public final double getVolume() {
        return volume;
    }

    public final void setVolume(final double pVolume) {
        this.volume = pVolume;
    }

    public final double getWeight() {
        return weight;
    }

    public final void setWeight(final double pWeight) {
        this.weight = pWeight;
    }

    public final Purpose getPurpose() {
        return purpose;
    }

    public final void setPurpose(final Purpose pPurpose) {
        this.purpose = pPurpose;
    }
}
