package ua.lviv.iot.home.electrical.devices.managers;

import ua.lviv.iot.home.electrical.devices.models.HomeElectricalDevice;

import java.util.List;

public interface IHomeElectricalDeviceManager {

    double calculatePowerConsumprion();
    void turnOn(HomeElectricalDevice Device);
    void turnOff(HomeElectricalDevice device);
    List<HomeElectricalDevice> sortByPowerConsumption(List<HomeElectricalDevice> homeElectricalDevicesList,
                                                      boolean sortOrder);
    List<HomeElectricalDevice> sortByNameOfDevice(List<HomeElectricalDevice> homeElectricalDevicesList,
                                                  boolean sortOrder);
}
