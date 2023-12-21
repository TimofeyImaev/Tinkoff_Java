package edu.hw8.task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server {
    static final ConcurrentMap<String, String> QUOUTES_MAP = new ConcurrentHashMap<>();
    static final AtomicBoolean IS_NEED_TO_STOP = new AtomicBoolean(false);
    private final static Logger LOGGER = LogManager.getLogger();
    private static final int PORT = 4004;
    private static final int THREAD_POOL_SIZE = 10;

    private Server() {

    }

    public static synchronized void start() {
        IS_NEED_TO_STOP.set(false);
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
                try {
                    Socket clientSocket = serverSocket.accept();
                    LOGGER.trace("We found a client, start connecting");

                    pool.execute(new ClientHandler(clientSocket, IS_NEED_TO_STOP, serverSocket));
                } catch (IOException e) {
                    LOGGER.trace("ServerSocket closed");
                }

                if (IS_NEED_TO_STOP.get()) {
                    break;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
