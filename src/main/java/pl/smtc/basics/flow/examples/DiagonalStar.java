package pl.smtc.basics.flow.examples;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class DiagonalStar implements ConsoleExample {
    @Override
    public void execute() {
        try {
            System.out.print("How big star to print? ");
            printStar(new Scanner(System.in).nextInt());
        } catch (Exception e) {
            System.out.println("Cannot print star. " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Diagonal star";
    }

    private void printStar(int size) {
        if(size < 5) {
            System.out.println("Cannot print star smaller than 5.");
            return;
        }
        for(int row = 1; row <= size; row++) {
            StringBuilder currentLine = new StringBuilder();
            for(int col = 1; col <= size; col++) {
                if (row == 1 || row == size) {
                    currentLine.append("*");
                } else if (col == 1 || col == size) {
                    currentLine.append("*");
                } else if (col == row) {
                    currentLine.append("*");
                } else if (col == size - row + 1) {
                    currentLine.append("*");
                } else {
                    currentLine.append(" ");
                }
            }
            System.out.println(currentLine);
        }
    }
}
