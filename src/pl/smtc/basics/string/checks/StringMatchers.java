package pl.smtc.basics.string.checks;

import pl.smtc.menu.ConsoleExample;

public class StringMatchers implements ConsoleExample {
    private final static String POSTAL_CODE_REGEX = "\\d{2}-\\d{3}";
    @Override
    public void execute() {
        regexMatchers();
    }

    @Override
    public String getName() {
        return "Regex matchers";
    }

    private void regexMatchers() {
        String okPostalCode = "82-400";
        boolean okZip = okPostalCode.matches(POSTAL_CODE_REGEX);
        System.out.println("Is \'" + okPostalCode + "\' valid zip code: " + okZip);
        String badPostalCode = "82400";
        boolean nokZip = badPostalCode.matches(POSTAL_CODE_REGEX);
        System.out.println("Is \'" + badPostalCode + "\' valid zip code: " + nokZip);
    }
}
