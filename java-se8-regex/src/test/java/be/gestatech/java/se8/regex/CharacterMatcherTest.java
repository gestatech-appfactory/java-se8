package be.gestatech.java.se8.regex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterMatcherTest {

    private static final String BAT = "bat";
    private static final String CAT = "cat";
    private static final String RAT = "rat";
    private static final String HAT = "hat";

    private CharacterMatcher characterMatcher;

    @BeforeEach
    public void setup(){
        characterMatcher = new CharacterMatcher();
    }

    @Test
    void shouldMatchSimpleClass() {
        // b, c, or r (simple class)
        final String simpleRegex = "[bcr]at";
        assertTrue(characterMatcher.matchCharacter(BAT, simpleRegex));
        assertTrue(characterMatcher.matchCharacter(CAT, simpleRegex));
        assertTrue(characterMatcher.matchCharacter(RAT, simpleRegex));
        assertFalse(characterMatcher.matchCharacter(HAT, simpleRegex));
    }

    @Test
    void shouldMatchNegation() {
        // Any character except b, c, or r (negation)
        final String negationRegex = "[^bcr]at";
        assertFalse(characterMatcher.matchCharacter(BAT, negationRegex));
        assertFalse(characterMatcher.matchCharacter(CAT, negationRegex));
        assertFalse(characterMatcher.matchCharacter(RAT, negationRegex));
        assertTrue(characterMatcher.matchCharacter(HAT, negationRegex));
    }

    @Test
    void shouldMatchRanges() {
        // a through c, or A through C, inclusive (range)
        final String rangeRegex1 = "[a-cA-C]";
        assertTrue(characterMatcher.matchCharacter("a", rangeRegex1));
        assertTrue(characterMatcher.matchCharacter("b", rangeRegex1));
        assertTrue(characterMatcher.matchCharacter("c", rangeRegex1));
        assertFalse(characterMatcher.matchCharacter("d", rangeRegex1));

        final String rangeRegex2 = "foo[1-5]";
        assertTrue(characterMatcher.matchCharacter("foo1", rangeRegex2));
        assertTrue(characterMatcher.matchCharacter("foo5", rangeRegex2));
        assertFalse(characterMatcher.matchCharacter("foo6", rangeRegex2));

        final String rangeRegex3 = "foo[^1-5]";
        assertFalse(characterMatcher.matchCharacter("foo1", rangeRegex3));
        assertFalse(characterMatcher.matchCharacter("foo5", rangeRegex3));
        assertTrue(characterMatcher.matchCharacter("foo6", rangeRegex3));
    }

    @Test
    void shouldMatchUnions() {
        // Unions to create a single character class comprised of two or more separate character classes
        final String unionRegex = "[0-4[6-8]]";
        assertTrue(characterMatcher.matchCharacter("0", unionRegex));
        assertFalse(characterMatcher.matchCharacter("5", unionRegex));
        assertTrue(characterMatcher.matchCharacter("6", unionRegex));
        assertTrue(characterMatcher.matchCharacter("8", unionRegex));
        assertFalse(characterMatcher.matchCharacter("9", unionRegex));
    }

    @Test
    void shouldMatchSingleCharacterIntersections() {
        // Single character class matching only the characters common to all of its nested classes
        final String singleCharacterIntersectionRegex = "[0-9&&[345]]";
        assertTrue(characterMatcher.matchCharacter("3", singleCharacterIntersectionRegex));
        assertTrue(characterMatcher.matchCharacter("4", singleCharacterIntersectionRegex));
        assertTrue(characterMatcher.matchCharacter("5", singleCharacterIntersectionRegex));
        assertFalse(characterMatcher.matchCharacter("2", singleCharacterIntersectionRegex));
        assertFalse(characterMatcher.matchCharacter("6", singleCharacterIntersectionRegex));
    }

    @Test
    void shouldMatchTwoRangesIntersections() {
        // Intersection of two ranges
        final String twoRangesIntersectionRegex = "[2-8&&[4-6]]";
        assertFalse(characterMatcher.matchCharacter("3", twoRangesIntersectionRegex));
        assertTrue(characterMatcher.matchCharacter("4", twoRangesIntersectionRegex));
        assertTrue(characterMatcher.matchCharacter("5", twoRangesIntersectionRegex));
        assertTrue(characterMatcher.matchCharacter("6", twoRangesIntersectionRegex));
        assertFalse(characterMatcher.matchCharacter("7", twoRangesIntersectionRegex));
    }

    @Test
    void shouldMatchSubtraction() {
        // Subtraction to negate one or more nested character classes
        final String subtractionRegex = "[0-9&&[^345]]";
        assertTrue(characterMatcher.matchCharacter("2", subtractionRegex));
        assertFalse(characterMatcher.matchCharacter("3", subtractionRegex));
        assertFalse(characterMatcher.matchCharacter("4", subtractionRegex));
        assertFalse(characterMatcher.matchCharacter("5", subtractionRegex));
        assertTrue(characterMatcher.matchCharacter("6", subtractionRegex));
        assertTrue(characterMatcher.matchCharacter("9", subtractionRegex));
    }

}