package edu.hw11;

public class Task2 {
    static class ArithmeticUtils {
        public static int sum(int a, int b) {
            return a + b;
        }
    }

    static class ArithmeticUtilsDelegator {
        public static int sum(int a, int b) {
            return a * b;
        }
    }
}
