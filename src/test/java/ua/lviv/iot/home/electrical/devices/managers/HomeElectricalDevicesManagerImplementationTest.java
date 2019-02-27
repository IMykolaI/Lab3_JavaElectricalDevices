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

		Fridge obj1 = new Fridge();
		obj1.setNameOfDevice("Samsung");
		obj1.setTurnedOn(false);
		obj1.setPower(80.0);
		obj1.setVolume(60.0);
		obj1.setWeight(50.0);
		obj1.setPurpose(Purpose.FOOD_STORAGING);
		obj1.setNumberOfCameras(2);
		obj1.setNumberOfShelves(8);

		Fridge obj2 = new Fridge("Elenberg", true, 60.0, 30.0, 15.0, Purpose.FOOD_STORAGING, 1, 5);

		Microwave obj3 = new Microwave();
		obj3.setNameOfDevice("Bosch");
		obj3.setTurnedOn(false);
		obj3.setPower(40.0);
		obj3.setVolume(20.0);
		obj3.setWeight(3.0);
		obj3.setPurpose(Purpose.COOKING);
		obj3.setControlType(ControlType.ELECTRONIC);
		obj3.setTurntableDiametr(28.0);

		Microwave obj4 = new Microwave("Panasonic", true, 10.0, 19.0, 2.5, Purpose.COOKING, ControlType.MECHANICAL,
				19.0);

		ElectricalKettle obj5 = new ElectricalKettle();
		obj5.setNameOfDevice("Electrolux");
		obj5.setTurnedOn(false);
		obj5.setPower(15.0);
		obj5.setVolume(3.0);
		obj5.setWeight(2.0);
		obj5.setPurpose(Purpose.HEATING);
		obj5.setBodyMatherial(KettleBodyMatherial.GLASS);
		obj5.setNumberOfWalls(2);

		HomeElectricalDevice obj6 = new ElectricalKettle("Tefal", true, 5.0, 2.0, 1.0, Purpose.COOKING,
				KettleBodyMatherial.METAL_AND_PLASTIC, 2);

		testList.add(obj1);
		testList.add(obj2);
		testList.add(obj3);
		testList.add(obj4);
		testList.add(obj5);
		testList.add(obj6);

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
	
	@Test
	public void testPrintList() {
		
	}
}
