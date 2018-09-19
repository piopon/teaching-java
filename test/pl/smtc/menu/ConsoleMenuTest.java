package pl.smtc.menu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleMenuTest {
    private ConsoleMenu consoleMenu;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        String menuTitle = "Menu test";
        int menuWidth = 35;
        Map<Integer, ConsoleExample> menuMap = new HashMap<>();
        menuMap.put(0, new ConsoleExample() {
            @Override
            public void execute() {
                System.out.println("EXECUTE from test console example");
            }

            @Override
            public String getName() {
                return "test console example";
            }
        });
        consoleMenu = new ConsoleMenu(menuTitle, menuWidth, menuMap);
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setIn(System.in);
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void showMenuPrintsMenuTitleInUppercase() {
        simulateUserInput("0");
        consoleMenu.show();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("MENU TEST"));
    }

    @Test
    void showMenuWithQuitCommandWillOnlyPrintMenu() {
        simulateUserInput("0");
        consoleMenu.show();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("1) test console example"));
        assertFalse(output.contains("EXECUTE from test console example"));
        assertFalse(output.contains("Bad input... Please try again."));
    }

    @Test
    void showMenuPrintsBadInputErrorWhenOutsideAvailableOptions() {
        simulateUserInput("10 0");
        consoleMenu.show();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("Bad input... Please try again."));
    }

    @Test
    void showMenuExecutesConsoleExampleAfterSelectingItsOption() {
        simulateUserInput("1 0");
        consoleMenu.show();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("EXECUTE from test console example"));
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}