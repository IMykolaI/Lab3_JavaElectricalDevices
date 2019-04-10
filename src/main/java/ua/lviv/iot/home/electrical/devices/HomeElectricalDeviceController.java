package ua.lviv.iot.home.electrical.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.home.electrical.devices.models.HomeElectricalDevice;

@RestController
@RequestMapping("/homeelectricaldevices")
public class HomeElectricalDeviceController {

    @Autowired
    private HomeElectricalDevicesRepository homeElectricalDevicesRepository;

    @GetMapping
    public final HomeElectricalDevice getHomeElectricalDevice() {
        return homeElectricalDevicesRepository.findById(4).get();
    }

    @PostMapping
    @PutMapping
    public final HomeElectricalDevice updateHomeElectricalDevice(final HomeElectricalDevice homeElectricalDevice) {
        return homeElectricalDevicesRepository.save(homeElectricalDevice);
    }

    @DeleteMapping
    public final HomeElectricalDevice deleteHomeElectricalDevice(final HomeElectricalDevice homeElectricalDevice) {
        return homeElectricalDevicesRepository.save(homeElectricalDevice);
    }
}
