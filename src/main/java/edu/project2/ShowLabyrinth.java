package edu.project2;

import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;

public class ShowLabyrinth {
    private ShowLabyrinth() {

    }

    public static void writeLabyrinth(JLabel[] labels, String[][] labyrinth) {
        for (int i = 0; i < labyrinth.length; ++i) {

            String text = "<html>";
            text += "<p style=\"font-size: 12px; \">";
            for (int j = 0; j < labyrinth.length; ++j) {
                text += labyrinth[i][j];
            }
            text += "</p></html>";
            labels[i].setText(text);
            //panel.setBorder(BorderFactory.createEmptyBorder(-20, 0, -20, 0));
        }

        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
