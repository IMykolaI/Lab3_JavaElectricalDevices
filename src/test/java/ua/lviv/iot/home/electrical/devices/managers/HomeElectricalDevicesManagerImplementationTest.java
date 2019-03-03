package ua.lviv.iot.home.electrical.devices.managers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.home.electrical.devices.models.ControlType;
import ua.lviv.iot.home.electrical.devices.models.ElectricalKettle;
import ua.lviv.iot.home.electrical.devices.models.Fridge;
import ua.lviv.iot.home.electrical.devices.models.HomeElectricalDevice;
import ua.lviv.iot.home.electrical.devices.models.KettleBodyMatherial;
import ua.lviv.iot.home.electrical.devices.models.Microwave;
import ua.lviv.iot.home.electrical.devices.models.Purpose;

class HomeElectricalDevicesManagerImplementationTest {

    HomeElectricalDevicesManagerImplementation testManager = new HomeElectricalDevicesManagerImplementation();

    List<HomeElectricalDevice> testList = new ArrayList<HomeElectricalDevice>();

    HomeElectricalDeviceWriter testWriter = new HomeElectricalDeviceWriter();

    File testFile = new File("lab_work_3_output_file");

    @BeforeEach
    public void initList() {

        Fridge fridge = new Fridge("Elenberg", false, 60.0, 30.0, 15.0, Purpose.FOOD_STORAGING, 1, 5);

        Microwave microwave = new Microwave("Panasonic", true, 10.0, 19.0, 2.5, Purpose.COOKING, ControlType.MECHANICAL,
                19.0);

        ElectricalKettle electricalKettle = new ElectricalKettle("Tefal", false, 5.0, 2.0, 1.0, Purpose.COOKING,
                KettleBodyMatherial.METAL_AND_PLASTIC, 2);

        testList.add(fridge);
        testList.add(microwave);
        testList.add(electricalKettle);

        testManager.setHomeElectricalDevicesList(testList);
    }

    @Test
    public void testCalculatePowerConsumprion() {

        Assertions.assertEquals(10.0, testManager.calculatePowerConsumprion());
    }

    @Test
    public void testTurnOnIfTurnedOn() {

        testList.get(1).setTurnedOn(true);

        testManager.turnOn(testList.get(1));

        Assertions.assertTrue(testList.get(1).getTurnedOn());
    }

    @Test
    public void testTurnOnIfTurnedOff() {

        testList.get(0).setTurnedOn(false);

        testManager.turnOn(testList.get(0));

        Assertions.assertTrue(testList.get(0).getTurnedOn());
    }

    @Test
    public void testTurnOffIfTurnedOff() {

        testList.get(2).setTurnedOn(false);

        testManager.turnOff(testList.get(2));

        Assertions.assertFalse(testList.get(2).getTurnedOn());
    }

    @Test
    public void testTurnOffIfTurnedOn() {

        testList.get(0).setTurnedOn(true);

        testManager.turnOff(testList.get(0));

        Assertions.assertFalse(testList.get(0).getTurnedOn());
    }

    @Test
    public void testSortByPowerConsumptionAscending() {

        testList = testManager.sortByPowerConsumption(true);

        Assertions.assertEquals(5.0, testList.get(0).getPower());
        Assertions.assertEquals(10.0, testList.get(1).getPower());
        Assertions.assertEquals(60.0, testList.get(2).getPower());
    }

    @Test
    public void testSortByPowerConsumptionDescending() {

        testList = testManager.sortByPowerConsumption(false);

        Assertions.assertEquals(60.0, testList.get(0).getPower());
        Assertions.assertEquals(10.0, testList.get(1).getPower());
        Assertions.assertEquals(5.0, testList.get(2).getPower());
    }

    @Test
    public void testSortByNameOfDeviceAscending() {

        testList = testManager.sortByNameOfDevice(true);

        Assertions.assertEquals("Elenberg", testList.get(0).getNameOfDevice());
        Assertions.assertEquals("Panasonic", testList.get(1).getNameOfDevice());
        Assertions.assertEquals("Tefal", testList.get(2).getNameOfDevice());
    }

    @Test
    public void testSortByNameOfDeviceDescending() {

        testList = testManager.sortByNameOfDevice(false);

        Assertions.assertEquals("Tefal", testList.get(0).getNameOfDevice());
        Assertions.assertEquals("Panasonic", testList.get(1).getNameOfDevice());
        Assertions.assertEquals("Elenberg", testList.get(2).getNameOfDevice());
    }

    @Test
    public void testWriteToFile() throws IOException {

        testWriter.writeToFile(testList, testFile);
        Assertions.assertNotEquals(testFile.length(), 0);
    }
}
