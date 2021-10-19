package util.validation;

import java.util.regex.Pattern;

public class DateValidator implements Validator<String> {
    private static final String DATE_REGEX = "^[0-9]{1,2}[-/\\.][0-9]{1,2}[-/\\.][0-9]{2,4}$";

    private static Pattern pattern = Pattern.compile(DATE_REGEX);

    @Override
    public boolean check(String date) {
        if (date == null) return false;
        return pattern.matcher(date).matches();
    }

    @Override
    public String correct(String date) {
        return null;
    }
}
