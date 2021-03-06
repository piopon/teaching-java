package pl.smtc.basics.flow.examples;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class DiagonalStarTest extends BaseTestInOut {
    private DiagonalStar diagonalStar;

    @Override
    protected void setUp() {
        diagonalStar = new DiagonalStar();
    }

    @Test
    void executeShouldInvokeDiagonalStartExample() {
        simulateUserInput("10");
        diagonalStar.execute();
        String output = getOutput();
        assertTrue(output.contains("**********"));
        assertTrue(output.contains("**      **"));
        assertTrue(output.contains("* *    * *"));
        assertTrue(output.contains("*  *  *  *"));
        assertTrue(output.contains("*   **   *"));
        assertTrue(output.contains("*   **   *"));
        assertTrue(output.contains("*  *  *  *"));
        assertTrue(output.contains("* *    * *"));
        assertTrue(output.contains("**      **"));
        assertTrue(output.contains("**********"));
    }

    @Test
    void executeShouldPrintErrorIfInputIsToSmall() {
        simulateUserInput("3");
        diagonalStar.execute();
        String output = getOutput();
        assertTrue(output.contains("Cannot print star smaller than 5."));
    }

    @Test
    void executeShouldPrintErrorIfInputCannotBeParsed() {
        simulateUserInput("NAN");
        diagonalStar.execute();
        String output = getOutput();
        assertTrue(output.contains("Cannot print star."));
    }

    @Test
    void getNameShouldReturnDiagonalStartString() {
        assertEquals("Diagonal star", diagonalStar.getName());
    }
}