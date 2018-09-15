package pl.smtc.recursion.dec2bin;

public class BinaryFormatter {

    public static String formatBin(String bin, int bitsPerGroup ) {
        return divideGroup(fillToGroup(bin, bitsPerGroup), bitsPerGroup);
    }

    private static String fillToGroup(String input, int groupSize) {
        String output = input;
        int groups = (input.length() / groupSize) + (input.length() % groupSize);
        for (int i = 0; i < groups * groupSize - input.length(); i++) {
            output = "0" + output;
        }
        return output;
    }

    private static String divideGroup(String input, int groupSize) {
        StringBuilder out = new StringBuilder(input);
        int divideCount = input.length() / groupSize - 1;
        for (int i = divideCount; i > 0; i--) {
            out.insert(i * groupSize, " ");
        }
        return out.toString();
    }
}
