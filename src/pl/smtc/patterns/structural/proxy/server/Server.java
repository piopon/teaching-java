package pl.smtc.patterns.structural.proxy.server;

public abstract class Server {
    public abstract String getPage(String clientIP, String url);

    protected String getServerIp(String url) {
        String baseUrl = getBaseUrl(url);
        int ip1 = baseUrl.chars().sum() % 255;
        int ip2 = baseUrl.chars().max().orElse(100) % 255;
        int ip3 = baseUrl.chars().min().orElse(0) % 255;
        int ip4 = baseUrl.length() % 255;

        return ip1 + "." + ip2 + "." + ip3 + "." + ip4;
    }

    private String getBaseUrl(String url) {
        int forwardSlashPos = url.indexOf("/");
        int backwardSlashPos = url.indexOf("\\");
        if (forwardSlashPos == -1 && backwardSlashPos == -1) {
            return url;
        } else if (forwardSlashPos != -1 && backwardSlashPos != -1) {
            return url.substring(0, Math.min(forwardSlashPos, backwardSlashPos));
        } else if (forwardSlashPos != -1) {
            return url.substring(0, forwardSlashPos);
        } else {
            return url.substring(0, backwardSlashPos);
        }
    }
}
