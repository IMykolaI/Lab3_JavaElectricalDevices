package ua.lviv.iot.home.electrical.devices.models;

public class ElectricalKettle extends HomeElectricalDevice {

    private KettleBodyMatherial bodyMatherial;
    private int numberOfWalls;

    public ElectricalKettle() {
    }

    public ElectricalKettle(final String pNameOfDevice, final boolean pIsTurnedOn, final double pPower,
            final double pVolume, final double pWeight, final Purpose pPurpose,
            final KettleBodyMatherial pBodyMatherial, final int pNumberOfWalls) {
        super(pNameOfDevice, pIsTurnedOn, pPower, pVolume, pWeight, pPurpose);
        this.bodyMatherial = pBodyMatherial;
        this.numberOfWalls = pNumberOfWalls;
    }

    public final String getHeaders() {

        return super.getHeaders() + ", " + "Body matherial, " + "Number of walls";
    }

    public final String toCSV() {

        return super.toCSV() + ", " + this.getBodyMatherial() + ", " + this.getNumberOfWalls();
    }

    public final KettleBodyMatherial getBodyMatherial() {
        return bodyMatherial;
    }

    public final void setBodyMatherial(final KettleBodyMatherial pBodyMatherial) {
        this.bodyMatherial = pBodyMatherial;
    }

    public final int getNumberOfWalls() {
        return numberOfWalls;
    }

    public final void setNumberOfWalls(final int pNumberOfWalls) {
        this.numberOfWalls = pNumberOfWalls;
    }
}
