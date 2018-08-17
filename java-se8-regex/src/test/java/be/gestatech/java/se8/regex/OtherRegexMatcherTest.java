package be.gestatech.java.se8.regex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OtherRegexMatcherTest {

    private OtherRegexMatcher otherRegexMatcher;

    @BeforeEach
    void setup(){
        otherRegexMatcher = new OtherRegexMatcher();
    }

    @Test
    void shouldBeTrue() {
        assertTrue(otherRegexMatcher.isTrue("true"));
        assertFalse(otherRegexMatcher.isTrue("true2"));
        assertFalse(otherRegexMatcher.isTrue("True"));
    }

    @Test
    void shouldBeTrueVersion2() {
        assertTrue(otherRegexMatcher.isTrueVersion2("true"));
        assertFalse(otherRegexMatcher.isTrueVersion2("true2"));
        assertTrue(otherRegexMatcher.isTrueVersion2("True"));;
    }

    @Test
    void shouldBeTrueOrYes() {
        assertTrue(otherRegexMatcher.isTrueOrYes("true"));
        assertTrue(otherRegexMatcher.isTrueOrYes("yes"));
        assertTrue(otherRegexMatcher.isTrueOrYes("Yes"));
        assertFalse(otherRegexMatcher.isTrueOrYes("no"));
    }

    @Test
    void shouldContainsTrue() {
        assertTrue(otherRegexMatcher.containsTrue("thetruewithin"));
    }

    @Test
    void shouldBeThreeLetters() {
        assertTrue(otherRegexMatcher.isThreeLetters("abc"));
        assertFalse(otherRegexMatcher.isThreeLetters("abcd"));
    }

    @Test
    void shouldNotBeNumberAtBeginning() {
        assertTrue(otherRegexMatcher.isNoNumberAtBeginning("abc"));
        assertFalse(otherRegexMatcher.isNoNumberAtBeginning("1abcd"));
        assertTrue(otherRegexMatcher.isNoNumberAtBeginning("a1bcd"));
        assertTrue(otherRegexMatcher.isNoNumberAtBeginning("asdfdsf"));
    }

    @Test
    void shouldBeIntersection() {
        assertTrue(otherRegexMatcher.isIntersection("1"));
        assertFalse(otherRegexMatcher.isIntersection("abcksdfkdskfsdfdsf"));
        assertTrue(otherRegexMatcher.isIntersection("skdskfjsmcnxmvjwque484242"));
    }

    @Test
    void shouldBeLessThenThreeHundred() {
        assertTrue(otherRegexMatcher.isLessThanThreeHundred("288"));
        assertFalse(otherRegexMatcher.isLessThanThreeHundred("288 "));
        assertFalse(otherRegexMatcher.isLessThanThreeHundred("288Z"));
        assertFalse(otherRegexMatcher.isLessThanThreeHundred("3288"));
        assertFalse(otherRegexMatcher.isLessThanThreeHundred("328 8"));
        assertTrue(otherRegexMatcher.isLessThanThreeHundred("1"));
        assertTrue(otherRegexMatcher.isLessThanThreeHundred("99"));
        assertFalse(otherRegexMatcher.isLessThanThreeHundred("300"));
    }
}