package edu.project2;

import edu.hw1.Pair;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import static edu.project2.Constants.NEIGHBOURS_OF_CEIL;
import static edu.project2.Constants.SEVENTY;
import static edu.project2.Constants.SEVEN_HUNDRED;
import static edu.project2.Constants.blueCeil;
import static edu.project2.Constants.greenCeil;
import static edu.project2.Constants.orangeCeil;
import static edu.project2.Constants.redCeil;
import static edu.project2.ShowLabyrinth.writeLabyrinth;

public class DepthFirstSearch {
    String[][] labyrinth;
    JFrame frame;
    JLabel[] labels;

    public DepthFirstSearch(
        String[][] labyrinth,
        JFrame frame,
        JLabel[] labels
    ) {
        this.labyrinth = labyrinth;
        this.frame = frame;
        this.labels = labels;
    }

    private boolean dfsPathSearcher(
        Integer x1, Integer y1,
        Integer x2, Integer y2,
        boolean[][] used,
        ArrayList<Pair<Integer, Integer>> path,
        boolean isNeedToPrintPath
    ) throws InterruptedException, IOException {
        if (isNeedToPrintPath) {
            labyrinth[x1][y1] = blueCeil;
            writeLabyrinth(labels, labyrinth);

            TimeUnit.MILLISECONDS.sleep(SEVENTY);
        }
        used[x1][y1] = true;
        //writeLabyrinth(labels, labyrinth);

        if (x2.equals(x1) && y2.equals(y1)) {
            path.add(new Pair<>(x1, y1));

            labyrinth[x1][y1] = greenCeil;
            if (isNeedToPrintPath) {
                writeLabyrinth(labels, labyrinth);

                TimeUnit.MILLISECONDS.sleep(SEVENTY);
            }

            return true;
        }

        for (var shift : NEIGHBOURS_OF_CEIL) {
            Integer neighbourX = x1 + shift.first;
            Integer neighbourY = y1 + shift.second;

            if (neighbourX.compareTo(0) > 0 && neighbourY.compareTo(0) > 0
                && neighbourX.compareTo(labyrinth.length - 1) < 0
                && neighbourY.compareTo(labyrinth.length - 1) < 0
                && !used[neighbourX][neighbourY]
                && (labyrinth[neighbourX][neighbourY].equals(orangeCeil)
                || labyrinth[neighbourX][neighbourY].equals(greenCeil))) {

                boolean isFoundPath = dfsPathSearcher(neighbourX, neighbourY, x2, y2, used, path, isNeedToPrintPath);

                if (isFoundPath) {
                    path.add(new Pair<>(x1, y1));

                    labyrinth[x1][y1] = greenCeil;

                    if (isNeedToPrintPath) {
                        writeLabyrinth(labels, labyrinth);

                        TimeUnit.MILLISECONDS.sleep(SEVENTY);
                    }

                    return true;
                }
            }
        }

        labyrinth[x1][y1] = redCeil;

        if (isNeedToPrintPath) {
            writeLabyrinth(labels, labyrinth);

            TimeUnit.MILLISECONDS.sleep(SEVENTY);
        }

        return false;
    }

    ArrayList<Pair<Integer, Integer>> findPathWithDfs(
        Integer x1,
        Integer y1,
        Integer x2,
        Integer y2,
        boolean isNeedToPrintPath
    ) throws InterruptedException, IOException {
        String[][] saveLabyrinth = new String[labyrinth.length][labyrinth.length];

        for (int i = 0; i < labyrinth.length; ++i) {
            for (int j = 0; j < labyrinth.length; ++j) {
                saveLabyrinth[i][j] = labyrinth[i][j];
            }
        }

        labyrinth[x2][y2] = greenCeil;

        if (isNeedToPrintPath) {
            frame = new JFrame("DfsDemonstration");
            frame.setLayout(new BorderLayout());
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(SEVEN_HUNDRED, SEVEN_HUNDRED);

            labels = new JLabel[labyrinth.length];
            for (int i = 0; i < labyrinth.length; ++i) {
                labels[i] = new JLabel("flag1");
                frame.add(labels[i], BorderLayout.NORTH);
            }

            frame.setLayout(new FlowLayout(FlowLayout.LEFT));
            frame.setVisible(true);
        }

        boolean[][] used = new boolean[labyrinth.length][labyrinth.length];
        ArrayList<Pair<Integer, Integer>> path = new ArrayList<>();

        dfsPathSearcher(x1, y1, x2, y2, used, path, isNeedToPrintPath);

        for (int i = 0; i < labyrinth.length; ++i) {
            System.arraycopy(saveLabyrinth[i], 0, labyrinth[i], 0, labyrinth.length);
        }

        if (isNeedToPrintPath) {
            writeLabyrinth(labels, labyrinth);
        }
        return path;
    }
}
