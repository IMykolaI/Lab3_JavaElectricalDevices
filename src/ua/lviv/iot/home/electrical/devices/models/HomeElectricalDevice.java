package ua.lviv.iot.home.electrical.devices.models;

public abstract class HomeElectricalDevice {

    private String nameOfDevice;
    private boolean isTurnedOn;
    private double power;
    private double volume;
    private double weight;
    private Purpose purpose;

    public HomeElectricalDevice() {
    }

    public HomeElectricalDevice(String nameOfDevice, boolean isTurnedOn, double power, double volume, double weight,
                                Purpose purpose) {
        this.nameOfDevice = nameOfDevice;
        this.isTurnedOn = isTurnedOn;
        this.power = power;
        this.volume = volume;
        this.weight = weight;
        this.purpose = purpose;
    }

    public String getNameOfDevice() {
        return nameOfDevice;
    }

    public void setNameOfDevice(String nameOfDevice) {
        this.nameOfDevice = nameOfDevice;
    }

    public boolean getTurnedOn() {
        return isTurnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }
}
