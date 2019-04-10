package ua.lviv.iot.home.electrical.devices;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.iot.home.electrical.devices.models.HomeElectricalDevice;
import ua.lviv.iot.home.electrical.devices.models.Purpose;

public interface HomeElectricalDevicesRepository extends CrudRepository<HomeElectricalDevice, Integer> {

    HomeElectricalDevice findByNameOfDevice(String nameOfDevice);

    HomeElectricalDevice findByPurpose(Purpose purpose);

}
