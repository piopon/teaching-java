package pl.smtc.patterns.behavioral.strategy;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.behavioral.strategy.context.Robot;
import pl.smtc.patterns.behavioral.strategy.strategies.*;

public class StrategyPattern implements ConsoleExample {

    @Override
    public void execute() {
        Robot kawasakiRobot = createRobot("Kawasaki", "ZH100U",
                new LinearMove(), new JointMove(), new CircularMove());
        Robot abbRobot = createRobot("ABB", "IRB-1600L",
                new LinearMove(), new JointMove(), new CircularMove());
        Robot toyRobot = createRobot("Model robot", "R2D2",
                new NoMove(), new NoMove(), new NoMove());
        Robot cleaningRobot = createRobot("IRobot", "Roomba 980",
                new LinearMove(), new NoMove(), new NoMove());

        abbRobot.moveL("linearPosition", 300);
        kawasakiRobot.moveJ("destJoint", 100);
        toyRobot.moveL("destPosition", 10);
        kawasakiRobot.moveC("mid","dest", 150);
        cleaningRobot.moveL("clean", 25);
    }

    @Override
    public String getName() {
        return "Strategy pattern";
    }

    private Robot createRobot(String manufacturer, String model, IMove moveL, IMove moveJ, IMove moveC) {
        Robot robot = new Robot(manufacturer, model);
        robot.configureMovement(moveL, moveJ, moveC);

        return robot;
    }
}
