package pl.smtc.threads.sync.join;

public class ProcessDataThread implements Runnable {
    private FetchDataThread superThread;
    private long timeToWait;
    private long processSimTime;

    public ProcessDataThread(FetchDataThread superThread, long timeToWait, long processSimTime) {
        this.superThread = superThread;
        this.timeToWait = timeToWait;
        this.processSimTime = processSimTime;
    }

    @Override
    public void run() {
        System.out.println("ProcessDataThread -> run [start]");
        if (waitForData(timeToWait)) {
            processData(processSimTime);
        }
        System.out.println("ProcessDataThread -> run [stop]");
    }

    private boolean waitForData(long maxTime) {
        try {
            System.out.println("ProcessDataThread -> waiting for data...");
            superThread.join(maxTime);
            System.out.println("ProcessDataThread -> data received!");
        } catch (InterruptedException e) {
            System.out.println("ProcessDataThread -> data receive interrupted!");
            return false;
        }
        return true;
    }

    private void processData(long simTime) {
        try {
            System.out.println("ProcessDataThread -> processing data...");
            superThread.sleep(simTime);
            System.out.println("ProcessDataThread -> data ready!");
        } catch (InterruptedException e) {
            System.out.println("ProcessDataThread -> data processing interrupted!");
        }
    }
}
