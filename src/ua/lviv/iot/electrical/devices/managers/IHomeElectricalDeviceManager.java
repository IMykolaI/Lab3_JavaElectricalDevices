package ua.lviv.iot.electrical.devices.managers;

import ua.lviv.iot.electrical.devices.models.HomeElectricalDevice;

import java.util.List;

public interface IHomeElectricalDeviceManager {

    double calculatePowerConsumprion();
    void turnOn(HomeElectricalDevice Device);
    void turnOff(HomeElectricalDevice device);
    List<HomeElectricalDevice> sortByPowerConsumption(boolean sortOrder);
    List<HomeElectricalDevice> sortByNameOfDevice(boolean sortOrder);
}
