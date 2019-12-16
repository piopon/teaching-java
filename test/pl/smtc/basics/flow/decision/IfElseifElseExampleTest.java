package pl.smtc.basics.flow.decision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IfElseifElseExampleTest extends BaseTestInOut {
    private IfElseifElseExample ifElseExample;

    @Override
    protected void setUp() {
        ifElseExample = new IfElseifElseExample();
    }

    @ParameterizedTest(name = "{0} block output: {1}")
    @MethodSource("ifElseStatementLogic")
    void executeShouldInvokeIfElseExampleWithIfLogic(String in, String out) {
        simulateUserInput(in);
        ifElseExample.execute();
        String output = getOutput();
        assertTrue(output.contains(out));
    }

    @Test
    void getNameShouldReturnIfElseIfElseStatementString() {
        assertEquals("If-ElseIf-Else statement", ifElseExample.getName());
    }

    private static Stream<Arguments> ifElseStatementLogic() {
        return Stream.of(
                Arguments.of("if", "Output from IF block"),
                Arguments.of("If", "Output from IF block"),
                Arguments.of("IF", "Output from IF block"),
                Arguments.of("elseif", "Output from ELSE-IF block"),
                Arguments.of("ElseIf", "Output from ELSE-IF block"),
                Arguments.of("ELSEIF", "Output from ELSE-IF block"),
                Arguments.of("else", "Output from ELSE block"),
                Arguments.of("Else", "Output from ELSE block"),
                Arguments.of("ELSE", "Output from ELSE block"),
                Arguments.of("something", "Output from ELSE block")
        );
    }
}