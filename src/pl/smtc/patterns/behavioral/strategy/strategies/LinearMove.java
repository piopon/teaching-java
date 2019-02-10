package pl.smtc.patterns.behavioral.strategy.strategies;

import java.security.InvalidParameterException;
import java.util.List;

public class LinearMove implements IMove {
    private static final int POSITIONS_COUNT = 1;
    protected List<String> positions;
    protected int speed;

    @Override
    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String getType() {
        return "MoveL";
    }

    @Override
    public void move() throws InvalidParameterException {
        if (speed <= 0) {
            throw new InvalidParameterException("Speed cannot be zero.");
        }
        if (positions.size() != POSITIONS_COUNT) {
            throw new InvalidParameterException("You must specify one destination point.");
        }
        System.out.println("  Linear move to " + positions.get(0) + " [speed: " + speed + "mm/s]");
    }
}
