package pl.smtc.basics.flow.decision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SwitchCaseExampleTest extends BaseTestInOut {
    private SwitchCaseExample switchCaseExample;

    @Override
    protected void setUp() {
        switchCaseExample = new SwitchCaseExample();
    }

    @ParameterizedTest(name = "Input: {0} -> output: {1}")
    @MethodSource("switchStatementLogic")
    void executeShouldInvokeSwitchCaseExample(int in, String out) {
        simulateUserInput(String.valueOf(in));
        switchCaseExample.execute();
        String output = getOutput();
        assertTrue(output.contains(out));
    }

    @Test
    void getNameShouldReturnSwitchCaseStatementString() {
        assertEquals("Switch-Case statement", switchCaseExample.getName());
    }

    private static Stream<Arguments> switchStatementLogic() {
        return Stream.of(
                Arguments.of(0, "Output from DEFAULT block"),
                Arguments.of(1, "Output from CASE 1 block"),
                Arguments.of(2, "Output from CASE 2 block"),
                Arguments.of(3, "Output from CASE 3 block"),
                Arguments.of(4, "Output from DEFAULT block"),
                Arguments.of(10, "Output from DEFAULT block"),
                Arguments.of(11, "Output from DEFAULT block"),
                Arguments.of(29, "Output from DEFAULT block"),
                Arguments.of(-100, "Output from DEFAULT block"),
                Arguments.of(56789, "Output from DEFAULT block")
        );
    }
}