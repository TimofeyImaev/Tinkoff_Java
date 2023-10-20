package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("testThat someClass1 with someFunction1 Returned rights names")
    void callingInfoTest1() {
        Task4.SomeClass1 someClass = new Task4.SomeClass1();
        Task4.CallingInfo info = someClass.someFunction1();

        assertThat(info.className())
            .isEqualTo(someClass.getClass().getName().split("\\$")[1]);
    }

    @Test
    @DisplayName("testThat someClass1 with someFunction2 Returned rights names")
    void callingInfoTest2() {
        Task4.SomeClass2 someClass = new Task4.SomeClass2();
        Task4.CallingInfo info = someClass.someFunction2();

        assertThat(info.className())
            .isEqualTo(someClass.getClass().getName().split("\\$")[1]);
    }

    @Test
    @DisplayName("testThat someClass1 with someFunction3 Returned rights names")
    void callingInfoTest3() {
        Task4.SomeClass3 someClass = new Task4.SomeClass3();
        Task4.CallingInfo info = someClass.someFunction3();

        assertThat(info.className())
            .isEqualTo(someClass.getClass().getName().split("\\$")[1]);
    }
}
