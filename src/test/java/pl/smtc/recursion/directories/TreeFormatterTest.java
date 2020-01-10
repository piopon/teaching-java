package pl.smtc.recursion.directories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TreeFormatterTest {
    private TreeFormatter formatter;

    @BeforeEach
    void setup() {
        formatter = new TreeFormatter();
    }

    @ParameterizedTest(name = "Level {0} outputs: {1}")
    @MethodSource("createLevelDownIndentData")
    void goLevelDownOutputsCorrectIndentationString(int level, String expected) {
        String output = "";
        for(int i = 0; i < level; i++) {
            output = formatter.goLevelDown();
        }
        assertEquals(expected, output);
    }

    @ParameterizedTest(name = "Level {0} outputs: {1}")
    @MethodSource("createLevelUpIndentData")
    void goLevelUpOutputsCorrectIndentationString(int level, String expected) {
        for(int i = 0; i < level; i++) {
            formatter.goLevelDown();
        }
        String output = formatter.goLevelUp();
        assertEquals(expected, output);
    }

    @ParameterizedTest(name = "{1} at level {0} = {2}")
    @MethodSource("createPrintDirectoryData")
    void printDirOutputsCorrectLevelDirectory(int level, String dir, String expected) {
        for(int i = 0; i < level; i++) {
            formatter.goLevelDown();
        }
        String output = formatter.printDir(dir);
        assertEquals(expected, output);
    }

    @ParameterizedTest(name = "{1} at level {0} = {2}")
    @MethodSource("createPrintFileData")
    void printFileOutputsCorrectLevelFile(int level, String file, String result) {
        for(int i = 0; i < level; i++) {
            formatter.goLevelDown();
        }
        String output = formatter.printFile(file);
        assertEquals(result, output);
    }

    private static Stream<Arguments> createLevelDownIndentData() {
        return Stream.of(
                Arguments.of(0, ""),
                Arguments.of(1, "    |"),
                Arguments.of(2, "    |    |"),
                Arguments.of(3, "    |    |    |"));
    }

    private static Stream<Arguments> createLevelUpIndentData() {
        return Stream.of(
                Arguments.of(0, ""),
                Arguments.of(1, ""),
                Arguments.of(2, "    |"),
                Arguments.of(3, "    |"),
                Arguments.of(10, "    |"));
    }

    private static Stream<Arguments> createPrintDirectoryData() {
        return Stream.of(
                Arguments.of(0, "root", ">>> root"),
                Arguments.of(1, "dir1", "    +--- dir1"),
                Arguments.of(2, "dir2", "        +--- dir2"),
                Arguments.of(3, "dir3", "            +--- dir3"));
    }

    private static Stream<Arguments> createPrintFileData() {
        return Stream.of(
                Arguments.of(0, "file0", "    +--- file0"),
                Arguments.of(1, "file1", "    +--- file1"),
                Arguments.of(2, "file2", "    |    +--- file2"),
                Arguments.of(3, "file3", "    |    |    +--- file3"));
    }
}