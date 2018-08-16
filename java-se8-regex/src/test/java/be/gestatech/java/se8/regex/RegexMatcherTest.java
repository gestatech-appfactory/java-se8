package be.gestatech.java.se8.regex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexMatcherTest {

    private RegexMatcher regexMatcher;

    @BeforeEach
    public void setup(){
        regexMatcher = new RegexMatcher();
    }

    @Test
    void shouldBeTrue() {
        assertTrue(regexMatcher.isTrue("true"));
        assertFalse(regexMatcher.isTrue("true2"));
        assertFalse(regexMatcher.isTrue("True"));
    }

    @Test
    void shouldBeTrueVersion2() {
        assertTrue(regexMatcher.isTrueVersion2("true"));
        assertFalse(regexMatcher.isTrueVersion2("true2"));
        assertTrue(regexMatcher.isTrueVersion2("True"));;
    }

    @Test
    void shouldBeTrueOrYes() {
        assertTrue(regexMatcher.isTrueOrYes("true"));
        assertTrue(regexMatcher.isTrueOrYes("yes"));
        assertTrue(regexMatcher.isTrueOrYes("Yes"));
        assertFalse(regexMatcher.isTrueOrYes("no"));
    }

    @Test
    void shouldContainsTrue() {
        assertTrue(regexMatcher.containsTrue("thetruewithin"));
    }

    @Test
    void shouldBeThreeLetters() {
        assertTrue(regexMatcher.isThreeLetters("abc"));
        assertFalse(regexMatcher.isThreeLetters("abcd"));
    }

    @Test
    void shouldNotBeNumberAtBeginning() {
        assertTrue(regexMatcher.isNoNumberAtBeginning("abc"));
        assertFalse(regexMatcher.isNoNumberAtBeginning("1abcd"));
        assertTrue(regexMatcher.isNoNumberAtBeginning("a1bcd"));
        assertTrue(regexMatcher.isNoNumberAtBeginning("asdfdsf"));
    }

    @Test
    void shouldBeIntersection() {
        assertTrue(regexMatcher.isIntersection("1"));
        assertFalse(regexMatcher.isIntersection("abcksdfkdskfsdfdsf"));
        assertTrue(regexMatcher.isIntersection("skdskfjsmcnxmvjwque484242"));
    }

    @Test
    void shouldBeLessThenThreeHundred() {
        assertTrue(regexMatcher.isLessThanThreeHundred("288"));
        assertFalse(regexMatcher.isLessThanThreeHundred("288 "));
        assertFalse(regexMatcher.isLessThanThreeHundred("288Z"));
        assertFalse(regexMatcher.isLessThanThreeHundred("3288"));
        assertFalse(regexMatcher.isLessThanThreeHundred("328 8"));
        assertTrue(regexMatcher.isLessThanThreeHundred("1"));
        assertTrue(regexMatcher.isLessThanThreeHundred("99"));
        assertFalse(regexMatcher.isLessThanThreeHundred("300"));
    }
}