package ua.lviv.iot.home.electrical.devices.managers;

import ua.lviv.iot.home.electrical.devices.models.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HomeElectricalDeviceManagerImplementation implements IHomeElectricalDeviceManager {

    private List<HomeElectricalDevice> homeElectricalDevicesList;

    public List<HomeElectricalDevice> getHomeElectricalDevicesList() {
        return homeElectricalDevicesList;
    }

    public void setHomeElectricalDevicesList(List<HomeElectricalDevice> homeElectricalDevicesList) {
        this.homeElectricalDevicesList = homeElectricalDevicesList;
    }

    @Override
    public double calculatePowerConsumprion() {

        double generalPowerConsumption = 0;
        int sizeOfList = homeElectricalDevicesList.size();
        for (int i = 0; i < sizeOfList; i++) {
            if (homeElectricalDevicesList.get(i) instanceof HomeElectricalDevice) {
                if (homeElectricalDevicesList.get(i).getTurnedOn()) {
                    generalPowerConsumption += homeElectricalDevicesList.get(i).getPower();
                }
            }
        }
        return generalPowerConsumption;
    }

    @Override
    public void turnOn(HomeElectricalDevice device) {
        if (!device.getTurnedOn()) {
            device.setTurnedOn(!device.getTurnedOn());
        }
    }

    @Override
    public void turnOff(HomeElectricalDevice device) {
        if (device.getTurnedOn()) {
            device.setTurnedOn(!device.getTurnedOn());
        }
    }

    @Override
    public List<HomeElectricalDevice> sortByPowerConsumption(List<HomeElectricalDevice> homeElectricalDevicesList,
                                                             boolean sortOrder) {
        if (sortOrder) {
            homeElectricalDevicesList.sort(Comparator.comparingDouble(HomeElectricalDevice::getPower));
        } else {
            homeElectricalDevicesList.sort(Comparator.comparingDouble(HomeElectricalDevice::getPower).reversed());
        }
        return homeElectricalDevicesList;
    }

    @Override
    public List<HomeElectricalDevice> sortByNameOfDevice(List<HomeElectricalDevice> homeElectricalDevicesList,
                                                         boolean sortOrder) {
        if (sortOrder) {
            homeElectricalDevicesList.sort(Comparator.comparing(HomeElectricalDevice::getNameOfDevice));
        } else {
            homeElectricalDevicesList.sort(Comparator.comparing(HomeElectricalDevice::getNameOfDevice).reversed());
        }
        return homeElectricalDevicesList;
    }

    public void printList(List<HomeElectricalDevice> homeElectricalDevicesList) {
        int sizeOfList = homeElectricalDevicesList.size();
        for (int i = 0; i < sizeOfList; i++) {
            if (homeElectricalDevicesList.get(i) instanceof HomeElectricalDevice) {
                System.out.println(homeElectricalDevicesList.get(i).getNameOfDevice());
                System.out.println("Turned on: " + homeElectricalDevicesList.get(i).getTurnedOn());
                System.out.println("Power consumption(wt): " + homeElectricalDevicesList.get(i).getPower());
                System.out.println("Volume: " + homeElectricalDevicesList.get(i).getPurpose());
                System.out.println("Weight: " + homeElectricalDevicesList.get(i).getVolume());
                System.out.println("Purpose: " + homeElectricalDevicesList.get(i).getWeight() + "\n");
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        /*HomeElectricalDevice device = new Fridge();
        HomeElectricalDeviceManagerImplementation deviceManager = new HomeElectricalDeviceManagerImplementation();
        device.setPower(200);*/
        List<HomeElectricalDevice> homeElectricalDevicesList = Arrays.asList(
                new Fridge("Samsung RB29FSRNDSA/UA", false, 272 * 1000 / 365, 311, 63, Purpose.FOOD_STORAGING,
                        2, 5),
                new Microwave("SAMSUNG ME83KRS-1/BW", false, 800, 23, 11.5, Purpose.COOKING, ControlType.ELECTRONIC,
                        28.8),
                new ElectricalKettle("Philips Viva Collection HD9355/90", false, 1800, 1.7, 1.2, Purpose.HEATING,
                        KettleBodyMatherial.METAL_AND_PLASTIC, 1)
        );
        HomeElectricalDeviceManagerImplementation manager = new HomeElectricalDeviceManagerImplementation();
        manager.printList(manager.sortByPowerConsumption(homeElectricalDevicesList, true));
        System.out.print("\n");
        manager.printList(manager.sortByNameOfDevice(homeElectricalDevicesList, true));
        System.out.print("\n");
        System.out.println(homeElectricalDevicesList.get(0).getTurnedOn());
        manager.turnOn(homeElectricalDevicesList.get(0));
        System.out.println(homeElectricalDevicesList.get(0).getTurnedOn());
    }
}
