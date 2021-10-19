package util.validation;

import java.util.regex.Pattern;

public class EmailValidator implements Validator<String> {
    private static final String EMAIL_REGEX
            = "^[A-Za-z0-9]+[\\.]?[A-Za-z0-9]+[\\.]?[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$";

    private static Pattern pattern = Pattern.compile(EMAIL_REGEX);
    
    @Override
    public boolean check(String email) {
        if (email == null) return false;
        return pattern.matcher(email).matches();
    }

    @Override
    public String correct(String email) {
        return null;
    }
}
