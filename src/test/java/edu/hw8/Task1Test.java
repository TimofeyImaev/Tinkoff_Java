package edu.hw8;

import edu.hw1.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import edu.hw8.task1.Server;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    static Arguments[] quotesWithKeywords() {
        return new Arguments[] {
            Arguments.of(
                "личности",
                "Не переходи на личности там, где их нет"
            ),
            Arguments.of(
                "оскорбления",
                "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"
            ),
            Arguments.of(
                "глупый",
                "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма"
            ),
            Arguments.of(
                "интеллект",
                "Чем ниже интеллект, тем громче оскорбления"
            ),
            Arguments.of(
                "ум",
                "Цитаты не найдено"
            )
        };
    }

    @ParameterizedTest
    @MethodSource("quotesWithKeywords")
    void givenServerWhenCatchingClientAndSendingKeywordThenReturnedQuote(
        String keyword,
        String expectedAnswer
    ) throws InterruptedException {
        Runnable startServer = Server::start;

        Thread serverThread = new Thread(startServer);
        serverThread.start();
        sleep(1000);

        try (Socket socket = new Socket("localhost", 4004)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(keyword);

            String actualAnswer = in.readLine();

            out.println("stop");

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void givenServerWhenCatchingManyClientsAndSendingKeywordsThenReturnedQuotes() throws InterruptedException {
        Runnable startServer = Server::start;

        Thread serverThread = new Thread(startServer);
        serverThread.start();
        List<Pair<String, String>> keywordAnswerPairs = List.of(
            new Pair<>(
                "личности",
                "Не переходи на личности там, где их нет"
            ),
            new Pair<>(
                "оскорбления",
                "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"
            ),
            new Pair<>(
                "глупый",
                "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма"
            ),
            new Pair<>(
                "интеллект",
                "Чем ниже интеллект, тем громче оскорбления"
            ),
            new Pair<>(
                "ум",
                "Цитаты не найдено"
            )
        );

        sleep(1000);
        CountDownLatch countDownLatch = new CountDownLatch(5);

        AtomicBoolean atomicBoolean = new AtomicBoolean(true);

        for (int i = 0; i < 5; ++i) {
            int finalI = i;
            Runnable runnable = () -> {
                try (Socket socket = new Socket("localhost", 4004)) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    out.println(keywordAnswerPairs.get(finalI).first);

                    String actualAnswer = in.readLine();

                    if (!actualAnswer.equals(keywordAnswerPairs.get(finalI).second)) {
                        atomicBoolean.set(false);
                    }
                    countDownLatch.countDown();
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
        }

        countDownLatch.await();

        try (Socket socket = new Socket("localhost", 4004)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("stop");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertTrue(atomicBoolean.get());
    }
}
