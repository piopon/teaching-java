package pl.smtc.threads.sync.join;

public class FetchDataThread extends Thread {
    private long fetchSimTime;

    public FetchDataThread(long fetchSimTime) {
        this.fetchSimTime = fetchSimTime;
    }

    @Override
    public void run() {
        System.out.println("FetchDataThread -> run [start]");
        downloadData(fetchSimTime);
        System.out.println("FetchDataThread -> run [stop]");
    }

    private void downloadData(long fetchSimTime) {
        System.out.println("FetchDataThread -> downloading data...");
        try {
            Thread.sleep(fetchSimTime);
        } catch (InterruptedException e) {
            System.out.println("FetchDataThread -> download interrupted...");
        }
        System.out.println("FetchDataThread -> data downloaded (time: " + fetchSimTime + ")");
    }
}
