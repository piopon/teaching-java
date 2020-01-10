package pl.smtc.patterns.structural.proxy;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ProxyPatternTest extends BaseTestInOut {
    private ProxyPattern proxyPattern;

    @Override
    protected void setUp() {
        proxyPattern = new ProxyPattern();
    }

    @Test
    void executeShouldInvokeProxyPatternExample() {
        simulateCommaInput("www.test.com, Y, www.test.com, Y, www.test.com, N," +
                "www.twitter.com, Y, www.twitter.com, N, exit");
        proxyPattern.execute();
        String output = getOutput();
        assertTrue(output.contains("Input URL [EXIT to quit]:"));
        assertTrue(output.contains("Use proxy server? [Y/N]"));
        assertTrue(output.contains("Retrieving page www.test.com... and sending from 196.119.46.12 to 192.168.0.254"));
        assertTrue(output.contains("Passing page: www.test.com from 192.168.0.254 to 192.168.0.10"));
        assertTrue(output.contains("VIEWING PAGE (source: A very long string from: 196.119.46.12 - www.test.com)"));
        assertTrue(output.contains("Sending cached url: www.test.com to 192.168.0.10"));
        assertTrue(output.contains("Retrieving page www.test.com... and sending from 196.119.46.12 to 192.168.0.10"));
        assertTrue(output.contains("ERROR 403 - access forbidden!"));
        assertTrue(output.contains("VIEWING PAGE (source: ERROR_403)"));
        assertTrue(output.contains("Retrieving page www.twitter.com... and sending from 25.119.46.15 to 192.168.0.10"));
        assertTrue(output.contains("VIEWING PAGE (source: A very long string from: 25.119.46.15 - www.twitter.com)"));
    }

    @Test
    void getNameShouldReturnProxyPatternString() {
        assertEquals("Proxy pattern", proxyPattern.getName());
    }
}