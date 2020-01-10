package pl.smtc.basics.flow.decision;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class SwitchCaseExample implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Which output block to display? [1/2/3] ");
        int whichBlock = new Scanner(System.in).nextInt();
        switch (whichBlock) {
            case 1:
                System.out.println("Output from CASE 1 block");
                break;
            case 2:
                System.out.println("Output from CASE 2 block");
                break;
            case 3:
                System.out.println("Output from CASE 3 block");
                break;
            default:
                System.out.println("Output from DEFAULT block");
                break;
        }
    }

    @Override
    public String getName() {
        return "Switch-Case statement";
    }
}
