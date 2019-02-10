package pl.smtc.patterns.behavioral.strategy.strategies;

import java.security.InvalidParameterException;
import java.util.List;

public interface IMove {
    default void setPositions(List<String> positions) {
        //default = no actions performed
    }

    default void setSpeed(int speed) {
        //default = no actions performed
    }

    default String getType() {
        return "";
    }

    void move() throws InvalidParameterException;
}
