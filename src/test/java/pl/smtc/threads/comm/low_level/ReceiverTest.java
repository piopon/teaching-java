package pl.smtc.threads.comm.low_level;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class ReceiverTest extends BaseTestOut {
    Receiver receiver;

    @Override
    protected void setUp() {
        Data receiveData = new Data(5,5);
        Sender sender = new Sender(receiveData, 137,137,1, 1);
        sender.run();
        receiver = new Receiver(receiveData, 5, 1);
    }

    @Test
    void run() {
        receiver.run();
        String output = getOutput();
        assertTrue(output.contains("Receiver -> got item: 137"));
        assertTrue(output.contains("Receiver -> finished (items received: 1)!"));
    }
}