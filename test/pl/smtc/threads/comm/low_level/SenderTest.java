package pl.smtc.threads.comm.low_level;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class SenderTest extends BaseTestOut {
    Sender sender;

    @Override
    protected void setUp() {
        Data sendData = new Data(5,5);
        sender = new Sender(sendData, 117,117,1, 1);
    }

    @Test
    void runShouldSendDesiredValue() {
        sender.run();
        String output = getOutput();
        assertTrue(output.contains("Sender -> sent item: 117"));
        assertTrue(output.contains("Sender -> finished (items sent: 1)!"));
    }

}