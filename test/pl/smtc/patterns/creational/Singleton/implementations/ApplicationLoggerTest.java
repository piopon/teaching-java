package pl.smtc.patterns.creational.Singleton.implementations;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationLoggerTest extends BaseTestOut {
    private ApplicationLogger testLogger;

    @Override
    protected void setUp() {
        testLogger = ApplicationLogger.getInstance();
    }

    @Test
    void getInstanceShouldReturnTheSameAppLoggerObject() {
        assertEquals(testLogger, ApplicationLogger.getInstance());
    }

    @Test
    void logErrorShouldLogErrorMessageWithInputtedString() {
        testLogger.logError("test_error_message");
        String output = getOutput();
        assertTrue(output.contains("ERROR: test_error_message"));
    }

    @Test
    void logWarningShouldLogWarningMessageWithInputtedString() {
        testLogger.logWarning("test_warning_message");
        String output = getOutput();
        assertTrue(output.contains("WARNING: test_warning_message"));
    }

    @Test
    void logInfoShouldLogInfoMessageWithInputtedString() {
        testLogger.logInfo("test_info_message");
        String output = getOutput();
        assertTrue(output.contains("INFO: test_info_message"));
    }

    @Test
    void printLastMessagesShouldOutputLastInputtedLogs() {
        testLogger.logError("error_message");
        testLogger.logWarning("warn1_message");
        testLogger.logInfo("info1_message");
        testLogger.logInfo("info2_message");
        testLogger.printLastMessages();
        String output = getOutput();
        assertTrue(output.contains(") ERROR: error_message"));
        assertTrue(output.contains(") WARNING: warn1_message"));
        assertTrue(output.contains(") INFO: info1_message"));
        assertTrue(output.contains(") INFO: info2_message"));
    }
}