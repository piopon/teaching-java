package pl.smtc.patterns.behavioral.strategy.context;

import pl.smtc.patterns.behavioral.strategy.strategies.IMove;
import pl.smtc.patterns.behavioral.strategy.strategies.NoMove;

import java.util.ArrayList;
import java.util.Arrays;

public class Robot {
    private String manufacturer;
    private String model;
    private IMove linearMove = new NoMove();
    private IMove jointMove = new NoMove();
    private IMove circularMove = new NoMove();

    public Robot(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void configureMovement(IMove linearMove, IMove jointMove, IMove circularMove) {
        this.linearMove = linearMove;
        this.jointMove = jointMove;
        this.circularMove = circularMove;
    }

    public void moveL(String position, int speed) {
        showIdentity();
        linearMove.setPositions(new ArrayList<>(Arrays.asList(position)));
        linearMove.setSpeed(speed);
        linearMove.move();
    }

    public void moveJ(String position, int speed) {
        showIdentity();
        jointMove.setPositions(new ArrayList<>(Arrays.asList(position)));
        jointMove.setSpeed(speed);
        jointMove.move();
    }

    public void moveC(String midPosition, String destPosition, int speed) {
        showIdentity();
        circularMove.setPositions(new ArrayList<>(Arrays.asList(midPosition, destPosition)));
        circularMove.setSpeed(speed);
        circularMove.move();
    }

    private void showIdentity() {
        System.out.println("* " + manufacturer + " " + model);
    }
}
