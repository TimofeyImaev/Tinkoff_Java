package edu.hw8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    static Arguments[] quotesWithKeywords(){
        return new Arguments[]{
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
        Runnable startServer = Task1.Server::start;

        Thread serverThread = new Thread(startServer);
        serverThread.start();
        sleep(1000);

        try (Socket socket = new Socket("localhost", 4004)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(keyword);

            String actualAnswer = in.readLine();

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        serverThread.interrupt();
    }

}
