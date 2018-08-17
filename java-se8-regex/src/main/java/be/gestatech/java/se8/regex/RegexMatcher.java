package be.gestatech.java.se8.regex;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher extends AbstractRegexMatcher {

    private final static Logger LOGGER = Logger.getLogger(RegexMatcher.class.getName());

    public boolean matches(String inputString, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        log(inputString, matcher, LOGGER);
        return inputString.matches(regex);
    }
}
