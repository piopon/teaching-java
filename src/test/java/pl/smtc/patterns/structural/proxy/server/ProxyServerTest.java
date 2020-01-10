package pl.smtc.patterns.structural.proxy.server;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProxyServerTest extends BaseTestOut {
    private static final String TEST_CLIENT = "192.168.0.10";
    private ProxyServer proxyServer;

    @Override
    protected void setUp() {
        proxyServer = new ProxyServer();
    }

    @Test
    void getPageShouldReturnPageSourceWhenRequestedFirstTime() {
        String page = proxyServer.getPage(TEST_CLIENT, "www.t.com");
        String output = getOutput();
        assertEquals("A very long string from: 119.119.46.9 - www.t.com", page);
        assertTrue(output.contains("Passing page: www.t.com from 192.168.0.254 to 192.168.0.10"));
    }

    @Test
    void getPageShouldReturnCachedPageWhenRequestedAnotherTime() {
        proxyServer.getPage(TEST_CLIENT, "www.t.com");
        String page = proxyServer.getPage(TEST_CLIENT, "www.t.com");
        String output = getOutput();
        assertEquals("A very long string from: 119.119.46.9 - www.t.com", page);
        assertTrue(output.contains("Sending cached url: www.t.com to 192.168.0.10"));
    }

    @Test
    void getPageShouldReturnError403MessageIfAccessBlocked() {
        String page = proxyServer.getPage(TEST_CLIENT, "www.facebook.com");
        String output = getOutput();
        assertEquals("ERROR_403", page);
        assertTrue(output.contains("ERROR 403 - access forbidden!"));
    }

    @ParameterizedTest(name = "{0} comes from server {1}")
    @MethodSource("createGetServerIpData")
    void getServerIpShouldReturnCorrectData(String url, String ip) {
        assertEquals(ip, proxyServer.getServerIp(url));
    }

    private static Stream<Arguments> createGetServerIpData() {
        return Stream.of(
                Arguments.of("www.t.com", "119.119.46.9"),
                Arguments.of("www.t.com/about", "119.119.46.9"),
                Arguments.of("www.t.com\\about", "119.119.46.9"),
                Arguments.of("www.t.com\\about/contact", "119.119.46.9"),
                Arguments.of("www.t.com/about\\contact", "119.119.46.9"),
                Arguments.of("www.t.com/about/contact", "119.119.46.9"),
                Arguments.of("www.t.com\\about\\contact", "119.119.46.9"),
                Arguments.of("www.com.com", "67.119.46.11"),
                Arguments.of("hello.test", "6.116.46.10"),
                Arguments.of("www.wp.pl", "135.119.46.9"),
                Arguments.of("www.veryLongUrl.address", "57.121.46.23"),
                Arguments.of("www", "102.119.119.3"));
    }
}