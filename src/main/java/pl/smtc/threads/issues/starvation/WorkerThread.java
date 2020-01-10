package pl.smtc.threads.issues.starvation;

public class WorkerThread implements Runnable {
    private Object lockObj;
    private String name;
    private int maxCount;

    public WorkerThread(String name, int maxCount, Object lockObj) {
        this.name = name;
        this.lockObj = lockObj;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        doWork();
        double executionTime = (System.nanoTime() - startTime) / 1E6;
        System.out.println(name + " -> executionTime: " + executionTime + "[ms]");
    }

    private void doWork() {
        for (int i = 0; i < maxCount; i++) {
            synchronized (lockObj) {
                if (i % 100 == 0) {
                    String someActionToDo = name + " -> count: " + i;
                    System.out.println(someActionToDo);
                }
            }
        }
    }
}
