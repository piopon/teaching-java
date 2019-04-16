package pl.smtc.patterns.structural.proxy;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.structural.proxy.server.Server;
import pl.smtc.patterns.structural.proxy.server.ProxyServer;
import pl.smtc.patterns.structural.proxy.server.RealServer;

import java.util.Scanner;
import java.util.Set;

public class ProxyPattern implements ConsoleExample {
    private final static String EXIT_CMD = "EXIT";
    private final Server proxyServer = new ProxyServer();
    private final Server realServer = new RealServer();

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String client = "192.168.0.10";
        while (true) {
            System.out.print("Input URL [" + EXIT_CMD + " to quit]: ");
            String url = scanner.nextLine();
            if (url.equalsIgnoreCase(EXIT_CMD)) {
                break;
            }
            System.out.print("Use proxy server? [Y/N] ");
            boolean useProxy = scanner.nextLine().equalsIgnoreCase("y");
            Server server = useProxy ? proxyServer : realServer;
            String page = server.getPage(client, url);
            System.out.println("VIEWING PAGE (source: " + page + ")");
        }
    }

    @Override
    public String getName() {
        return "Proxy pattern";
    }
}
