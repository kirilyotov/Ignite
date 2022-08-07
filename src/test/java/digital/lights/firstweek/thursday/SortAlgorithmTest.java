package digital.lights.firstweek.thursday;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface SortAlgorithmTest {
    SortAlgorithm sortAlgorithm();

    @Test
    @DisplayName("assert sort algorithm throws null pointer exception")
    default void assertSortAlgorithmTrowsNullPointerException() {
        //Arrange
        int[] arr = null;
        //Assert
        Exception exception = assertThrows(NullPointerException.class,
                () -> {
                    //Act
                    sortAlgorithm().sort(arr);
                });
    }

    @RepeatedTest(3)
    @DisplayName("assert sort algorithm with random initial order")
    default void assertSortAlgorithmWithRandomInitialOrder() {
        //Arrange
        int[] arrayToSort = {9, 17, 16, 17, 99, -5, 13, 0, 77};
        int[] expectedArray = {-5, 0, 9, 13, 16, 17, 17, 77, 99};

        //Act
        sortAlgorithm().sort(arrayToSort);

        //Assert
        assertArrayEquals(expectedArray, arrayToSort);
    }

    @RepeatedTest(3)
    @DisplayName("assert sort algorithm with nearly sorted order")
    default void assertSortAlgorithmWithNearlySortedOrder() {
        //Arrange
        int[] arrayToSort = {9, -5, 0, 77, 99, 17, 13, 16, 17};
        int[] expectedArray = {-5, 0, 9, 13, 16, 17, 17, 77, 99};

        //Act
        sortAlgorithm().sort(arrayToSort);

        //Assert
        assertArrayEquals(expectedArray, arrayToSort);
    }

    @RepeatedTest(3)
    @DisplayName("assert sort algorithm with reversed order")
    default void assertSortAlgorithmWithReversedOrder() {
        //Arrange
        int[] arrayToSort = {99, 77, 17, 17, 16, 13, 9, 0, -5};
        int[] expectedArray = {-5, 0, 9, 13, 16, 17, 17, 77, 99};

        //Act
        sortAlgorithm().sort(arrayToSort);

        //Assert
        assertArrayEquals(expectedArray, arrayToSort);
    }

    @RepeatedTest(3)
    @DisplayName("assert sort algorithm with few unique keys")
    default void assertSortAlgorithmWithFewUniqueKeys() {
        //Arrange
        int[] arrayToSort = {1, 7, 9, 7, 9, 77, 9, 7, 0, 77, 0, 1};
        int[] expectedArray = {0, 0, 1, 1, 7, 7, 7, 9, 9, 9, 77, 77};

        //Act
        sortAlgorithm().sort(arrayToSort);

        //Assert
        assertArrayEquals(expectedArray, arrayToSort);
    }

    @Test
    @DisplayName("assert sort algorithm with same numbers")
    default void assertSortAlgorithmWithSameNumbers() {
        //Arrange
        int[] arrayToSort = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] expectedArray = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        //Act
        sortAlgorithm().sort(arrayToSort);

        //Assert
        assertArrayEquals(expectedArray, arrayToSort);
    }

}