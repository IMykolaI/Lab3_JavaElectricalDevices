package ua.lviv.iot.home.electrical.devices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ua.lviv.iot.home.electrical.devices.models.ControlType;
import ua.lviv.iot.home.electrical.devices.models.ElectricalKettle;
import ua.lviv.iot.home.electrical.devices.models.Fridge;
import ua.lviv.iot.home.electrical.devices.models.KettleBodyMatherial;
import ua.lviv.iot.home.electrical.devices.models.Microwave;
import ua.lviv.iot.home.electrical.devices.models.Purpose;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public final CommandLineRunner demo(final HomeElectricalDevicesRepository repository) {
        return (args) -> {
            repository.save(new Fridge("Elenberg", false, 60.0, 30.0, 15.0, Purpose.FOOD_STORAGING, 1, 5));
            repository.save(new Fridge("Samsung", false, 272 * 1000 / 365, 311, 63, Purpose.FOOD_STORAGING, 2, 5));
            repository.save(
                    new Microwave("Panasonic", true, 10.0, 19.0, 2.5, Purpose.COOKING, ControlType.MECHANICAL, 19.0));
            repository.save(
                    new Microwave("SAMSUNG", false, 800, 23, 11.5, Purpose.COOKING, ControlType.ELECTRONIC, 28.8));
            repository.save(new ElectricalKettle("Tefal", false, 5.0, 2.0, 1.0, Purpose.COOKING,
                    KettleBodyMatherial.METAL_AND_PLASTIC, 2));
            repository.save(new ElectricalKettle("Philips", false, 1800, 1.7, 1.2, Purpose.HEATING,
                    KettleBodyMatherial.METAL_AND_PLASTIC, 1));

            repository.findAll().forEach(homeElectricalDevice -> System.out.println(homeElectricalDevice));
            System.out.println("------------------------------------------------------------");
            System.out.println(repository.findByNameOfDevice("Tefal"));
            System.out.println("------------------------------------------------------------");
        };
    }

}
