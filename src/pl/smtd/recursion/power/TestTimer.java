package pl.smtd.recursion.power;

import java.util.function.BiFunction;

public class TestTimer {
    private BiFunction<Double, Integer, Double> function;
    private long time;
    private double result;
    private double doubleArg;
    private int intArg;

    public TestTimer(BiFunction<Double, Integer, Double> function) {
        this.function = function;
    }

    public void execute(double doubleNum, int intNum) {
        long timeStart = System.nanoTime();
        result = function.apply(doubleNum, intNum);
        long timeStop = System.nanoTime();
        //store data
        doubleArg = doubleNum;
        intArg = intNum;
        time = timeStop - timeStart;
    }

    public void summary(String title) {
        String resultMessage = doubleArg + " ^ " + intArg + " = " + result;
        String timeMessage = "time = " + time + "ns";
        System.out.println(title + ": " + resultMessage + " [ " + timeMessage + " ]");
    }
}
