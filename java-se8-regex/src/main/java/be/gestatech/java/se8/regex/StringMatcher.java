package be.gestatech.java.se8.regex;

public class StringMatcher {
    
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
        return inputString.matches("([\\w&&[^b]])*");
    }

    /**
     * Returns true if the string contains a number less than 300
     * @param inputString The input of String type
     * @return true or false
     */
    public boolean isLessThenThreeHundred(String inputString) {
        return inputString.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*");
    }
}
