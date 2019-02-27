package main.java.ua.lviv.iot.home.electrical.devices.managers;

import java.util.Comparator;
import java.util.List;

import main.java.ua.lviv.iot.home.electrical.devices.models.HomeElectricalDevice;

public class HomeElectricalDevicesManagerImplementation implements IHomeElectricalDevicesManager {

    private List<HomeElectricalDevice> homeElectricalDevicesList;

    public final void setHomeElectricalDevicesList(final List<HomeElectricalDevice> pHomeElectricalDevicesList) {
        this.homeElectricalDevicesList = pHomeElectricalDevicesList;
    }

    public final double calculatePowerConsumprion() {

        double generalPowerConsumption = 0;
        int sizeOfList = homeElectricalDevicesList.size();
        for (int i = 0; i < sizeOfList; i++) {
            if (homeElectricalDevicesList.get(i).getTurnedOn()) {
                generalPowerConsumption += homeElectricalDevicesList.get(i).getPower();
            }
        }
        return generalPowerConsumption;
    }

    public final void turnOn(final HomeElectricalDevice device) {

        if (!device.getTurnedOn()) {
            device.setTurnedOn(!device.getTurnedOn());
        }
    }

    public final void turnOff(final HomeElectricalDevice device) {

        if (device.getTurnedOn()) {
            device.setTurnedOn(!device.getTurnedOn());
        }
    }

    public final List<HomeElectricalDevice> sortByPowerConsumption(final boolean sortOrder) {

        if (sortOrder) {
            homeElectricalDevicesList.sort(Comparator.comparingDouble(HomeElectricalDevice::getPower));
        } else {
            homeElectricalDevicesList.sort(Comparator.comparingDouble(HomeElectricalDevice::getPower).reversed());
        }
        return homeElectricalDevicesList;
    }

    public final List<HomeElectricalDevice> sortByNameOfDevice(final boolean sortOrder) {

        if (sortOrder) {
            // homeElectricalDevicesList.sort(Comparator.comparing(HomeElectricalDevice::getNameOfDevice));
            homeElectricalDevicesList.sort((o1, o2) -> o1.getNameOfDevice().compareTo(o2.getNameOfDevice()));
        } else {
            homeElectricalDevicesList.sort(Comparator.comparing(HomeElectricalDevice::getNameOfDevice).reversed());
        }
        return homeElectricalDevicesList;
    }

    public final void printList(final List<HomeElectricalDevice> pHomeElectricalDevicesList) {

        int sizeOfList = pHomeElectricalDevicesList.size();
        for (int i = 0; i < sizeOfList; i++) {
            System.out.println(pHomeElectricalDevicesList.get(i).getNameOfDevice());
            System.out.println("Turned on: " + pHomeElectricalDevicesList.get(i).getTurnedOn());
            System.out.println("Power consumption(wt): " + pHomeElectricalDevicesList.get(i).getPower());
            System.out.println("Volume: " + pHomeElectricalDevicesList.get(i).getPurpose());
            System.out.println("Weight: " + pHomeElectricalDevicesList.get(i).getVolume());
            System.out.println("Purpose: " + pHomeElectricalDevicesList.get(i).getWeight() + "\n");
        }
        System.out.print("\n");
    }
}
