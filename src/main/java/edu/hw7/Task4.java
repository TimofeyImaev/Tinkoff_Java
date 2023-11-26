package edu.hw7;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings({"RegexpSinglelineJava", "UncommentedMain"})
public class Task4 {
    private static final String TEST_SEPARATOR = "=================";
    private static final String ANSWER_FOR_1E7_POINTS = "Answer for 10**7 points:";
    private static final String ANSWER_FOR_1E8_POINTS = "Answer for 10**8 points:";
    private static final String ANSWER_FOR_1E9_POINTS = "Answer for 10**9 points:";
    private static final String COUNTING_TIME = "Counting time: ";
    private static final long TEN_MILLIONS = 10000000L;
    private static final long HUNDRED_MILLIONS = 100000000L;
    private static final long LONG_BILLION = 1000000000L;
    private static final int INT_BILLION = 1000000000;

    private Task4() {

    }

    static double methodMonteCarloPiCalculation(long totalCountOfPoints) {
        final int FOUR_MONTE_CARLO_FORMULA_COEFFICIENT = 4;
        long circleCount = 0;

        for (long i = 0; i < totalCountOfPoints; ++i) {
            double x = Math.random();
            double y = Math.random();

            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }

        return (double) (FOUR_MONTE_CARLO_FORMULA_COEFFICIENT * circleCount) / totalCountOfPoints;
    }

    static double multiThreadMethodMonteCarloPiCalculation(long totalCountOfPoints, int countOfThreads) {
        final int FOUR_MONTE_CARLO_FORMULA_COEFFICIENT = 4;
        AtomicLong circleCount = new AtomicLong(0);
        AtomicInteger countOfFinishedThreads = new AtomicInteger(0);

        for (long i = 0; i < countOfThreads; ++i) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    long countOfIterations = totalCountOfPoints / countOfThreads;
                    long circleThreadCount = 0;

                    for (long j = 0; j < countOfIterations; ++j) {
                        double x = Math.random();
                        double y = Math.random();

                        if (x * x + y * y <= 1) {
                            circleThreadCount++;
                        }
                    }

                    circleCount.addAndGet(circleThreadCount);
                    countOfFinishedThreads.incrementAndGet();
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
        }

        while (countOfFinishedThreads.get() < countOfThreads) {
            continue;
        }

        return (double) (FOUR_MONTE_CARLO_FORMULA_COEFFICIENT * circleCount.get()) / totalCountOfPoints;
    }

    public static void main(String[] args) {
        System.out.println("MethodMonteCarlo Calculations:");

        System.out.println("One Thread calculations:");

        System.out.println(TEST_SEPARATOR);

        System.out.println(ANSWER_FOR_1E7_POINTS);
        LocalTime start = LocalTime.now();
        System.out.println(methodMonteCarloPiCalculation(TEN_MILLIONS));
        LocalTime end = LocalTime.now();

        Duration duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println(ANSWER_FOR_1E8_POINTS);
        start = LocalTime.now();
        System.out.println(methodMonteCarloPiCalculation(HUNDRED_MILLIONS));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println(ANSWER_FOR_1E9_POINTS);
        start = LocalTime.now();
        System.out.println(methodMonteCarloPiCalculation(LONG_BILLION));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println("Two Threads calculations:");

        System.out.println(ANSWER_FOR_1E7_POINTS);
        start = LocalTime.now();
        System.out.println(multiThreadMethodMonteCarloPiCalculation(TEN_MILLIONS, 2));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println(ANSWER_FOR_1E8_POINTS);
        start = LocalTime.now();
        System.out.println(multiThreadMethodMonteCarloPiCalculation(HUNDRED_MILLIONS, 2));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println(ANSWER_FOR_1E9_POINTS);
        start = LocalTime.now();
        System.out.println(multiThreadMethodMonteCarloPiCalculation(LONG_BILLION, 2));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println("Five Threads calculations:");

        final int FIVE_THREADS = 5;

        System.out.println(ANSWER_FOR_1E7_POINTS);
        start = LocalTime.now();
        System.out.println(multiThreadMethodMonteCarloPiCalculation(TEN_MILLIONS, FIVE_THREADS));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println(ANSWER_FOR_1E8_POINTS);
        start = LocalTime.now();
        System.out.println(multiThreadMethodMonteCarloPiCalculation(HUNDRED_MILLIONS, FIVE_THREADS));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println(ANSWER_FOR_1E9_POINTS);
        start = LocalTime.now();
        System.out.println(multiThreadMethodMonteCarloPiCalculation(LONG_BILLION, FIVE_THREADS));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println("Ten Threads calculations:");

        final int TEN_THREADS = 10;

        System.out.println(ANSWER_FOR_1E7_POINTS);
        start = LocalTime.now();
        System.out.println(multiThreadMethodMonteCarloPiCalculation(TEN_MILLIONS, TEN_THREADS));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println(ANSWER_FOR_1E8_POINTS);
        start = LocalTime.now();
        System.out.println(multiThreadMethodMonteCarloPiCalculation(HUNDRED_MILLIONS, TEN_THREADS));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);

        System.out.println(ANSWER_FOR_1E9_POINTS);
        start = LocalTime.now();
        System.out.println(multiThreadMethodMonteCarloPiCalculation(LONG_BILLION, TEN_THREADS));
        end = LocalTime.now();

        duration = Duration.between(start, end);

        System.out.println(COUNTING_TIME + (duration.getSeconds() + (double) duration.getNano() / INT_BILLION));

        System.out.println(TEST_SEPARATOR);
    }
}
/*
MethodMonteCarlo Calculations:
One Thread calculations:
=================
Answer for 10**7 points:
3.1410748
Counting time: 0.3850791
=================
Answer for 10**8 points:
3.14131424
Counting time: 3.7594422
=================
Answer for 10**9 points:
3.14151792
Counting time: 37.7488368
=================
Two Threads calculations:
Answer for 10**7 points:
3.1413048
Counting time: 1.4296669
=================
Answer for 10**8 points:
3.14151136
Counting time: 14.2615172
=================
Answer for 10**9 points:
3.14163836
Counting time: 147.3615531
=================
Five Threads calculations:
Answer for 10**7 points:
3.14128
Counting time: 2.5016475
=================
Answer for 10**8 points:
3.14157756
Counting time: 28.9644964
=================
Answer for 10**9 points:
3.141595488
Counting time: 274.7132872
=================
Ten Threads calculations:
Answer for 10**7 points:
3.1414216
Counting time: 3.3206938
=================
Answer for 10**8 points:
3.14157804
Counting time: 28.2170471
=================
Answer for 10**9 points:
3.141564336
Counting time: 296.291826
=================
 */
