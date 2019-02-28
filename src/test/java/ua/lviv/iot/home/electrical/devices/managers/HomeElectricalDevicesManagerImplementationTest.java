package ua.lviv.iot.home.electrical.devices.managers;

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

	@BeforeEach
	public void initList() {

		Fridge fridge1 = new Fridge();
		fridge1.setNameOfDevice("Samsung");
		fridge1.setTurnedOn(false);
		fridge1.setPower(80.0);
		fridge1.setVolume(60.0);
		fridge1.setWeight(50.0);
		fridge1.setPurpose(Purpose.FOOD_STORAGING);
		fridge1.setNumberOfCameras(2);
		fridge1.setNumberOfShelves(8);

		Fridge fridge2 = new Fridge("Elenberg", true, 60.0, 30.0, 15.0, Purpose.FOOD_STORAGING, 1, 5);

		Microwave microwave1 = new Microwave();
		microwave1.setNameOfDevice("Bosch");
		microwave1.setTurnedOn(false);
		microwave1.setPower(40.0);
		microwave1.setVolume(20.0);
		microwave1.setWeight(3.0);
		microwave1.setPurpose(Purpose.COOKING);
		microwave1.setControlType(ControlType.ELECTRONIC);
		microwave1.setTurntableDiametr(28.0);

		Microwave microwave2 = new Microwave("Panasonic", true, 10.0, 19.0, 2.5, Purpose.COOKING, ControlType.MECHANICAL,
				19.0);

		ElectricalKettle electricalKettle1 = new ElectricalKettle();
		electricalKettle1.setNameOfDevice("Electrolux");
		electricalKettle1.setTurnedOn(false);
		electricalKettle1.setPower(15.0);
		electricalKettle1.setVolume(3.0);
		electricalKettle1.setWeight(2.0);
		electricalKettle1.setPurpose(Purpose.HEATING);
		electricalKettle1.setBodyMatherial(KettleBodyMatherial.GLASS);
		electricalKettle1.setNumberOfWalls(2);

		HomeElectricalDevice electricalKettle2 = new ElectricalKettle("Tefal", true, 5.0, 2.0, 1.0, Purpose.COOKING,
				KettleBodyMatherial.METAL_AND_PLASTIC, 2);

		testList.add(fridge1);
		testList.add(fridge2);
		testList.add(microwave1);
		testList.add(microwave2);
		testList.add(electricalKettle1);
		testList.add(electricalKettle2);

		testManager.setHomeElectricalDevicesList(testList);
	}

	@Test
	public void testCalculatePowerConsumprion() {

		Assertions.assertEquals(75.0, testManager.calculatePowerConsumprion());
	}

	@Test
	public void testTurnOnIfTurnedOn() {

		testList.get(1).setTurnedOn(true);

		testManager.turnOn(testList.get(1));

		Assertions.assertTrue(testList.get(1).getTurnedOn());
	}

	@Test
	public void testTurnOnIfTurnedOff() {

		testList.get(2).setTurnedOn(false);

		testManager.turnOn(testList.get(2));

		Assertions.assertTrue(testList.get(2).getTurnedOn());
	}

	@Test
	public void testTurnOffIfTurnedOff() {

		testList.get(4).setTurnedOn(false);

		testManager.turnOff(testList.get(4));

		Assertions.assertFalse(testList.get(4).getTurnedOn());
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
		Assertions.assertEquals(15.0, testList.get(2).getPower());
		Assertions.assertEquals(40.0, testList.get(3).getPower());
		Assertions.assertEquals(60.0, testList.get(4).getPower());
		Assertions.assertEquals(80.0, testList.get(5).getPower());
	}

	@Test
	public void testSortByPowerConsumptionDescending() {

		testList = testManager.sortByPowerConsumption(false);

		Assertions.assertEquals(80.0, testList.get(0).getPower());
		Assertions.assertEquals(60.0, testList.get(1).getPower());
		Assertions.assertEquals(40.0, testList.get(2).getPower());
		Assertions.assertEquals(15.0, testList.get(3).getPower());
		Assertions.assertEquals(10.0, testList.get(4).getPower());
		Assertions.assertEquals(5.0, testList.get(5).getPower());
	}

	@Test
	public void testSortByNameOfDeviceAscending() {

		testList = testManager.sortByNameOfDevice(true);

		Assertions.assertEquals("Bosch", testList.get(0).getNameOfDevice());
		Assertions.assertEquals("Electrolux", testList.get(1).getNameOfDevice());
		Assertions.assertEquals("Elenberg", testList.get(2).getNameOfDevice());
		Assertions.assertEquals("Panasonic", testList.get(3).getNameOfDevice());
		Assertions.assertEquals("Samsung", testList.get(4).getNameOfDevice());
		Assertions.assertEquals("Tefal", testList.get(5).getNameOfDevice());
	}

	@Test
	public void testSortByNameOfDeviceDescending() {

		testList = testManager.sortByNameOfDevice(false);

		Assertions.assertEquals("Tefal", testList.get(0).getNameOfDevice());
		Assertions.assertEquals("Samsung", testList.get(1).getNameOfDevice());
		Assertions.assertEquals("Panasonic", testList.get(2).getNameOfDevice());
		Assertions.assertEquals("Elenberg", testList.get(3).getNameOfDevice());
		Assertions.assertEquals("Electrolux", testList.get(4).getNameOfDevice());
		Assertions.assertEquals("Bosch", testList.get(5).getNameOfDevice());
	}
}
