import ua.lviv.iot.home.electrical.devices.managers.HomeElectricalDeviceManagerImplementation;
import ua.lviv.iot.home.electrical.devices.models.HomeElectricalDevice;

import java.util.List;

import static ua.lviv.iot.home.electrical.devices.managers.HomeElectricalDeviceManagerImplementation.getHomeElectricalDevicesList;

public class Main {

    public static void main(String[] args) {

        List<HomeElectricalDevice> homeElectricalDevicesList = getHomeElectricalDevicesList();

        HomeElectricalDeviceManagerImplementation manager = new HomeElectricalDeviceManagerImplementation();

        manager.turnOn(homeElectricalDevicesList.get(0));
        manager.turnOn(homeElectricalDevicesList.get(3));
        manager.turnOn(homeElectricalDevicesList.get(5));
        manager.turnOn(homeElectricalDevicesList.get(7));

        manager.setHomeElectricalDevicesList(homeElectricalDevicesList);

        System.out.println("General power consumption: " + manager.calculatePowerConsumprion() + " wt\n\n");

        manager.turnOff(homeElectricalDevicesList.get(0));

        manager.setHomeElectricalDevicesList(homeElectricalDevicesList);

        System.out.println("General power consumption: " + manager.calculatePowerConsumprion() + " wt\n\n");

        System.out.print("Sorted by power consumption of the devices:\n\n");
        manager.printList(manager.sortByPowerConsumption(true));

        System.out.print("Sorted by the name of the devices:\n\n");
        manager.printList(manager.sortByNameOfDevice(false));
    }
}
