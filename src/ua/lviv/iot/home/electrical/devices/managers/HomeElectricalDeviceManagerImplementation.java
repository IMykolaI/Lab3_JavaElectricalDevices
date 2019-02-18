package ua.lviv.iot.home.electrical.devices.managers;

import ua.lviv.iot.home.electrical.devices.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HomeElectricalDeviceManagerImplementation implements IHomeElectricalDeviceManager {

    private List<HomeElectricalDevice> homeElectricalDevicesList;

    private static List<HomeElectricalDevice> getHomeElectricalDevicesList() {

        List<HomeElectricalDevice> homeElectricalDevicesList = new ArrayList<>();

        homeElectricalDevicesList.add(new Fridge("Samsung RB29FSRNDSA/UA", false, 272 * 1000 / 365, 311, 63, Purpose.FOOD_STORAGING,
                2, 8));
        homeElectricalDevicesList.add(new Fridge("MYSTERY MRF-8070W", false, 90, 68, 17, Purpose.FOOD_STORAGING, 1, 3));
        homeElectricalDevicesList.add(new Fridge("BOSCH KGV36UW206", false, 274 * 1000 / 365, 312, 73,
                Purpose.FOOD_STORAGING, 2, 7));
        homeElectricalDevicesList.add(new Microwave("MYSTERY MMW-2013", false, 800, 20, 10.7, Purpose.COOKING,
                ControlType.MECHANICAL, 24.5));
        homeElectricalDevicesList.add(new Microwave("SAMSUNG ME83KRS-1/BW", false, 800, 23, 11.5, Purpose.COOKING, ControlType.ELECTRONIC,
                28.8));
        homeElectricalDevicesList.add(new Microwave("ELENBERG MG 2090 D", false, 800, 20, 12.5, Purpose.COOKING,
                ControlType.ELECTRONIC_WITH_ROTARY_SWITCH, 24.5));
        homeElectricalDevicesList.add(new ElectricalKettle("Philips Viva Collection HD9355/90", false, 1800, 1.7, 1.2, Purpose.HEATING,
                KettleBodyMatherial.METAL_AND_PLASTIC, 1));
        homeElectricalDevicesList.add(new ElectricalKettle("GORENJE K 10 C", false, 1630, 1, 1.9, Purpose.HEATING,
                KettleBodyMatherial.CERAMICS, 2));
        homeElectricalDevicesList.add(new ElectricalKettle("Tefal EXPRESS 1.5L KO299130", false, 2200, 1.5, 0.86,
                Purpose.HEATING, KettleBodyMatherial.PLASTIC, 1));

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
            homeElectricalDevicesList.sort(Comparator.comparingDouble(HomeElectricalDevice::getPower));
        } else {
            homeElectricalDevicesList.sort(Comparator.comparingDouble(HomeElectricalDevice::getPower).reversed());
        }
        return homeElectricalDevicesList;
    }

    @Override
    public List<HomeElectricalDevice> sortByNameOfDevice(boolean sortOrder) {

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

        List<HomeElectricalDevice> homeElectricalDevicesList = getHomeElectricalDevicesList();

        HomeElectricalDeviceManagerImplementation manager = new HomeElectricalDeviceManagerImplementation();

        manager.turnOn(homeElectricalDevicesList.get(0));
        manager.turnOn(homeElectricalDevicesList.get(3));
        manager.turnOn(homeElectricalDevicesList.get(5));
        manager.turnOn(homeElectricalDevicesList.get(7));

        manager.setHomeElectricalDevicesList(homeElectricalDevicesList);

        System.out.println("General power consumption: " + manager.calculatePowerConsumprion() + "\n\n");

        System.out.print("Sorted by power consumption of the devices:\n\n");
        manager.printList(manager.sortByPowerConsumption(true));
        /*homeElectricalDevicesList.sort(HomeElectricalDevice o1, HomeElectricalDevice o2) ->
        o1.getPower() - o2.getPower();*/

        System.out.print("Sorted by the name of the devices:\n\n");
        manager.printList(manager.sortByNameOfDevice(true));
    }
}
