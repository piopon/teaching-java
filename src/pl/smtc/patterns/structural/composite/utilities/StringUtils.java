package pl.smtc.patterns.structural.composite.utilities;

public class StringUtils {
    public static String repeat(String str, int times) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < times; i++) {
            spaces.append(str);
        }
        return spaces.toString();
    }
}
