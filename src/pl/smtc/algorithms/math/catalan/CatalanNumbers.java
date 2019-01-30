package pl.smtc.algorithms.math.catalan;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class CatalanNumbers implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("How many catalan numbers to print: ");
        int counter = in.nextInt();
        for (int i = 0; i < counter; i++) {
            System.out.println("C(" + i + ") = " + catalan(i));
        }
    }

    @Override
    public String getName() {
        return "Catalan numbers";
    }

    public int catalan(int n) {
        int result = 0;
        if(n <= 1) {
            return 1;
        }
        for(int i = 0; i < n; i++) {
            result += catalan(i) * catalan(n-i-1);
        }
        return result;
    }
}
