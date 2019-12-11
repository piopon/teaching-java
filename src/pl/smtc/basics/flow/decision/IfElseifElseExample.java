package pl.smtc.basics.flow.decision;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class IfElseifElseExample implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Which output block to display? [if/elseif] ");
        String whichBlock = new Scanner(System.in).next();
        if ("if".equalsIgnoreCase(whichBlock)) {
            System.out.println("Output from IF block");
        } else if("elseif".equalsIgnoreCase(whichBlock)) {
            System.out.println("Output from ELSE-IF block");
        } else {
            System.out.println("Output from ELSE block");
        }
    }

    @Override
    public String getName() {
        return "If-ElseIf-Else statement";
    }
}
