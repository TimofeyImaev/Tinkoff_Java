package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final double HALF = 0.5;

    public Task3() {

    }

    public static class ConnectionException extends RuntimeException {
    }

    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public static class StableConnection implements Connection {

        @Override
        public void execute(String command) {
            LOGGER.trace("Command {} pending in StableConnection", command);
        }

        @Override
        public void close() throws Exception {
            LOGGER.trace("StableConnection closed");
        }

        @Override
        public String toString() {
            return "StableConnection";
        }
    }

    public static class FaultyConnection implements Connection {

        @Override
        public void execute(String command) throws ConnectionException {
            if (Math.random() >= HALF) {
                LOGGER.trace("Command {} pending in FaultyConnection", command);
            } else {
                throw new ConnectionException();
            }
        }

        @Override
        public void close() throws Exception {
            LOGGER.trace("FaultyConnection closed");
        }

        @Override
        public String toString() {
            return "FaultyConnection";
        }
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public static class DefaultConnectionManager implements ConnectionManager {

        @Override
        public Connection getConnection() {
            if (Math.random() >= HALF) {
                return new StableConnection();
            } else {
                return new FaultyConnection();
            }
        }
    }

    public static class FaultyConnectionManager implements ConnectionManager {

        @Override
        public Connection getConnection() {
            return new FaultyConnection();
        }
    }

    public static final class PopularCommandExecutor {
        private static final int MAX_ATTEMPTS = 5;

        public static void updatePackages(ConnectionManager manager) {

            tryExecute(manager, "apt update && apt upgrade -y");
        }

        static void tryExecute(ConnectionManager manager, String command) throws ConnectionException {
            ConnectionException cause = null;
            for (int i = 0; i < MAX_ATTEMPTS; ++i) {
                try {
                    Connection nowConnection = manager.getConnection();

                    nowConnection.execute(command);
                    nowConnection.close();
                    return;
                } catch (ConnectionException e) {
                    cause = e;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            throw cause;
        }
    }
}
