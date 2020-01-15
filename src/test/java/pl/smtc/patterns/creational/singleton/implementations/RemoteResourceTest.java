package pl.smtc.patterns.creational.singleton.implementations;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class RemoteResourceTest extends BaseTestOut {
    private RemoteResource testResource;

    @Override
    protected void setUp() {
        testResource = RemoteResource.getInstance();
    }

    @Test
    void getInstanceShouldReturnTheSameRemoteResourceObject() {
        assertEquals(testResource, RemoteResource.getInstance());
    }

    @Test
    void isOpenedShouldReturnCorrectResourceOpenStatus() {
        testResource.close();
        assertFalse(testResource.isOpened());
        testResource.open();
        assertTrue(testResource.isOpened());
    }

    @Test
    void openShouldStartRemoteResourceConnection() {
        testResource.open();
        String output = getOutput();
        assertTrue(output.contains("Opening remote resource [ssh@10.0.168.1] ... OK"));
    }

    @Test
    void openShouldShowInfoWhenConnectionIsAlreadyOpened() {
        testResource.open();
        testResource.open();
        String output = getOutput();
        assertTrue(output.contains("Remote resource [ssh@10.0.168.1] already opened."));
    }

    @Test
    void closeShouldEndRemoteResourceConnection() {
        testResource.open();
        testResource.close();
        String output = getOutput();
        assertTrue(output.contains("Closing remote resource [ssh@10.0.168.1] ... OK"));
    }

    @Test
    void closeShouldShowInfoWhenConnectionIsAlreadyClosed() {
        testResource.close();
        testResource.close();
        String output = getOutput();
        assertTrue(output.contains("Remote resource [ssh@10.0.168.1] already closed."));
    }

    @Test
    void sendShouldSendDataToRemoteResource() {
        testResource.open();
        testResource.send("TEST_DATA");
        String output = getOutput();
        assertTrue(output.contains("Sending: TEST_DATA to resource [ssh@10.0.168.1] ... OK"));
    }

    @Test
    void sendShouldSendErrorMessageWhenConnectionIsClosed() {
        testResource.close();
        testResource.send("TEST_DATA");
        String output = getOutput();
        assertTrue(output.contains("ERROR. Cannot send data: TEST_DATA - connection closed."));
    }
}