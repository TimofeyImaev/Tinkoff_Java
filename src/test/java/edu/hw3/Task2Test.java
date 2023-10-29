package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Nested
    class ClusterizeBracketsTest {
        static Arguments[] balancedBracketsSequences() {
            return new Arguments[] {
                Arguments.of(
                    "()()()",
                    new ArrayList<String>(Arrays.asList("()", "()", "()"))
                ),

                Arguments.of(
                    "((()))",
                    new ArrayList<String>(Arrays.asList("((()))"))
                ),

                Arguments.of(
                    "((()))(())()()(()())",
                    new ArrayList<String>(Arrays.asList("((()))", "(())", "()", "()", "(()())"))
                ),

                Arguments.of(
                    "((())())(()(()()))",
                    new ArrayList<String>(Arrays.asList("((())())", "(()(()()))"))
                ),
            };
        }

        @ParameterizedTest
        @MethodSource("balancedBracketsSequences")
        void givenBalancedSequenceWhenClusterizeBracketsThenReturnClusters(
            String brackets,
            ArrayList<String> expectedAnswer
        ) {
            ArrayList<String> actualAnswer = Task2.clusterize(brackets);

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        }

        static Arguments[] unbalancedBracketsSequences() {
            return new Arguments[] {
                Arguments.of(
                    ")()",
                    new ArrayList<String>(new ArrayList<String>())
                ),

                Arguments.of(
                    "(((",
                    new ArrayList<String>(new ArrayList<String>())
                ),

                Arguments.of(
                    "()(()()",
                    new ArrayList<String>(new ArrayList<String>())
                ),

                Arguments.of(
                    "()())(()()))",
                    new ArrayList<String>(new ArrayList<String>())
                ),
            };
        }

        @ParameterizedTest
        @MethodSource("unbalancedBracketsSequences")
        void givenUnbalancedSequenceWhenValidationThenReturnEmptyArrayList(
            String brackets,
            ArrayList<String> expectedAnswer
        ) {
            ArrayList<String> actualAnswer = Task2.clusterize(brackets);

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        }
    }
}
