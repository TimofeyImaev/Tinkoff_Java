package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Nested
    class AdditionTests {
        @Test
        @DisplayName("testThat 2 + 3 Returned 5")
        void basicSumTest1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(2), b = new Task1.Expr.Constant(3);

            double answer = (new Task1.Expr.Addition(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(5);
        }

        @Test
        @DisplayName("testThat 95 + 101 Returned 196")
        void basicSumTest2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(95), b = new Task1.Expr.Constant(101);

            double answer = (new Task1.Expr.Addition(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(196);
        }

        @Test
        @DisplayName("testThat -5 + 8 Returned 3")
        void basicSumTest3() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(-5), b = new Task1.Expr.Constant(8);

            double answer = (new Task1.Expr.Addition(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(3);
        }

        @Test
        @DisplayName("sum of zeros")
        void zeros() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(0), b = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Addition(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(0);
        }

        @Test
        @DisplayName("number 5152 plus zero")
        void zeroNumber1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(5152), b = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Addition(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(5152);
        }

        @Test
        @DisplayName("number 197 plus zero")
        void zeroNumber2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(197), b = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Addition(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(197);
        }
    }

    @Nested
    class Negate {
        @Test
        @DisplayName("negate of 4")
        void basicNegateTest1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(4);

            double answer = (new Task1.Expr.Negate(a)).evaluate();

            assertThat(answer)
                .isEqualTo(-4);
        }

        @Test
        @DisplayName("negate of 10")
        void basicNegateTest2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(10);

            double answer = (new Task1.Expr.Negate(a)).evaluate();

            assertThat(answer)
                .isEqualTo(-10);
        }

        @Test
        @DisplayName("negate of 512")
        void basicNegateTest3() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(512);

            double answer = (new Task1.Expr.Negate(a)).evaluate();

            assertThat(answer)
                .isEqualTo(-512);
        }

        @Test
        @DisplayName("negate of zero")
        void zeroNegateTest() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Negate(a)).evaluate();

            assertThat(answer)
                .isEqualTo(0);
        }

        @Test
        @DisplayName("negate of -4")
        void negativeNumberNegate() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(-4);

            double answer = (new Task1.Expr.Negate(a)).evaluate();

            assertThat(answer)
                .isEqualTo(4);
        }
    }

    @Nested
    class MultiplicationTest {
        @Test
        @DisplayName("testThat 2 * 2 Returned 4")
        void basicTest1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(2), b = new Task1.Expr.Constant(2);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(4);
        }

        @Test
        @DisplayName("testThat 5 * 7 Returned 35")
        void basicTest2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(5), b = new Task1.Expr.Constant(7);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(35);
        }

        @Test
        @DisplayName("testThat -8 * 4 Returned -32")
        void basicTest3() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(-8), b = new Task1.Expr.Constant(4);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(-32);
        }

        @Test
        @DisplayName("number 51263 mul zero")
        void zeroNumberMul1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(51263), b = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(0);
        }

        @Test
        @DisplayName("number 124 mul zero")
        void zeroNumberMul2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(124), b = new Task1.Expr.Constant(0);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(0);
        }

        @Test
        @DisplayName("number 24 mul 1")
        void oneNumberMul1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(24), b = new Task1.Expr.Constant(1);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(24);
        }

        @Test
        @DisplayName("number -5 mul 1")
        void oneNumberMul2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(-5), b = new Task1.Expr.Constant(1);

            double answer = (new Task1.Expr.Multiplication(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(-5);
        }
    }

    @Nested
    class ExponentTest {
        @Test
        @DisplayName("testThat 2 ** 5 Returned 32")
        void basicExponentTest1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(2);
            double b = 5;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(32);
        }

        @Test
        @DisplayName("testThat 3 ** 4 Returned 81")
        void basicExponentTest2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(3);
            double b = 4;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(81);
        }

        @Test
        @DisplayName("testThat 5 ** 4 Returned 625")
        void basicExponentTest3() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(5);
            double b = 4;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(625);
        }

        @Test
        @DisplayName("512 in zero power")
        void zeroPower1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(512);
            double b = 0;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(1);
        }

        @Test
        @DisplayName("86 in zero power")
        void zeroPower2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(86);
            double b = 0;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(1);
        }

        @Test
        @DisplayName("256 in 1/2 power")
        void fractionalPower1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(256);
            double b = (double) 1 / 2;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(16);
        }

        @Test
        @DisplayName("27 in 1/3 power")
        void fractionalPower2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(27);
            double b = (double) 1 / 3;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo(3);
        }

        @Test
        @DisplayName("5 in -1 power")
        void negativePower1() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(5);
            double b = -1;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo((double) 1 / 5);
        }

        @Test
        @DisplayName("5 in -2 power")
        void negativePower2() {
            Task1.Expr.Constant a = new Task1.Expr.Constant(5);
            double b = -2;

            double answer = (new Task1.Expr.Exponent(a, b)).evaluate();

            assertThat(answer)
                .isEqualTo((double) 1 / 25);
        }
    }
}
