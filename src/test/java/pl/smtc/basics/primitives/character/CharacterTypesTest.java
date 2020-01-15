package pl.smtc.basics.primitives.character;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTypesTest extends BaseTestOut {
    private CharacterTypes characterTypes;

    @Override
    protected void setUp() {
        characterTypes = new CharacterTypes();
    }

    @Test
    void executeShouldInvokeCharacterTypesExample() {
        characterTypes.execute();
        String output = getOutput();
        assertTrue(output.contains("Unicode characters example: PnK @ 2019"));
    }

    @Test
    void getNameShouldReturnCharacterTypesString() {
        assertEquals("Character types", characterTypes.getName());
    }
}