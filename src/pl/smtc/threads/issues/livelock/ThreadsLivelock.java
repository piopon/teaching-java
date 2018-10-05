package pl.smtc.threads.issues.livelock;

import pl.smtc.menu.ConsoleExample;

public class ThreadsLivelock implements ConsoleExample {
    PoliteWorker worker1 = new PoliteWorker(1, true);
    PoliteWorker worker2 = new PoliteWorker(2, true);
    final IncrementValue incrementValue = new IncrementValue(worker1, 100);

    @Override
    public void execute() {
        try {
            Thread thread1 = createThread(worker1, worker2);
            Thread thread2 = createThread(worker2, worker1);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("> livelock example interrupted.");
        }
        System.out.println("> livelock increment value: " + incrementValue.getValue());
    }

    @Override
    public String getName() {
        return "Threads livelock";
    }

    private Thread createThread(PoliteWorker self, PoliteWorker other) {
        return new Thread(() -> self.doWork(incrementValue, other));
    }
}
