package edu.hw8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {
    public static class Server {
        private final static Logger LOGGER = LogManager.getLogger();
        private static final int PORT = 4004;
        private static final int THREAD_POOL_SIZE = 10;
        private static final ConcurrentMap<String, String> QUOUTES_MAP = new ConcurrentHashMap<>();

        public static synchronized void start() {
            QUOUTES_MAP.put(
                "личности",
                "Не переходи на личности там, где их нет"
            );
            QUOUTES_MAP.put(
                "оскорбления",
                "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"
            );
            QUOUTES_MAP.put(
                "глупый",
                "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма"
            );
            QUOUTES_MAP.put(
                "интеллект",
                "Чем ниже интеллект, тем громче оскорбления"
            );

            ExecutorService pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                LOGGER.trace("Server started on port: {}", PORT);

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    LOGGER.trace("We found a client, start connecting");

                    pool.execute(new ClientHandler(clientSocket));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private static final class ClientHandler implements Runnable {
            private final Socket clientSocket;

            ClientHandler(Socket clientSocket) {
                this.clientSocket = clientSocket;
            }

            @Override
            public void run() {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    String keyword;
                    LOGGER.trace("Established connection with the client");

                    while ((keyword = in.readLine()) != null) {
                        String quote = QUOUTES_MAP.get(keyword.toLowerCase());

                        LOGGER.trace("the client sent a message: {}", keyword);
                        if (quote != null) {
                            LOGGER.trace("The server responded with a quote: {}", quote);
                            out.println(quote);
                        } else {
                            LOGGER.trace("The server did not find the quote");
                            out.println("Цитаты не найдено");
                        }

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
