package pl.smtc.threads.sync.semaphore;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class SharedResourceTest extends BaseTestOut {
    SharedResource resource;

    @Override
    protected void setUp() {
        resource = SharedResource.getInstance();
    }

    @Test
    void getInstanceReturnsNonNullObject() {
        assertNotNull(resource);
    }

    @Test
    void accessSimulatesAcquiringSemaphore() {
        resource.access(10);
        String output = getOutput();
        assertTrue(output.contains("FTP access OK [current connections: 1]"));
    }
}