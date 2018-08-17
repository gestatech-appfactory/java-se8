package be.gestatech.java.se8.regex;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;

public class AbstractRegexMatcher {

    void log(String inputString, Matcher matcher, Logger logger) {
        boolean found = false;
        while (matcher.find()) {
            logger.log(Level.INFO, String.format("I found the text [%s] starting at index [%d] and ending at index [%d].%n",  inputString, matcher.start(), matcher.end()));
            found = true;
        }
        if(!found){
            logger.log(Level.SEVERE,"No match found.%n");
        }
    }
}
