package pl.smtc.basics.string.checks;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringMatchersTest extends BaseTestOut {
    private StringMatchers stringMatchers;

    @Override
    protected void setUp() {
        stringMatchers = new StringMatchers();
    }

    @Test
    void executeShouldInvokeStringMatchersExample() {
        stringMatchers.execute();
        String output = getOutput();
        assertTrue(output.contains("Is '82-400' valid zip code: true"));
        assertTrue(output.contains("Is '82400' valid zip code: false"));
        assertTrue(output.contains("String region the same: true"));
        assertTrue(output.contains("String region the same (ignore case): true"));
    }

    @Test
    void getNameShouldReturnRegexMatchersString() {
        assertEquals("Regex matchers", stringMatchers.getName());
    }
}