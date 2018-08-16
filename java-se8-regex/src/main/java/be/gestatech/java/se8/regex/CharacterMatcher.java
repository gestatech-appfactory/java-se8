package be.gestatech.java.se8.regex;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterMatcher {

    private final static Logger LOGGER = Logger.getLogger(CharacterMatcher.class.getName());

    public boolean matchCharacter(String inputString, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        log(inputString, matcher);
        return inputString.matches(regex);
    }

    private void log(String inputString, Matcher matcher) {
        boolean found = false;
        while (matcher.find()) {
            LOGGER.log(Level.INFO, String.format("I found the text [%s] starting at index [%d] and ending at index [%d].%n",  inputString, matcher.start(), matcher.end()));
            found = true;
        }
        if(!found){
            LOGGER.log(Level.SEVERE,"No match found.%n");
        }
    }
}
