package edu.hw9;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Task3Test {
    static Arguments[] graph() {
        return new Arguments[] {
            Arguments.of(
                1,
                3,
                List.of(
                    List.of(),
                    List.of(
                        2
                    ),
                    List.of(
                        1, 3
                    ),
                    List.of(
                        2
                    )
                ),
                new AtomicBoolean[] {
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false)}
            ),
            Arguments.of(
                1,
                2,
                List.of(
                    List.of(),
                    List.of(
                        2
                    ),
                    List.of(
                        1
                    )
                ),
                new AtomicBoolean[] {
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false)}
            ),
            Arguments.of(
                1,
                1,
                List.of(
                    List.of(),
                    List.of(
                    )
                ),
                new AtomicBoolean[] {
                    new AtomicBoolean(false),
                    new AtomicBoolean(false)}
            ),
            Arguments.of(
                1,
                6,
                List.of(
                    List.of(),
                    List.of(
                        4, 6
                    ),
                    List.of(
                        3
                    ),
                    List.of(
                        2, 4
                    ),
                    List.of(
                        1, 3, 6
                    ),
                    List.of(

                    ),
                    List.of(
                        1, 4
                    )
                ),
                new AtomicBoolean[] {
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false)}
            ),
            Arguments.of(
                1,
                5,
                List.of(
                    List.of(),
                    List.of(
                        2, 3
                    ),
                    List.of(
                        1, 3
                    ),
                    List.of(
                        1, 2, 4
                    ),
                    List.of(
                        3, 5
                    ),
                    List.of(
                        4
                    )
                ),
                new AtomicBoolean[] {
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false),
                    new AtomicBoolean(false)}
            )
        };
    }

    @ParameterizedTest
    @MethodSource("graph")
    void givenGraphAndStartEndVertexWhenSearchingPathFromStartToEndThenReturnListIntegers(
        int startVertex,
        int endVertex,
        List<List<Integer>> graph,
        AtomicBoolean[] used
    ) {
        Task3.DFS dfs = new Task3.DFS(startVertex, endVertex, graph, used);
        dfs.fork();

        List<Integer> answer = dfs.join();

        boolean isPath = true;

        for (int i = 0; i < answer.size(); ++i) {
            boolean leftNeighbourConnected = false;
            boolean rightNeighbourConnected = false;

            if (i == 0) {
                leftNeighbourConnected = true;
            }
            if (i == answer.size() - 1) {
                rightNeighbourConnected = true;
            }

            for (var each : graph.get(answer.get(i))) {
                if (i > 0 && each.equals(answer.get(i - 1))) {
                    leftNeighbourConnected = true;
                }

                if (i < answer.size() - 1 && each.equals(answer.get(i + 1))) {
                    rightNeighbourConnected = true;
                }
            }

            if (!leftNeighbourConnected || !rightNeighbourConnected) {
                isPath = false;
                break;
            }
        }

        if (isPath
            && answer.get(0).equals(endVertex)
            && answer.get(answer.size() - 1).equals(startVertex)
        ) {
            assertTrue(true);
        }
        else{
            fail();
        }
    }
}
