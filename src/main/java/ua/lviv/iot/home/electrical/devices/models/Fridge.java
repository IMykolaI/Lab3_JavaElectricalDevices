package ua.lviv.iot.home.electrical.devices.models;

public class Fridge extends HomeElectricalDevice {

    private int numberOfCameras;
    private int numberOfShelves;

    public Fridge() {
    }

    public Fridge(final String pNameOfDevice, final boolean pIsTurnedOn, final double pPower, final double pVolume,
            final double pWeight, final Purpose pPurpose, final int pNumberOfCameras, final int pNumberOfShelves) {
        super(pNameOfDevice, pIsTurnedOn, pPower, pVolume, pWeight, pPurpose);
        this.numberOfCameras = pNumberOfCameras;
        this.numberOfShelves = pNumberOfShelves;
    }

    public final String getHeaders() {

        return super.getHeaders() + ", " + "Number of cameras, " + "Number of shelves";
    }

    public final String toCSV() {

        return super.toCSV() + ", " + this.getNumberOfCameras() + ", " + this.getNumberOfShelves();
    }

    public final int getNumberOfCameras() {
        return numberOfCameras;
    }

    public final void setNumberOfCameras(final int pNumberOfCameras) {
        this.numberOfCameras = pNumberOfCameras;
    }

    public final int getNumberOfShelves() {
        return numberOfShelves;
    }

    public final void setNumberOfShelves(final int pNumberOfShelves) {
        this.numberOfShelves = pNumberOfShelves;
    }
}
