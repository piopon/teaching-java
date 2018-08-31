package pl.smtd.menu;

import java.util.Collections;

public class ConsoleText {
    public static int LEFT = 0;
    public static int RIGHT = 1;
    public static int CENTER = 2;
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
        this.text = this.text.trim();
        return this;
    }

    public ConsoleText repeat(int times) {
        this.text = repeat(this.text, times);
        return this;
    }

    public ConsoleText align(int alignment) {
        int freespace = width - text.length();
        if (alignment == LEFT) {
            this.text = this.text + repeat(" ", freespace);
        } else if (alignment == RIGHT) {
            this.text = repeat(" ", freespace) + this.text;
        } else if (alignment == CENTER) {
            int afterSpace = (freespace % 2 == 0) ? freespace / 2 : freespace / 2 + 1;
            this.text = repeat(" ", freespace / 2) + this.text + repeat(" ", afterSpace);
        }
        return this;
    }

    public ConsoleText frame(String frameStr) {
        StringBuilder sb = new StringBuilder("  " + text.substring(0, width - 2));
        sb.replace(0, 2, frameStr + " ");
        sb.replace(text.length() - 2, text.length(), " " + frameStr);
        this.text = sb.toString();
        return this;
    }

    private String repeat(String input, int times) {
        return String.join("", Collections.nCopies(times, input));
    }
}
