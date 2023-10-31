package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Nested
    class AdditionTests {
        @Test
        @DisplayName("testThat sum of 2 and 3 is Returned 5")
        void givenTwoNumbersWhenCalculateSumThenReturnSum1() {
            Task1.Expr.Constant firstNum = new Task1.Expr.Constant(2),
                secondNum = new Task1.Expr.Constant(3);
            double expectedSum = 5;

            double actualSum = (new Task1.Expr.Addition(firstNum, secondNum)).evaluate();

            assertThat(actualSum).isEqualTo(expectedSum);
        }

        @Test
        @DisplayName("testThat sum of 95 and 101 is Returned 196")
        void givenTwoNumbersWhenCalculateSumThenReturnSum2() {
            Task1.Expr.Constant firstNum = new Task1.Expr.Constant(95),
                secondNum = new Task1.Expr.Constant(101);
            double expectedSum = 196;

            double actualSum = (new Task1.Expr.Addition(firstNum, secondNum)).evaluate();

            assertThat(actualSum).isEqualTo(expectedSum);
        }

        @Test
        @DisplayName("testThat sum of -5 and 8 is Returned 3")
        void givenTwoNumbersWhenCalculateSumThenReturnSum3() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(-5), b = new Task1.Expr.Constant(8);

            double answer = (new Task1.Expr.Addition(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(3);
        }

        @Test
        @DisplayName("testThat sum of zeros equals zero")
        void givenTwoZerosWhenCalculateSumThenReturnSum3() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(0), b = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Addition(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(0);
        }

        @Test
        @DisplayName("testThat sum of 5152 and zero is Returned 5152")
        void givenNumberAndZeroWhenCalculateSumThenReturnSum1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(5152), b = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Addition(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(5152);
        }

        @Test
        @DisplayName("testThat sum of 197 and zero is Returned 197")
        void givenNumberAndZeroWhenCalculateSumThenReturnSum2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(197), b = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Addition(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(197);
        }
    }

    @Nested
    class Negate {
        @Test
        @DisplayName("given 4 then Returned Multiplicative inverse of 4")
        void givenNumberWhenNegateThenReturnedNegatedNumber1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(4);

            double answer = (new Task1.Expr.Negate(a)).evaluate();

            assertThat(answer)
                .isEqualTo(-4);
        }

        @Test
        @DisplayName("given 10 then Returned Multiplicative inverse of 10")
        void givenNumberWhenNegateThenReturnedNegatedNumber2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(10);

            double answer = (new Task1.Expr.Negate(a)).evaluate();

            assertThat(answer)
                .isEqualTo(-10);
        }

        @Test
        @DisplayName("given 512 then Returned Multiplicative inverse of 512")
        void givenNumberWhenNegateThenReturnedNegatedNumber3() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(512);

            double answer = (new Task1.Expr.Negate(a)).evaluate();

            assertThat(answer)
                .isEqualTo(-512);
        }

        @Test
        @DisplayName("given zero testThat negate of zero equals zero")
        void givenZeroWhenNegateZeroTheReturnedZero() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Negate(a)).evaluate();

            assertThat(answer)
                .isEqualTo(0);
        }

        @Test
        @DisplayName("given -4 then Returned Multiplicative inverse of -4")
        void givenNegativeNumberWhenNegateTheReturnedPositiveNumber() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(-4);

            double answer = (new Task1.Expr.Negate(a)).evaluate();

            assertThat(answer)
                .isEqualTo(4);
        }
    }

    @Nested
    class MultiplicationTest {
        @Test
        @DisplayName("testThat multiplication of 2 and 2 Returned 4")
        void givenTwoNumbersWhenMultiplicationNumbersThenReturnedProduct1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(2), b = new Task1.Expr.Constant(2);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(4);
        }

        @Test
        @DisplayName("testThat multiplication of 5 and 7 Returned 35")
        void givenTwoNumbersWhenMultiplicationNumbersThenReturnedProduct2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(5), b = new Task1.Expr.Constant(7);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(35);
        }

        @Test
        @DisplayName("testThat multiplication of -8 and 4 Returned -32")
        void givenTwoNumbersWhenMultiplicationNumbersThenReturnedProduct3() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(-8), b = new Task1.Expr.Constant(4);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(-32);
        }

        @Test
        @DisplayName("testThat multiplication of 51263 and zero Returned zero")
        void givenNumberAndZeroWhenMultiplicationNumbersThenReturnedZero1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(51263), b = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(0);
        }

        @Test
        @DisplayName("testThat multiplication of 124 and zero Returned zero")
        void givenNumberAndZeroWhenMultiplicationNumbersThenReturnedZero2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(124), b = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(0);
        }

        @Test
        @DisplayName("testThat multiplication of 24 and one Returned 24")
        void givenNumberAndOneWhenMultiplicationNumbersThenReturnedOne1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(24), b = new Task1.Expr.Constant(1);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(24);
        }

        @Test
        @DisplayName("testThat multiplication of -5 and one Returned -5")
        void givenNumberAndOneWhenMultiplicationNumbersThenReturnedOne2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(-5), b = new Task1.Expr.Constant(1);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(-5);
        }
    }

    @Nested
    class ExponentTest {
        @Test
        @DisplayName("testThat 2 in power 5 is returned 32")
        void givenTwoNumbersWhenExponentiateThenReturnedNumberRaisedInPower1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(2);
            double b = 5;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(32);
        }

        @Test
        @DisplayName("testThat 3 in power 4 is returned 81")
        void givenTwoNumbersWhenExponentiateThenReturnedNumberRaisedInPower2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(3);
            double b = 4;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(81);
        }

        @Test
        @DisplayName("testThat 5 in power 4 is returned 625")
        void givenTwoNumbersWhenExponentiateThenReturnedNumberRaisedInPower3() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(5);
            double b = 4;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(625);
        }

        @Test
        @DisplayName("testThat 512 in power zero equals 1")
        void givenNumberAndZeroWhenExponentiateThenReturnedOne1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(512);
            double b = 0;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(1);
        }

        @Test
        @DisplayName("testThat 86 in power zero equals 1")
        void givenNumberAndZeroWhenExponentiateThenReturnedOne2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(86);
            double b = 0;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(1);
        }

        @Test
        @DisplayName("testThat 256 in power 1/2 is Returned 16")
        void givenNumberAndFractionNumberWhenExponentiateThenReturnedNumberRaisedInPower1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(256);
            double b = (double) 1 / 2;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(16);
        }

        @Test
        @DisplayName("testThat 27 in power 1/3 is Returned 3")
        void givenNumberAndFractionNumberWhenExponentiateThenReturnedNumberRaisedInPower2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(27);
            double b = (double) 1 / 3;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(3);
        }

        @Test
        @DisplayName("testThat 5 in power -1 is Returned 1/5")
        void givenNumberAndMinusOneWhenExponentiateThenReturnedNumberRaisedInPower1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(5);
            double b = -1;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo((double) 1 / 5);
        }

        @Test
        @DisplayName("testThat 5 in power -2 is Returned 1/25")
        void givenNumberAndMinusOneWhenExponentiateThenReturnedNumberRaisedInPower2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(5);
            double b = -2;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo((double) 1 / 25);
        }
    }
}
