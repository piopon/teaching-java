package pl.smtc.patterns.structural.proxy.server;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RealServerTest extends BaseTestOut {
    private static final String TEST_CLIENT = "192.168.0.10";
    private RealServer realServer;

    @Override
    protected void setUp() {
        realServer = new RealServer();
    }

    @Test
    void getPageShouldReturnPageSourceWhenRequested() {
        String page = realServer.getPage(TEST_CLIENT, "www.t.com");
        String output = getOutput();
        assertEquals("A very long string from: 119.119.46.9 - www.t.com", page);
        assertTrue(output.contains("Retrieving page www.t.com... and sending from 119.119.46.9 to 192.168.0.10"));
    }

    @ParameterizedTest(name = "{0} comes from server 62.119.46.11")
    @MethodSource("createGetServerIpData")
    void getServerIpShouldReturnCorrectData(String url) {
        assertEquals("62.119.46.11", realServer.getServerIp(url));
    }

    private static Stream<Arguments> createGetServerIpData() {
        return Stream.of(
                Arguments.of("www.page.pl"),
                Arguments.of("www.page.pl/articles"),
                Arguments.of("www.page.pl\\articles"),
                Arguments.of("www.page.pl\\articles/new"),
                Arguments.of("www.page.pl/articles\\new"),
                Arguments.of("www.page.pl/articles/new"),
                Arguments.of("www.page.pl\\articles\\new"));
    }
}