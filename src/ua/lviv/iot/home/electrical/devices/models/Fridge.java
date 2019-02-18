package ua.lviv.iot.home.electrical.devices.models;

public class Fridge extends HomeElectricalDevice {

    private int numberOfCameras;
    private int numberOfShelves;

    public Fridge() {
    }

    public Fridge(String nameOfDevice, boolean isTurnedOn, double power, double volume, double weight,
                  Purpose purpose, int numberOfCameras, int numberOfShelves) {
        super(nameOfDevice, isTurnedOn, power, volume, weight, purpose);
        this.numberOfCameras = numberOfCameras;
        this.numberOfShelves = numberOfShelves;
    }

    public int getNumberOfCameras() {
        return numberOfCameras;
    }

    public void setNumberOfCameras(int numberOfCameras) {
        this.numberOfCameras = numberOfCameras;
    }

    public int getNumberOfShelves() {
        return numberOfShelves;
    }

    public void setNumberOfShelves(int numberOfShelves) {
        this.numberOfShelves = numberOfShelves;
    }
}
