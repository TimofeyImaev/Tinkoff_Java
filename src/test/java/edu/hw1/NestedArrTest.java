package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NestedArrTest {

    @Test
    @DisplayName("Базовый тест1")
    void basicTest1() {
        int[] arr1 = new int[] { 3, 1, 2};
        int[] arr2 = new int [] {0, 2, 3, 5};

        boolean answer = IsNestable.isNestable(arr1, arr2);

        assertThat(answer)
            .isEqualTo(true);
    }
    @Test
    @DisplayName("Базовый тест2")
    void basicTest2() {
        int[] arr1 = new int[] {0, 6, 3, 5};
        int[] arr2 = new int [] { 2, 1, 8};

        boolean answer = IsNestable.isNestable(arr1, arr2);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Базовый тест3")
    void basicTest3() {
        int[] arr1 = new int[] {25, 34, 16, 7};
        int[] arr2 = new int [] { 5, 40};

        boolean answer = IsNestable.isNestable(arr1, arr2);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Пустые массивы")
    void emptyArrays() {
        int[] arr1 = new int[] {};
        int[] arr2 = new int [] {};

        boolean answer = IsNestable.isNestable(arr1, arr2);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Граничный тест1")
    void boundaryTest1() {
        int[] arr1 = new int[] {1, 5};
        int[] arr2 = new int [] {1, 5};

        boolean answer = IsNestable.isNestable(arr1, arr2);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Граничный тест2")
    void boundaryTest2() {
        int[] arr1 = new int[] {2, 4};
        int[] arr2 = new int [] {1, 5};

        boolean answer = IsNestable.isNestable(arr1, arr2);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Граничный тест4")
    void boundaryTest3() {
        int[] arr1 = new int[] {1, 4};
        int[] arr2 = new int [] {1, 5};

        boolean answer = IsNestable.isNestable(arr1, arr2);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Граничный тест5")
    void boundaryTest5() {
        int[] arr1 = new int[] {2, 5};
        int[] arr2 = new int [] {1, 5};

        boolean answer = IsNestable.isNestable(arr1, arr2);

        assertThat(answer)
            .isEqualTo(false);
    }
}
