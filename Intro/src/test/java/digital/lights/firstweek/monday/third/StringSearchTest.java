package digital.lights.firstweek.monday.third;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface StringSearchTest {

    //https://www.novatec-gmbh.de/blog/interface-contract-with-junit-5/
    //https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-interfaces-and-default-methods
    StringSearch s();

    @ParameterizedTest
    //Arrange
    @ValueSource(strings = {"", "a", "ab", "abc", "abcd", "abcde", "abcdef"})
    @DisplayName("assert search function correctly recognizes prefix of the string")
    default void assertSearchFunctionCorrectlyRecognizesPrefixOfTheString(String part) {
        //Act + Assert
        assertEquals(0, s().positionOf(part, "abcdef"));
    }

    @ParameterizedTest
    //Arrange
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde", "abcdef"})
    @DisplayName("assert search function correctly recognize no substrings or the string")
    default void assertSearchFunctionCorrectlyRecognizeNoSubstringsOrTheString(String part) {
        //Arrange
        String whole = "";

        //Act + Assert
        assertEquals(-1, s().positionOf(part, whole));
    }

    @ParameterizedTest
    //Arrange
    @ValueSource(strings = {"b", "bc", "bcd", "bcde"})
    default void assertSearchFunctionCorrectlyRecognizesSubstringOfTheString(String part) {
        //Arrange
        String whole = "abcdef";

        //Act + Assert
        assertEquals(1, s().positionOf(part, whole));
    }

    @ParameterizedTest
    //Arrange
    @ValueSource(strings = {"A", "Ab", "_bcd", " "})
    @DisplayName("assert search function correctly recognizes not valid strings")
    default void assertSearchFunctionCorrectlyRecognizesNotValidStrings(String part) {
        //Arrange
        String whole = "abcdef";

        //Act + Assert
        assertEquals(-1, s().positionOf(part,whole));
    }


    @Test
    @DisplayName("assert search function correctly throws null pointer exception")
     default void assertSearchFunctionCorrectlyTrowsNullPointerException(){
        //Arrange
        String nullString = null;
        String string = "";

        //Assert
        Exception exception = assertThrows(NullPointerException.class,
                () ->{
            //Act
            s().positionOf(nullString, nullString);
            s().positionOf(nullString, string);
            s().positionOf(string, nullString);
                });
    }

    @ParameterizedTest
    //Arrange
    @ValueSource(strings = {"b", "ab", "acdefb", "AZk b" })
    @DisplayName("assert search function correctly recognizes postfix of the string")
    default void assertSearchFunctionCorrectlyRecognizesPostfixOfTheString(String whole){
        //Arrange
        String part = "b";

        //Act + Assert
        assertEquals(whole.length() - 1, s().positionOf(part, whole));

    }
}