package pl.smtc.patterns.structural.proxy.server;

public class RealServer extends Server {
    @Override
    public String getPage(String clientIP, String url) {
        try {
            String serverIP = getServerIp(url);
            System.out.print("Retrieving page " + url + "...");
            Thread.sleep(100);
            System.out.println(" and sending from " + serverIP + " to " + clientIP);
            return "A very long string from: " + serverIP + " - " + url;
        } catch (InterruptedException e) {
            System.out.println("ERROR 404 - no page exists!");
            return "ERROR_404";
        }
    }
}
