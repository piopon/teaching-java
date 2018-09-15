package pl.smtc.recursion.dec2bin;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToBinaryTest {
    static DecimalToBinary decToBin;

    @BeforeAll
    static void setup() {
        decToBin = new DecimalToBinary();
    }

    @Test
    void getNameShouldReturnDecimalToBinary() {
        String currentName = decToBin.getName();
        assertEquals("Decimal to Binary", currentName);
    }
}