package pl.smtc.patterns.creational.factory.simple.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.factory.simple.product.ILamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LampFactoryTest {

    @BeforeEach
    void setup() {
        LampFactory.clearRegisteredLamps();
    }

    @Test
    void registerLampShouldAddLampToRegisteredLampsMap() {
        LampFactory.registerLamp(createLamp(Lamps.CEILING, "Mock description"));
        assertEquals("[CEILING]", LampFactory.getRegisteredLamps());
    }

    @Test
    void getRegisteredLampsShouldPrintoutAllLamps() {
        LampFactory.registerLamp(createLamp(Lamps.CEILING, "Ceiling description"));
        LampFactory.registerLamp(createLamp(Lamps.WALL, "Wall description"));
        String registeredLamps = LampFactory.getRegisteredLamps();
        assertTrue(registeredLamps.contains("CEILING"));
        assertTrue(registeredLamps.contains("WALL"));
        assertFalse(registeredLamps.contains("GARDEN"));
        assertFalse(registeredLamps.contains("DESKTOP"));
        assertFalse(registeredLamps.contains("STREET"));
    }

    @Test
    void createLampShouldCreateObjectIfRegisteredLampTypeInputted() {
        LampFactory.registerLamp(createLamp(Lamps.STREET, "Street lamp"));
        ILamp created = LampFactory.createLamp(Lamps.STREET);
        assertEquals("Street lamp", created.getDescription());
        assertEquals(Lamps.STREET, created.getType());
    }

    @Test
    void createLampShouldReturnNullIfUnregisteredTypeInputted() {
        assertNull(LampFactory.createLamp(Lamps.DESKTOP));
    }

    @Test
    void clearRegisteredLampsShouldRemoveAllRegisteredLamps() {
        LampFactory.clearRegisteredLamps();
        assertEquals("[]", LampFactory.getRegisteredLamps());
    }

    ILamp createLamp(Lamps type, String description) {
        ILamp mockLamp = mock(ILamp.class);
        when(mockLamp.getType()).thenReturn(type);
        when(mockLamp.getDescription()).thenReturn(description);

        return mockLamp;
    }
}