package edu.project1;

import edu.project1.sessionStatuses.ActingStatus;
import edu.project1.sessionStatuses.LoseStatus;
import edu.project1.sessionStatuses.Session;
import edu.project1.sessionStatuses.WinStatus;
import java.io.PrintWriter;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"PMD", "checkstyle:hideutilityclassconstructor"})
public class Hangman {
    private static Scanner in = new Scanner(System.in);
    private static final String STOP = "stop";
    private static final Integer FIVE = 5;
    private static final String SURRENDER = "surrender";
    private static final String SURRENDER_RETURN = "surrender (Write anything to continue)\n";
    private static final Logger LOGGER = LogManager.getLogger();

    public static String turn(String command, ActingStatus game) {
        Session gameResult = null;
        String newCommand = command;

        if (command.equals(SURRENDER)) {
            newCommand = SURRENDER_RETURN;
        }

        if (newCommand.equals(STOP) || newCommand.equals(SURRENDER_RETURN)) {
            return newCommand;
        }

        try {
            game.changeStatus(command);
        } catch (ActingStatus.WrongMoveException e) {
            return "Wrong input!\n";
        }

        if (game.isLettersGuessed()) {
            gameResult = new WinStatus();
        }

        if (game.getMistakesCnt() >= FIVE) {
            gameResult = new LoseStatus();
        }

        if (gameResult != null) {
            gameResult.changeStatus(command);

            return gameResult.getLastMessage();
        }

        return game.getLastMessage();
    }

    public static void run() {
        ActingStatus game = new ActingStatus();
        PrintWriter out = new PrintWriter(System.out);

        out.println("To give up, write \"surrender\"");
        out.println("To end playing, write \"stop\"");
        out.println(game.getLastMessage());
        out.flush();

        do {
            String command = in.nextLine();
            String result = turn(command, game);

            out.println(result);
            out.flush();

            if (result.equals(STOP)) {
                break;
            }

            if (result.equals(SURRENDER_RETURN)
                || result.equals("You lost! (Write anything to continue)\n")
                || result.equals("You won!\n")) {
                command = in.nextLine();

                game = new ActingStatus();

                out.println(game.getLastMessage());
                out.flush();
            }
        } while (true);
    }
}
