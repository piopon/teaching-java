package pl.smtc.patterns.creational.factory.abstrakt.support;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.factory.abstrakt.factory.LampFactory;

import static org.junit.jupiter.api.Assertions.*;

class FactoriesDataProviderTest {
    private FactoriesDataProvider dataProvider = new FactoriesDataProvider();

    @Test
    void getFactoryNamesReturnsIndoorAndOutdoorFactoryNames() {
        String factoriesNames = dataProvider.getFactoryNames();
        assertTrue(factoriesNames.contains("INDOOR LAMP FACTORY"));
        assertTrue(factoriesNames.contains("OUTDOOR LAMP FACTORY"));
    }

    @Test
    void getFactoryReturnsIndoorFactoryWhenInStringInput() {
        LampFactory factory = dataProvider.getFactory("IN");
        assertEquals("INDOOR LAMP FACTORY", factory.getName());
    }

    @Test
    void getFactoryReturnsOutdoorFactoryWhenOutStringInput() {
        LampFactory factory = dataProvider.getFactory("OUT");
        assertEquals("OUTDOOR LAMP FACTORY", factory.getName());
    }

    @Test
    void getFactoryReturnsIndoorFactoryWhenCommonStringInput() {
        LampFactory factory = dataProvider.getFactory("FACTORY");
        assertEquals("INDOOR LAMP FACTORY", factory.getName());
    }

    @Test
    void getFactoryReturnsNullWhenUnknownStringInput() {
        assertNull(dataProvider.getFactory("UNKNOWN"));
    }
}