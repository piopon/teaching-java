package pl.smtc.threads.comm.advanced;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ProducerConsumerTest extends BaseTestInOut {
    ProducerConsumer producerConsumer;

    @Override
    protected void setUp() {
        producerConsumer = new ProducerConsumer();
    }

    @Test
    void executeShouldInvokeProducerConsumerExample() {
        simulateUserInput("1 1" + System.lineSeparator() + System.lineSeparator());
        producerConsumer.execute();
        String output = getOutput();
        assertTrue(output.contains("> input minimum number to send/receive: "));
        assertTrue(output.contains("> input maximum number to send/receive: "));
        assertTrue(output.contains("CommObjectSend -> send: 1"));
    }

    @Test
    void getNameShouldReturnProducerConsumerPattern() {
        assertEquals("Producer-consumer pattern", producerConsumer.getName());
    }
}