package pl.smtc.patterns.creational.factory.method.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.factory.method.product.CeilingLamp;
import pl.smtc.patterns.creational.factory.method.product.GardenLamp;
import pl.smtc.patterns.creational.factory.method.product.Lamp;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndoorLampFactoryTest {
    private IndoorLampFactory testFactory;
    private Lamp ceilingLamp = new CeilingLamp("CEILING_MOUNT", "CEILING_SUPPLY");
    private Lamp gardenLamp = new GardenLamp("GARDEN_MOUNT", "GARDEN_SUPPLY");

    @BeforeEach
    void setup() {
        testFactory = new IndoorLampFactory();
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
    void getNameShouldReturnIndoorLampFactoryString() {
        assertEquals("INDOOR LAMP FACTORY", testFactory.getName());
    }

    @Test
    void createLampShouldCreateLampIfRegisteredTypeInputted() {
        Lamp createdLamp = testFactory.createLamp(Lamps.CEILING);
        assertTrue(createdLamp.getDescription().contains(ceilingLamp.getDescription()));
        assertTrue(createdLamp.getDescription().contains("protect: IP20"));
        assertEquals(ceilingLamp.getType(), createdLamp.getType());
    }

    @Test
    void createLampShouldThrowIfNotRegisteredTypeInputted() {
        assertThrows(NullPointerException.class, () -> testFactory.createLamp(Lamps.GARDEN));
    }

    @Test
    void getColorShouldReturnOneOfFourCorrectColor() {
        String color = testFactory.getColor();
        assertTrue(containsAny(color, Arrays.asList("WHITE", "GREEN", "BLUE", "RED")));
        assertFalse(color.contains("BLACK"));
    }

    private boolean containsAny(String input, List<String> substrings) {
        for (String str : substrings) {
            if (input.contains(str)) {
                return true;
            }
        }
        return false;
    }
}