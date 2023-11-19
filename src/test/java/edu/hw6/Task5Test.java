package edu.hw6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    static Arguments[] idsByNames() {
        return new Arguments[] {
            Arguments.of(
                37570037, "JDK 21 Release Notes"
            ),
            Arguments.of(
                38327017, "Show HN: YouTube banned adblockers so I built an extension to skip their ads"
            ),
            Arguments.of(
                38331501, "Ask HN: Any comprehensive courses on Auth?"
            ),
            Arguments.of(
                38331836, "BuildZoom (better way to build custom homes) Is hiring a Growth Associate"
            ),
            Arguments.of(
                38326242, "Why aren't motherboards mostly USB-C by now? (2021)"
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("idsByNames")
    void givenNewsStoriesIdWhenGettingTitleFromStoryThenReturnTitle(int id, String expectedAnswer)
        throws IOException, URISyntaxException, InterruptedException {
        Task5.HackerNews hackerNews = new Task5.HackerNews();
        String actualAnswer = hackerNews.news(id);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
