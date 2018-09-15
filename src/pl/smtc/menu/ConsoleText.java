package pl.smtc.menu;

import java.util.Collections;

public class ConsoleText {
    private String text;
    private int width;

    public ConsoleText(String text, int width) {
        this.text = text;
        this.width = width;
    }

    public String print() {
        return text;
    }

    public ConsoleText trim() {
        text = text.trim();
        return this;
    }

    public ConsoleText repeat(int times) {
        text = repeat(text, times);
        return this;
    }

    public ConsoleText align(ConsoleAlign alignment) {
        int freespace = width - text.length();
        if (alignment == ConsoleAlign.LEFT) {
            text = text + repeat(" ", freespace);
        } else if (alignment == ConsoleAlign.RIGHT) {
            text = repeat(" ", freespace) + text;
        } else if (alignment == ConsoleAlign.CENTER) {
            int afterSpace = (freespace % 2 == 0) ? freespace / 2 : freespace / 2 + 1;
            text = repeat(" ", freespace / 2) + text + repeat(" ", afterSpace);
        }
        return this;
    }

    public ConsoleText frame(String frameStr) {
        StringBuilder sb = new StringBuilder(text);
        sb.replace(0, 1, frameStr);
        sb.replace(text.length() - 1, text.length(), frameStr);
        text = sb.toString();
        return this;
    }

    public ConsoleText indent(int indentation) {
        text = repeat(" ", indentation) + text;
        text = text.substring(0, text.length() - indentation);
        return this;
    }

    private String repeat(String input, int times) {
        return String.join("", Collections.nCopies(times, input));
    }
}
