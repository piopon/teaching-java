package pl.smtc.algorithms.math.sphenic;

import pl.smtc.menu.ConsoleExample;

import java.util.*;

public class SphenicNumbers implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input integer: ");
        int input = in.nextInt();
        String status = "is" + (isSphenic(input) ? " " : " NOT ") + "a sphenic number.";
        System.out.println("Number " + input + " " + status);
    }

    @Override
    public String getName() {
        return "Sphenic numbers";
    }

    public boolean isSphenic(int number) {
        Set<Integer> set = new HashSet<>();
        List<Integer> primeFactors = leastPrimeFactors(1000);
        while (number > 1) {
            int lpf = primeFactors.get(number);
            int init_size = set.size();
            set.add(lpf);
            if (set.size() == init_size || set.size() > 3) {
                return false;
            }
            number /= lpf;
        }
        return (set.size() == 3);
    }

    private List<Integer> leastPrimeFactors(int size) {
        Integer[] result = new Integer[size + 1];
        Arrays.fill(result, 0);
        result[1] = 1;
        for (int i = 2; i <= size; i++) {
            if (result[i] == 0) {
                result[i] = i;
                for (int j = 2*i; j <= size; j += i) {
                    if (result[j] == 0) {
                        result[j] = i;
                    }
                }
            }
        }
        return Arrays.asList(result);
    }
}
