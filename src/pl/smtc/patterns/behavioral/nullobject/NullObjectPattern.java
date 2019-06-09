package pl.smtc.patterns.behavioral.nullobject;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.behavioral.nullobject.base.Shape;
import pl.smtc.patterns.behavioral.nullobject.nil.NullShape;
import pl.smtc.patterns.behavioral.nullobject.real.Circle;
import pl.smtc.patterns.behavioral.nullobject.real.Rectangle;
import pl.smtc.patterns.behavioral.nullobject.real.Triangle;

import java.util.Scanner;

public class NullObjectPattern implements ConsoleExample {

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        System.out.println("SHAPE BASIC INFORMATION");
        while (true) {
            System.out.print("Input shape type [Q to quit]: ");
            String shapeType = input.nextLine();

            if (shapeType.equalsIgnoreCase("q")) {
                break;
            }

            Shape shape = createShape(shapeType);
            shape.draw();
            System.out.println("PERIMETER: " + shape.getPerimeter());
            System.out.println("AREA: " + shape.getArea());
        }
    }

    @Override
    public String getName() {
        return "Null object pattern";
    }

    protected Shape createShape(String shape) {
        if (shape.equalsIgnoreCase("circle")) {
            return new Circle(2.5);
        } else if (shape.equalsIgnoreCase("rectangle")) {
            return new Rectangle(10.0,1.5);
        } else if (shape.equalsIgnoreCase("triangle")) {
            return new Triangle(3.0, 4.0, 5.0);
        } else {
            return new NullShape(shape);
        }
    }
}
