package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.hw8.task1.Server.QUOUTES_MAP;

class ClientHandler implements Runnable {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Socket clientSocket;
    private final AtomicBoolean isNeedToStop;

    private ServerSocket serverSocket;

    ClientHandler(Socket clientSocket, AtomicBoolean isNeedToStop, ServerSocket serverSocket) {
        this.isNeedToStop = isNeedToStop;
        this.clientSocket = clientSocket;
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String keyword;
            LOGGER.trace("Established connection with the client");

            while ((keyword = in.readLine()) != null) {
                LOGGER.trace("the client sent a message: {}", keyword);

                String quote = QUOUTES_MAP.get(keyword.toLowerCase());
                if (keyword.equalsIgnoreCase("stop")) {
                    LOGGER.trace("the client stop work");

                    isNeedToStop.set(true);
                    serverSocket.close();
                    break;
                }

                if (quote != null) {
                    LOGGER.trace("The server responded with a quote: {}", quote);
                    out.println(quote);
                } else {
                    LOGGER.trace("The server did not find the quote");
                    out.println("Цитаты не найдено");
                }
            }
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
