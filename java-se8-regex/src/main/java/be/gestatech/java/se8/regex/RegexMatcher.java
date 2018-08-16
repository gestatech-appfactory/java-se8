package be.gestatech.java.se8.regex;

public class RegexMatcher {
    
    public boolean isTrue(String inputString) {
        return inputString.matches("true");
    }
    
    public boolean isTrueVersion2(String s) {
        return s.matches("[tT]rue");
    }
    
    public boolean isTrueOrYes(String inputString) {
        return inputString.matches("[tT]rue|[yY]es");
    }
    
    public boolean containsTrue(String inputString) {
        return inputString.matches(".*true.*");
    }
    
    public boolean isThreeLetters(String inputString) {
        return inputString.matches("[a-zA-Z]{3}");
    }
    
    public boolean isNoNumberAtBeginning(String inputString) {
        return inputString.matches("^[^\\d].*");
    }

    /**
     * Returns true if the string contains a arbitrary number of characters except b
     * @param inputString The input of String type
     * @return true or false
     */
    public boolean isIntersection(String inputString) {
        // \w  word character, short for [a-zA-Z_0-9] and (intersection)
        // [^b] except b.
        // X* finds no or several letter X
        return inputString.matches("([\\w&&[^b]])*");
    }

    /**
     * Returns true if the string contains a number less than 300
     * @param inputString The input of String type
     * @return true or false
     */
    public boolean isLessThanThreeHundred(String inputString) {
        // [^0-9] Any character except figures from 0 to 9

        // X* finds no or several letter X

        // [12] match the figure 1 or 2.

        // ? Occurs no or one times, ? is short for {0,1}.

        // {X,Y} Occurs between X and Y times. after a quantifier makes it a reluctant quantifier.
        // It tries to find the smallest match. This makes the regular expression stop at the first match.
        return inputString.matches("[^0-9]*[12]?[0-9]{1,2}[^\\s|^\\w]*") ||
                // \D A non-digit, short for [^0-9]
                inputString.matches("\\D*[12]?[0-9]{1,2}[^\\s|^\\w]*");
    }
}
