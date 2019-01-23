package pl.smtc.algorithms.math.bits.gray;

import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrayCode implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of bits: ");
        int size = in.nextInt();
        System.out.println(size + " BIT GRAY CODE");
        printGrayCode(getGrayCode(size));
    }

    @Override
    public String getName() {
        return "Gray code generator";
    }

    public List<String> getGrayCode(int bitCount) {
        if (bitCount <= 0) {
            throw new IllegalArgumentException("Bit count value must be > 0.");
        }
        List<String> result = new ArrayList<>();
        result.add("0");
        result.add("1");

        for (int i = 2; i < (1 << bitCount); i = i << 1) {
            for (int j = i - 1; j >= 0; j--) {
                result.add(result.get(j));
            }

            for (int j = 0; j < i; j++) {
                result.set(j, "0" + result.get(j));
            }

            for (int j = i; j < 2 * i; j++) {
                result.set(j, "1" + result.get(j));
            }
        }
        return result;
    }

    private void printGrayCode(final List<String> code) {
        for (int i = 0; i < code.size(); i++) {
            System.out.println(code.get(i));
        }
    }
}
