package pl.smtc.patterns.creational.FactoryMethod.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.FactoryMethod.product.CeilingLamp;
import pl.smtc.patterns.creational.FactoryMethod.product.GardenLamp;
import pl.smtc.patterns.creational.FactoryMethod.product.Lamp;

import static org.junit.jupiter.api.Assertions.*;

class OutdoorLampFactoryTest {
    private OutdoorLampFactory testFactory;
    private Lamp ceilingLamp = new CeilingLamp("CEILING_MOUNT", "CEILING_SUPPLY");
    private Lamp gardenLamp = new GardenLamp("GARDEN_MOUNT", "GARDEN_SUPPLY");

    @BeforeEach
    void setup() {
        testFactory = new OutdoorLampFactory();
        testFactory.registerLamp(ceilingLamp);
    }

    @Test
    void registerLampShouldAddNewLampTypeIntoList() {
        assertEquals(1,testFactory.registeredLamps.size());
        testFactory.registerLamp(gardenLamp);
        assertEquals(2,testFactory.registeredLamps.size());
    }

    @Test
    void getRegisteredLampsShouldOutputAllRegisteredLampTypes() {
        assertEquals("[CEILING]", testFactory.getRegisteredLamps());
        testFactory.registerLamp(gardenLamp);
        assertTrue(testFactory.getRegisteredLamps().contains("CEILING"));
        assertTrue(testFactory.getRegisteredLamps().contains("GARDEN"));
    }
    @Test
    void getNameShouldReturnOutdoorLampFactoryString() {
        assertEquals("OUTDOOR LAMP FACTORY", testFactory.getName());
    }

    @Test
    void createLampShouldCreateLampIfRegisteredTypeInputted() {
        Lamp createdLamp = testFactory.createLamp(Lamps.CEILING);
        assertTrue(createdLamp.getDescription().contains(ceilingLamp.getDescription()));
        assertTrue(createdLamp.getDescription().contains("BLACK"));
        assertTrue(createdLamp.getDescription().contains("protect: IP67"));
        assertEquals(ceilingLamp.getType(), createdLamp.getType());
    }

    @Test
    void createLampShouldThrowIfNotRegisteredTypeInputted() {
        assertThrows(NullPointerException.class, () -> testFactory.createLamp(Lamps.GARDEN));
    }
}