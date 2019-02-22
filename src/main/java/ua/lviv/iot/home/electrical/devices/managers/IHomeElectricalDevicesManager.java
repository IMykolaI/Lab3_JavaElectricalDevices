package main.java.ua.lviv.iot.home.electrical.devices.managers;

import java.util.List;

import main.java.ua.lviv.iot.home.electrical.devices.models.HomeElectricalDevice;

public interface IHomeElectricalDevicesManager {

    double calculatePowerConsumprion();

    void turnOn(HomeElectricalDevice device);

    void turnOff(HomeElectricalDevice device);

    List<HomeElectricalDevice> sortByPowerConsumption(boolean sortOrder);

    List<HomeElectricalDevice> sortByNameOfDevice(boolean sortOrder);

    void printList(List<HomeElectricalDevice> homeElectricalDeviceList);
}
