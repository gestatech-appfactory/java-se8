package be.gestatech.java.se8.regex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredefinedRegexMatcherTest {

    private RegexMatcher regexMatcher;

    @BeforeEach
    void setUp() {
        regexMatcher = new RegexMatcher();
    }

    @Test
    void shouldMatchAnyCharacter() {
        // Any character (may or may not match line terminators)
        final String dotRegex = ".";
        assertTrue(regexMatcher.matches("@", dotRegex));
        assertTrue(regexMatcher.matches("1", dotRegex));
        assertTrue(regexMatcher.matches("a", dotRegex));
        assertTrue(regexMatcher.matches("@", dotRegex));
    }

    @Test
    void shouldMatchASingleDigit() {
        // A digit: [0-9]
        final String digitRegex = "\\d";
        assertTrue(regexMatcher.matches("0", digitRegex));
        assertTrue(regexMatcher.matches("1", digitRegex));
        assertFalse(regexMatcher.matches("897", digitRegex));
        assertFalse(regexMatcher.matches("z", digitRegex));
    }

}