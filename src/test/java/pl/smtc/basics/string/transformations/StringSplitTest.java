package pl.smtc.basics.string.transformations;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringSplitTest extends BaseTestOut {
    private StringSplit stringSplit;

    @Override
    protected void setUp() {
        stringSplit = new StringSplit();
    }

    @Test
    void executeShouldInvokeStringSplitExample() {
        stringSplit.execute();
        String output = getOutput();
        assertTrue(output.contains("Input string: This is a test string"));
        assertTrue(output.contains("All split: [This, is, a, test, string]"));
        assertTrue(output.contains("Limit split: [This, is, a test string]"));
        assertTrue(output.contains("Substring one bound: s a test string"));
        assertTrue(output.contains("Substring two bounds: s a tes"));
        assertTrue(output.contains("Substring error: begin 6, end 100, length 21"));
        assertTrue(output.contains("Subsequence two bounds: s a tes"));
        assertTrue(output.contains("Subsequence error: begin 6, end 100, length 21"));
    }

    @Test
    void getNameShouldReturnSplittingStringString() {
        assertEquals("Splitting string", stringSplit.getName());
    }
}