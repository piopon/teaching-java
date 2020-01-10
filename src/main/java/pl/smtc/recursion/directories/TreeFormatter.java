package pl.smtc.recursion.directories;

public class TreeFormatter {
    private static String INDENT = "    ";
    private static String PATH = "|";
    private static String ELEMENT = "+--- ";
    private static String ROOT = ">>> ";
    private int indentLevel = 0;

    public String goLevelDown() {
        indentLevel++;

        return repeat(INDENT + PATH, indentLevel);
    }

    public String goLevelUp() {
        indentLevel--;

        return indentLevel > 0 ? INDENT + PATH : "";
    }

    public String printDir(String dirName) {
        return repeat(INDENT, indentLevel) + (indentLevel == 0 ? ROOT : ELEMENT) + dirName;
    }

    public String printFile(String fileName) {
        return repeat(INDENT + PATH, indentLevel - 1) + INDENT + ELEMENT + fileName;
    }

    private String repeat(String str, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result = str + result;
        }
        return result;
    }
}
