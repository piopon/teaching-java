package pl.smtc.threads.issues.livelock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncrementValueTest {
    IncrementValue incrementValue;
    PoliteWorker politeWorker;

    @BeforeEach
    void setUp() {
        politeWorker = new PoliteWorker(41, false);
        incrementValue = new IncrementValue(politeWorker, 0);
    }

    @Test
    void getOwnerShouldReturnPoliteWorker() {
        assertEquals(politeWorker, incrementValue.getOwner());
    }

    @Test
    void getValueShouldReturnCorrectValue() {
        assertEquals(0, incrementValue.getValue());
        incrementValue.increment(3);
        assertEquals(3, incrementValue.getValue());
    }

    @Test
    void ownersLimitReachedShouldReturnFalseWhenOwnersNotReached() {
        assertEquals(false, incrementValue.ownersLimitReached());
    }

    @Test
    void ownersLimitReachedShouldReturnTrueWhenOwnersReached() {
        incrementValue.setOwner(politeWorker);
        assertEquals(true, incrementValue.ownersLimitReached());
    }

    @Test
    void ownersLimitReachedShouldReturnFalseAfterIncrementing() {
        incrementValue.setOwner(politeWorker);
        incrementValue.increment(0);
        assertEquals(false, incrementValue.ownersLimitReached());
    }

    @Test
    void setOwnerShouldSetNewOwner() {
        assertEquals(politeWorker, incrementValue.getOwner());
        PoliteWorker newPoliteWorker = new PoliteWorker(1,false);
        incrementValue.setOwner(newPoliteWorker);
        assertEquals(newPoliteWorker, incrementValue.getOwner());
    }

    @Test
    void incrementShouldUpdateValueInputtedNumberOfTimes() {
        incrementValue.increment(10);
        assertEquals(10, incrementValue.getValue());
    }
}