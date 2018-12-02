package pl.smtc.threads.comm.low_level;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @ParameterizedTest(name = "Received data = {0}")
    @MethodSource("sendReceiveData")
    void receiveShouldGetSentValue(int received) throws InterruptedException {
        Data data = new Data(10,10);
        data.send(received);
        assertEquals(received, data.receive());
    }

    @ParameterizedTest(name = "Received data = {0}")
    @MethodSource("sendReceiveData")
    void sendShouldSetInternalValue(int sent) throws InterruptedException {
        Data data = new Data(10,10);
        data.send(sent);
        assertEquals(sent, data.getStoredValue());
    }

    private static Stream<Arguments> sendReceiveData() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(-999),
                Arguments.of(-123),
                Arguments.of(909),
                Arguments.of(117),
                Arguments.of(2541));
    }
}