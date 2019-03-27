package pl.smtc.patterns.creational.Singleton.implementations;

public class RemoteResource {
    private static RemoteResource instance;
    private static String REMOTE_ADDRESS = "ssh@10.0.168.1";
    private boolean connected;

    private RemoteResource() {
        connected = false;
    }

    public static RemoteResource getInstance() {
        if (instance == null) {
            instance = new RemoteResource();
        }
        return instance;
    }

    public boolean isOpened() {
        return connected;
    }

    public void open() {
        if (!connected) {
            System.out.print("Opening remote resource [" + REMOTE_ADDRESS + "] ... ");
            connected = true;
            System.out.println("OK");
        } else {
            System.out.println("Remote resource [" + REMOTE_ADDRESS + "] already opened.");
        }
    }

    public void close() {
        if (connected) {
            System.out.print("Closing remote resource [" + REMOTE_ADDRESS + "] ... ");
            connected = false;
            System.out.println("OK");
        } else {
            System.out.println("Remote resource [" + REMOTE_ADDRESS + "] already closed.");
        }
    }

    public void send(String data) {
        if (connected) {
            try {
                System.out.print("Sending: " + data + " to resource [" + REMOTE_ADDRESS + "] ... ");
                Thread.sleep(100);
                System.out.println("OK");
            } catch (InterruptedException e) {
                System.out.println("ERROR. Exception thrown.");
            }
        } else {
            System.out.println("ERROR. Cannot send data: " + data + " - connection closed.");
        }
    }
}
