package pl.smtc.patterns.behavioral.strategy.strategies;

import java.security.InvalidParameterException;

public class NoMove implements IMove {
    @Override
    public void move() throws InvalidParameterException {
        System.out.println("  Move not supported.");
    }
}
