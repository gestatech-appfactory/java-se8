package be.gestatech.java.se8.regex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMatcherTest {

    private StringMatcher stringMatcher;

    @BeforeEach
    public void setup(){
        stringMatcher = new StringMatcher();
    }

    @Test
    void shouldBeTrue() {
        assertTrue(stringMatcher.isTrue("true"));
        assertFalse(stringMatcher.isTrue("true2"));
        assertFalse(stringMatcher.isTrue("True"));
    }

    @Test
    void shouldBeTrueVersion2() {
        assertTrue(stringMatcher.isTrueVersion2("true"));
        assertFalse(stringMatcher.isTrueVersion2("true2"));
        assertTrue(stringMatcher.isTrueVersion2("True"));;
    }

    @Test
    void shouldBeTrueOrYes() {
        assertTrue(stringMatcher.isTrueOrYes("true"));
        assertTrue(stringMatcher.isTrueOrYes("yes"));
        assertTrue(stringMatcher.isTrueOrYes("Yes"));
        assertFalse(stringMatcher.isTrueOrYes("no"));
    }

    @Test
    void shouldContainsTrue() {
        assertTrue(stringMatcher.containsTrue("thetruewithin"));
    }

    @Test
    void shouldBeThreeLetters() {
        assertTrue(stringMatcher.isThreeLetters("abc"));
        assertFalse(stringMatcher.isThreeLetters("abcd"));
    }

    @Test
    void shouldNotBeNumberAtBeginning() {
        assertTrue(stringMatcher.isNoNumberAtBeginning("abc"));
        assertFalse(stringMatcher.isNoNumberAtBeginning("1abcd"));
        assertTrue(stringMatcher.isNoNumberAtBeginning("a1bcd"));
        assertTrue(stringMatcher.isNoNumberAtBeginning("asdfdsf"));
    }

    @Test
    void shouldBeIntersection() {
        assertTrue(stringMatcher.isIntersection("1"));
        assertFalse(stringMatcher.isIntersection("abcksdfkdskfsdfdsf"));
        assertTrue(stringMatcher.isIntersection("skdskfjsmcnxmvjwque484242"));
    }

    @Test
    void shouldBeLessThenThreeHundred() {
        assertTrue(stringMatcher.isLessThanThreeHundred("288"));
        assertFalse(stringMatcher.isLessThanThreeHundred("288 "));
        assertFalse(stringMatcher.isLessThanThreeHundred("288Z"));
        assertFalse(stringMatcher.isLessThanThreeHundred("3288"));
        assertFalse(stringMatcher.isLessThanThreeHundred("328 8"));
        assertTrue(stringMatcher.isLessThanThreeHundred("1"));
        assertTrue(stringMatcher.isLessThanThreeHundred("99"));
        assertFalse(stringMatcher.isLessThanThreeHundred("300"));
    }
}