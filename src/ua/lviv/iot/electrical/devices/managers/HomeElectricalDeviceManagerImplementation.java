package ua.lviv.iot.electrical.devices.managers;

import ua.lviv.iot.electrical.devices.models.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HomeElectricalDeviceManagerImplementation implements IHomeElectricalDeviceManager {

    private List<HomeElectricalDevice> homeElectricalDevicesList = Arrays.asList(
            new Fridge("Samsung RB29FSRNDSA/UA", false, 272 * 1000 / 365, 311, 63, Purpose.FOOD_STORAGING,
                    2, 5),
            new Microwave("SAMSUNG ME83KRS-1/BW", false, 800, 23, 11.5, Purpose.COOKING, ControlType.ELECTRONIC,
                    28.8),
            new ElectricalKettle("Philips Viva Collection HD9355/90", false, 1800, 1.7, 1.2, Purpose.HEATING,
                    KettleBodyMatherial.METAL_AND_PLASTIC, 1)
    );

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
    public List<HomeElectricalDevice> sortByPowerConsumption(boolean sortOrder) {
        if (sortOrder) {
            this.homeElectricalDevicesList.sort(Comparator.comparingDouble(HomeElectricalDevice::getPower));
        } else {
            this.homeElectricalDevicesList.sort(Comparator.comparingDouble(HomeElectricalDevice::getPower).reversed());
        }
        return homeElectricalDevicesList;
    }

    @Override
    public List<HomeElectricalDevice> sortByNameOfDevice(boolean sortOrder) {
        if (sortOrder) {
            this.homeElectricalDevicesList.sort(Comparator.comparing(HomeElectricalDevice::getNameOfDevice));
        } else {
            this.homeElectricalDevicesList.sort(Comparator.comparing(HomeElectricalDevice::getNameOfDevice).reversed());
        }
        return homeElectricalDevicesList;
    }

    public void printList() {
        int sizeOfList = homeElectricalDevicesList.size();
        for (int i = 0; i < sizeOfList; i++) {
            if (homeElectricalDevicesList.get(i) instanceof HomeElectricalDevice) {
                System.out.println("\t" + homeElectricalDevicesList.get(i).getNameOfDevice());
                System.out.println("Turned on: " + homeElectricalDevicesList.get(i).getTurnedOn());
                System.out.println("Power consumption(wt): " + homeElectricalDevicesList.get(i).getPower());
                System.out.println("Volume: " + homeElectricalDevicesList.get(i).getVolume());
                System.out.println("Weight: " + homeElectricalDevicesList.get(i).getWeight());
                System.out.println("Purpose: " + homeElectricalDevicesList.get(i).getPurpose() + "\n");
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        /*HomeElectricalDevice device = new Fridge();
        HomeElectricalDeviceManagerImplementation deviceManager = new HomeElectricalDeviceManagerImplementation();
        device.setPower(200);*/
        HomeElectricalDeviceManagerImplementation manager = new HomeElectricalDeviceManagerImplementation();
        manager.sortByPowerConsumption(true);
        manager.printList();
        manager.sortByNameOfDevice(true);
        manager.printList();
        List<HomeElectricalDevice> mainList = manager.getHomeElectricalDevicesList();
        System.out.println(mainList.get(0).getTurnedOn());
        manager.turnOn(mainList.get(0));
        System.out.println(mainList.get(0).getTurnedOn());
    }
}
