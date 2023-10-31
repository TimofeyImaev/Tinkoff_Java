package edu.hw2;

import edu.hw1.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[] {
            Arguments.of(new Pair<Integer, Integer>(2, 4), 8),
            Arguments.of(new Pair<Integer, Integer>(3, 5), 15),
            Arguments.of(new Pair<Integer, Integer>(8, 6), 48),
            Arguments.of(new Pair<Integer, Integer>(3, 4), 12),
            Arguments.of(new Pair<Integer, Integer>(1, 2), 2),
        };
    }

    @ParameterizedTest(name = "given rectangle {argumentsWithNames} when counting area then returned area")
    @MethodSource("rectangles")
    void testCountingAreaOfRectangle(Pair<Integer, Integer> rectangleSides, int area) {
        Task2.Rectangle rect = new Task2.Rectangle();
        rect.setWidth(rectangleSides.first);
        rect.setHeight(rectangleSides.second);

        assertThat(rect.area()).isEqualTo(area);
    }

    static Arguments[] squares() {
        return new Arguments[] {
            Arguments.of(5, 25),
            Arguments.of(2, 4),
            Arguments.of(9, 81),
            Arguments.of(21, 441),
            Arguments.of(7, 49),
        };
    }

    @ParameterizedTest(name = "given square {argumentsWithNames} when counting area then returned area")
    @MethodSource("squares")
    void testCountingAreaOfSquare(int squareSide, int area) {
        Task2.Rectangle square = new Task2.Square();
        square.setWidth(squareSide);
        square.setHeight(squareSide);

        assertThat(square.area()).isEqualTo(area);
    }
}
