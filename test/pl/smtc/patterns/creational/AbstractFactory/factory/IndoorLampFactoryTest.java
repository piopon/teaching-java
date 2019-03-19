package pl.smtc.patterns.creational.AbstractFactory.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.smtc.patterns.creational.AbstractFactory.product.lamp.CeilingLamp;
import pl.smtc.patterns.creational.AbstractFactory.product.lamp.ELamp;
import pl.smtc.patterns.creational.AbstractFactory.product.lamp.Lamp;
import pl.smtc.patterns.creational.AbstractFactory.product.lamp.WallLamp;
import pl.smtc.patterns.creational.AbstractFactory.product.mount.DowelsMounting;
import pl.smtc.patterns.creational.AbstractFactory.product.mount.EMounting;
import pl.smtc.patterns.creational.AbstractFactory.product.mount.Mounting;
import pl.smtc.patterns.creational.AbstractFactory.product.mount.ScrewsMounting;
import pl.smtc.patterns.creational.AbstractFactory.product.source.ESource;
import pl.smtc.patterns.creational.AbstractFactory.product.source.LedSource;
import pl.smtc.patterns.creational.AbstractFactory.product.source.NeonSource;
import pl.smtc.patterns.creational.AbstractFactory.product.source.Source;

import static org.junit.jupiter.api.Assertions.*;

class IndoorLampFactoryTest {
    private final static Lamp TEST_LAMP = new CeilingLamp("RED");
    private final static Mounting TEST_MOUNT = new ScrewsMounting();
    private final static Source TEST_SOURCE = new LedSource(3000);
    private IndoorLampFactory testFactory;

    @BeforeEach
    void setUp() {
        testFactory = new IndoorLampFactory();
        testFactory.registerLamp(TEST_LAMP);
        testFactory.registerMounting(TEST_MOUNT);
        testFactory.registerSource(TEST_SOURCE);
    }

    @Test
    void getNameShouldReturnIndoorLampString() {
        assertEquals("INDOOR LAMP FACTORY", testFactory.getName());
    }

    @Test
    void createLampShouldReturnRegisteredLampType() {
        Lamp result = testFactory.createLamp(ELamp.CEILING);
        assertEquals(result.getType(), TEST_LAMP.getType());
        assertEquals(result.getDescription(), TEST_LAMP.getDescription());
        assertTrue(result.getDescription().contains("[IP20]"));
    }

    @Test
    void createLampShouldThrowIfUnregisteredLampTypeInputted() {
        Executable executable = () -> testFactory.createLamp(ELamp.GARDEN);
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    void createMountingShouldReturnRegisteredMountType() {
        Mounting result = testFactory.createMounting(EMounting.SCREWS);
        assertEquals(result.getType(), TEST_MOUNT.getType());
        assertEquals(result.getDescription(), TEST_MOUNT.getDescription());
        assertEquals(result.getTools(), TEST_MOUNT.getTools());
        assertTrue(result.getDescription().contains("4 SCREWS"));
    }

    @Test
    void createMountingShouldThrowIfUnregisteredMountTypeInputted() {
        Executable executable = () -> testFactory.createMounting(EMounting.STAND);
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    void createSourceShouldReturnRegisteredSourceType() {
        Source result = testFactory.createSource(ESource.LED);
        assertEquals(result.getType(), TEST_SOURCE.getType());
        assertEquals(result.getDescription(), TEST_SOURCE.getDescription());
        assertTrue(result.getDescription().contains("MILKY glass"));
    }

    @Test
    void createSourceShouldThrowIfUnregisteredSourceTypeInputted() {
        Executable executable = () -> testFactory.createSource(ESource.NEON);
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    void registerLampShouldAddNewLampToRegisteredLampsList() {
        assertEquals(1, testFactory.registeredLamps.size());
        testFactory.registerLamp(new WallLamp("BLUE"));
        assertEquals(2, testFactory.registeredLamps.size());
        assertTrue(testFactory.registeredLamps.containsKey(ELamp.CEILING));
        assertTrue(testFactory.registeredLamps.containsKey(ELamp.WALL));
    }

    @Test
    void registerMountingShouldAddNewMountToRegisteredMountsList() {
        assertEquals(1, testFactory.registeredMountings.size());
        testFactory.registerMounting(new DowelsMounting());
        assertEquals(2, testFactory.registeredMountings.size());
        assertTrue(testFactory.registeredMountings.containsKey(EMounting.SCREWS));
        assertTrue(testFactory.registeredMountings.containsKey(EMounting.DOWELS));
    }

    @Test
    void registerSourceShouldAddNewSourceToRegisteredSourcesList() {
        assertEquals(1, testFactory.registeredSources.size());
        testFactory.registerSource(new NeonSource(4000));
        assertEquals(2, testFactory.registeredSources.size());
        assertTrue(testFactory.registeredSources.containsKey(ESource.LED));
        assertTrue(testFactory.registeredSources.containsKey(ESource.NEON));
    }

    @Test
    void getRegisteredDataShouldReturnAllLampsForLampProductInput() {
        assertEquals("[CEILING]", testFactory.getRegisteredData(EComponent.LAMP));
        testFactory.registerLamp(new WallLamp("BLUE"));
        String result = testFactory.getRegisteredData(EComponent.LAMP);
        assertTrue(result.contains("["));
        assertTrue(result.contains("CEILING"));
        assertTrue(result.contains(","));
        assertTrue(result.contains("WALL"));
        assertTrue(result.contains("]"));
    }

    @Test
    void getRegisteredDataShouldReturnAllMountingsForMountProductInput() {
        assertEquals("[SCREWS]", testFactory.getRegisteredData(EComponent.MOUNTING));
        testFactory.registerMounting(new DowelsMounting());
        String result = testFactory.getRegisteredData(EComponent.MOUNTING);
        assertTrue(result.contains("["));
        assertTrue(result.contains("SCREWS"));
        assertTrue(result.contains(","));
        assertTrue(result.contains("DOWELS"));
        assertTrue(result.contains("]"));
    }

    @Test
    void getRegisteredDataShouldReturnAllSourcesForSourceProductInput() {
        assertEquals("[LED]", testFactory.getRegisteredData(EComponent.SOURCE));
        testFactory.registerSource(new NeonSource(4000));
        String result = testFactory.getRegisteredData(EComponent.SOURCE);
        assertTrue(result.contains("["));
        assertTrue(result.contains("LED"));
        assertTrue(result.contains(","));
        assertTrue(result.contains("NEON"));
        assertTrue(result.contains("]"));
    }
}