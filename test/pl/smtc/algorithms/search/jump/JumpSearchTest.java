package pl.smtc.algorithms.search.jump;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JumpSearchTest extends BaseTestOut {
    private JumpSearch jumpSearch;

    @Override
    protected void setUp() {
        jumpSearch = new JumpSearch();
    }

    @Test
    void executeShouldInvokeJumpSearchExample() {
        jumpSearch.execute();
        String output = getOutput();
        assertTrue(output.contains("SEARCH: [-9, -3, -1, 0, 1, 1, 2, 3, 4, 10]"));
        assertTrue(output.contains("RESULT: item '3' found at index: 7"));
    }

    @Test
    void getNameShouldReturnJumpSearchString() {
        assertEquals("Jump search", jumpSearch.getName());
    }

    @Test
    void findShouldThrowExceptionWhenNoElementIsFound() {
        final List<Integer> testList = Arrays.asList(-100, -50, 0 , 50, 100);
        final int nonExistingElement = 21;
        assertThrows(NoSuchElementException.class, () -> jumpSearch.find(testList, nonExistingElement));
    }

    @ParameterizedTest(name = "Find {1} in array {0} -> {2}")
    @MethodSource("searchElementInSortedArray")
    void findShouldCorrectlySearchExistingInputElement(List<Integer> toFind, int item, int result) {
        assertEquals(result, jumpSearch.find(toFind, item));
    }

    private static Stream<Arguments> searchElementInSortedArray() {
        return Stream.of(
                Arguments.of(Arrays.asList(17), 17, 0),
                Arguments.of(Arrays.asList(1, 2), 2, 1),
                Arguments.of(Arrays.asList(-12, -11, 0), 0, 2),
                Arguments.of(Arrays.asList(-37, -27, -11, 0), -27, 1),
                Arguments.of(Arrays.asList(-123, -13, 567, 1024), 567, 2),
                Arguments.of(Arrays.asList(30, 41, 52, 63, 74), 52, 2),
                Arguments.of(Arrays.asList(-45, -44, -33, -12, -11), -11, 4),
                Arguments.of(Arrays.asList(-52, -51, -15, 15, 51), 15, 3),
                Arguments.of(Arrays.asList(-7, 0, 0, 0, 7), 7, 4),
                Arguments.of(Arrays.asList(1, 1, 1, 1, 1, 1), 1, 0),
                Arguments.of(Arrays.asList(-37, -37, 0, 0, 73, 73), 0, 2),
                Arguments.of(Arrays.asList(-11, -11, -11, -11, -11, -11), -11, 0));
    }
}