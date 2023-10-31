package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("testThat callingInfo in someClass1 with someFunction1 returned class and method names")
    void givenSomeFuction1WhenCallingInfoThenReturnedClassName() {
        Task4.SomeClass1 someClass = new Task4.SomeClass1();
        Task4.CallingInfo info = someClass.someFunction1();

        assertThat(info.className())
            .isEqualTo(someClass.getClass().getName().split("\\$")[1]);
    }

    @Test
    @DisplayName("testThat callingInfo in someClass2 with someFunction2 returned class and method names")
    void givenSomeFuction2WhenCallingInfoThenReturnedClassName() {
        Task4.SomeClass2 someClass = new Task4.SomeClass2();
        Task4.CallingInfo info = someClass.someFunction2();

        assertThat(info.className())
            .isEqualTo(someClass.getClass().getName().split("\\$")[1]);
    }

    @Test
    @DisplayName("testThat callingInfo in someClass3 with someFunction3 returned class and method names")
    void givenSomeFuction3WhenCallingInfoThenReturnedClassName() {
        Task4.SomeClass3 someClass = new Task4.SomeClass3();
        Task4.CallingInfo info = someClass.someFunction3();

        assertThat(info.className())
            .isEqualTo(someClass.getClass().getName().split("\\$")[1]);
    }
}
