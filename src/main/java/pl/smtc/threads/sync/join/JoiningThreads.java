package pl.smtc.threads.sync.join;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class JoiningThreads implements ConsoleExample {
    private int fetchSimTime;
    private int fetchWaitTime;
    private int processSimTime;

    public JoiningThreads() {
        this.fetchSimTime = 1000;
        this.fetchWaitTime = 2000;
        this.processSimTime = 1000;
    }

    public JoiningThreads(int fetchSimTime, int fetchWaitTime, int processSimTime) {
        this.fetchSimTime = fetchSimTime;
        this.fetchWaitTime = fetchWaitTime;
        this.processSimTime = processSimTime;
    }

    @Override
    public void execute() {
        FetchDataThread fetchDataThread = new FetchDataThread(fetchSimTime);
        Thread processDataThread = new Thread(new ProcessDataThread(fetchDataThread, fetchWaitTime, processSimTime));
        Thread viewDataThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ViewDataThread -> run [start]");
                try {
                    System.out.println("ViewDataThread -> waiting for data to be processed...");
                    processDataThread.join();
                    System.out.println("ViewDataThread -> data OK! Viewing it...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ViewDataThread -> run [stop]");
            }
        });

        Scanner in = new Scanner(System.in);
        System.out.println("> press Enter to start simulation of data processing.");
        in.nextLine();
        fetchDataThread.start();
        processDataThread.start();
        viewDataThread.start();

        threadWait(viewDataThread,200);
        System.out.println("> data process simulation finished!");
    }

    @Override
    public String getName() {
        return "Joining threads";
    }

    private void threadWait(Thread thread, int millis) {
        do {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                System.out.print("Interrupt while sleeping...");
            }
        } while (thread.isAlive());
    }
}
