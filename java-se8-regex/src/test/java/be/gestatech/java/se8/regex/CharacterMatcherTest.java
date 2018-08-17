package be.gestatech.java.se8.regex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterMatcherTest {

    private static final String BAT = "bat";
    private static final String CAT = "cat";
    private static final String RAT = "rat";
    private static final String HAT = "hat";

    private RegexMatcher regexMatcher;

    @BeforeEach
    void setup(){
        regexMatcher = new RegexMatcher();
    }

    @Test
    void shouldMatchSimpleClass() {
        // b, c, or r (simple class)
        final String simpleRegex = "[bcr]at";
        assertTrue(regexMatcher.matches(BAT, simpleRegex));
        assertTrue(regexMatcher.matches(CAT, simpleRegex));
        assertTrue(regexMatcher.matches(RAT, simpleRegex));
        assertFalse(regexMatcher.matches(HAT, simpleRegex));
    }

    @Test
    void shouldMatchNegation() {
        // Any character except b, c, or r (negation)
        final String negationRegex = "[^bcr]at";
        assertFalse(regexMatcher.matches(BAT, negationRegex));
        assertFalse(regexMatcher.matches(CAT, negationRegex));
        assertFalse(regexMatcher.matches(RAT, negationRegex));
        assertTrue(regexMatcher.matches(HAT, negationRegex));
    }

    @Test
    void shouldMatchRanges() {
        // a through c, or A through C, inclusive (range)
        final String rangeRegex1 = "[a-cA-C]";
        assertTrue(regexMatcher.matches("a", rangeRegex1));
        assertTrue(regexMatcher.matches("b", rangeRegex1));
        assertTrue(regexMatcher.matches("c", rangeRegex1));
        assertFalse(regexMatcher.matches("d", rangeRegex1));

        final String rangeRegex2 = "foo[1-5]";
        assertTrue(regexMatcher.matches("foo1", rangeRegex2));
        assertTrue(regexMatcher.matches("foo5", rangeRegex2));
        assertFalse(regexMatcher.matches("foo6", rangeRegex2));

        final String rangeRegex3 = "foo[^1-5]";
        assertFalse(regexMatcher.matches("foo1", rangeRegex3));
        assertFalse(regexMatcher.matches("foo5", rangeRegex3));
        assertTrue(regexMatcher.matches("foo6", rangeRegex3));
    }

    @Test
    void shouldMatchUnions() {
        // Unions to create a single character class comprised of two or more separate character classes
        final String unionRegex = "[0-4[6-8]]";
        assertTrue(regexMatcher.matches("0", unionRegex));
        assertFalse(regexMatcher.matches("5", unionRegex));
        assertTrue(regexMatcher.matches("6", unionRegex));
        assertTrue(regexMatcher.matches("8", unionRegex));
        assertFalse(regexMatcher.matches("9", unionRegex));
    }

    @Test
    void shouldMatchSingleCharacterIntersections() {
        // Single character class matching only the characters common to all of its nested classes
        final String singleCharacterIntersectionRegex = "[0-9&&[345]]";
        assertTrue(regexMatcher.matches("3", singleCharacterIntersectionRegex));
        assertTrue(regexMatcher.matches("4", singleCharacterIntersectionRegex));
        assertTrue(regexMatcher.matches("5", singleCharacterIntersectionRegex));
        assertFalse(regexMatcher.matches("2", singleCharacterIntersectionRegex));
        assertFalse(regexMatcher.matches("6", singleCharacterIntersectionRegex));
    }

    @Test
    void shouldMatchTwoRangesIntersections() {
        // Intersection of two ranges
        final String twoRangesIntersectionRegex = "[2-8&&[4-6]]";
        assertFalse(regexMatcher.matches("3", twoRangesIntersectionRegex));
        assertTrue(regexMatcher.matches("4", twoRangesIntersectionRegex));
        assertTrue(regexMatcher.matches("5", twoRangesIntersectionRegex));
        assertTrue(regexMatcher.matches("6", twoRangesIntersectionRegex));
        assertFalse(regexMatcher.matches("7", twoRangesIntersectionRegex));
    }

    @Test
    void shouldMatchSubtraction() {
        // Subtraction to negate one or more nested character classes
        final String subtractionRegex = "[0-9&&[^345]]";
        assertTrue(regexMatcher.matches("2", subtractionRegex));
        assertFalse(regexMatcher.matches("3", subtractionRegex));
        assertFalse(regexMatcher.matches("4", subtractionRegex));
        assertFalse(regexMatcher.matches("5", subtractionRegex));
        assertTrue(regexMatcher.matches("6", subtractionRegex));
        assertTrue(regexMatcher.matches("9", subtractionRegex));
    }

}