package pl.smtc.recursion.power;

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

    public Double getResult() {
        return result;
    }

    public String getSummary(String title) {
        String resultMessage = doubleArg + " ^ " + intArg + " = " + getResult();
        String timeMessage = "time = " + time + "ns";
        return title + ": " + resultMessage + " [ " + timeMessage + " ]";
    }
}
