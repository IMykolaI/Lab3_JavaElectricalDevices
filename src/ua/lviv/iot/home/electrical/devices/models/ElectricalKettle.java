package ua.lviv.iot.home.electrical.devices.models;

public class ElectricalKettle extends HomeElectricalDevice {

    private KettleBodyMatherial bodyMatherial;
    private int numberOfWalls;

    public ElectricalKettle() {
    }

    public ElectricalKettle(String nameOfDevice, boolean isTurnedOn, double power, double volume, double weight,
                            Purpose purpose, KettleBodyMatherial bodyMatherial, int numberOfWalls) {
        super(nameOfDevice, isTurnedOn, power, volume, weight, purpose);
        this.bodyMatherial = bodyMatherial;
        this.numberOfWalls = numberOfWalls;
    }

    public KettleBodyMatherial getBodyMatherial() {
        return bodyMatherial;
    }

    public void setBodyMatherial(KettleBodyMatherial bodyMatherial) {
        this.bodyMatherial = bodyMatherial;
    }

    public int getNumberOfWalls() {
        return numberOfWalls;
    }

    public void setNumberOfWalls(int numberOfWalls) {
        this.numberOfWalls = numberOfWalls;
    }
}
