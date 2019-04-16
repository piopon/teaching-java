package pl.smtc.patterns.structural.proxy.server;

import java.util.*;

public class ProxyServer extends Server {
    private static final String MY_IP = "192.168.0.254";
    private Map<String, String> cachedUrls = new HashMap<>();
    private RealServer realServer = new RealServer();

    @Override
    public String getPage(String clientIP, String url) {
        if (blockAccess(clientIP, url)) {
            System.out.println("ERROR 403 - access forbidden!");
            return "ERROR_403";
        }
        if(cachedUrls.keySet().contains(url)) {
            System.out.println("Sending cached url: " + url + " to " + clientIP);
            return cachedUrls.get(url);
        } else {
            String page = realServer.getPage(MY_IP, url);
            cachedUrls.put(url, page);
            System.out.println("Passing page: " + url + " from " + MY_IP + " to " + clientIP);
            return page;
        }
    }

    private boolean blockAccess(String clientIP, String url) {
        List<String> ipFilter = Arrays.asList("192.168.0.1","192.168.0.2","192.168.0.3","192.168.0.10");
        List<String> urlFilter = Arrays.asList("www.facebook.com","www.twitter.com");

        return ipFilter.contains(clientIP) && urlFilter.contains(url);
    }
}
