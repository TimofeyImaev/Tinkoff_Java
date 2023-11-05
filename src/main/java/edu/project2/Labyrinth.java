package edu.project2;

import edu.hw1.Pair;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Labyrinth {
    private static final ArrayList<Pair<Integer, Integer>> neighboursOfCeil = new ArrayList<>(List.of(
        new Pair<>(1, 0),
        new Pair<>(-1, 0),
        new Pair<>(0, -1),
        new Pair<>(0, 1)
    ));
    private final String cyanCeil = "<font color = \"cyan\">▉▉<>";
    private final String orangeCeil = "<font color = \"orange\">▉▉<>";
    private final String blueCeil = "<font color = \"blue\">▉▉<>";
    private final String greenCeil = "<font color = \"green\">▉▉<>";
    private final String redCeil = "<font color = \"red\">▉▉<>";

    String[][] labyrinth;
    JFrame frame;
    JLabel[] labels;

    private Labyrinth() {

    }

    public Labyrinth(int sideOfLabyrinth) {
        sideOfLabyrinth = sideOfLabyrinth * 2 + 1;
        this.labyrinth = new String[sideOfLabyrinth][sideOfLabyrinth];
    }

    public Labyrinth(String[][] preparedLabyrinth) {
        this.labyrinth = preparedLabyrinth;
    }

    private void dfsPathBreaker(
        Integer x, Integer y,
        boolean used[][]
    ) {
        used[x][y] = true;
        labyrinth[x][y] = orangeCeil;
        //writeLabyrinth();

        Collections.shuffle(neighboursOfCeil);
        for (var shift : neighboursOfCeil) {
            Integer neighbourX = x + shift.first * 2;
            Integer neighbourY = y + shift.second * 2;

            if (neighbourX.compareTo(0) > 0 && neighbourY.compareTo(0) > 0
                && neighbourX.compareTo(labyrinth.length - 1) < 0
                && neighbourY.compareTo(labyrinth.length - 1) < 0
                && !used[neighbourX][neighbourY]) {
                labyrinth[x + shift.first][y + shift.second] = orangeCeil;
                dfsPathBreaker(neighbourX, neighbourY, used);
            }
        }
    }

    void buildLabyrinthUsingRecursiveBacktracker() {
        for (int i = 0; i < labyrinth.length; ++i) {
            for (int j = 0; j < labyrinth.length; ++j) {
                labyrinth[i][j] = cyanCeil;
            }
        }

        boolean used[][] = new boolean[labyrinth.length][labyrinth.length];

        dfsPathBreaker(1, 1, used);
    }

    private boolean dfsPathSearcher(
        Integer x1, Integer y1,
        Integer x2, Integer y2,
        boolean used[][],
        ArrayList<Pair<Integer, Integer>> path,
        boolean isNeedToPrintPath
    ) throws InterruptedException, IOException {
        if (isNeedToPrintPath) {
            labyrinth[x1][y1] = blueCeil;
            writeLabyrinth();

            TimeUnit.MILLISECONDS.sleep(70);
        }
        used[x1][y1] = true;
        //writeLabyrinth();

        if (x2.equals(x1) && y2.equals(y1)) {
            path.add(new Pair<>(x1, y1));

            if (isNeedToPrintPath) {
                labyrinth[x1][y1] = greenCeil;
                writeLabyrinth();

                TimeUnit.MILLISECONDS.sleep(70);
            }

            return true;
        }

        for (var shift : neighboursOfCeil) {
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

                    if (isNeedToPrintPath) {
                        labyrinth[x1][y1] = greenCeil;
                        writeLabyrinth();

                        TimeUnit.MILLISECONDS.sleep(70);
                    }

                    return true;
                } else {

                }
            }
        }

        if (isNeedToPrintPath) {
            labyrinth[x1][y1] = redCeil;
            writeLabyrinth();

            TimeUnit.MILLISECONDS.sleep(70);
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
        frame = new JFrame("DfsDemonstration");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        labels = new JLabel[labyrinth.length];
        for (int i = 0; i < labyrinth.length; ++i) {
            labels[i] = new JLabel("flag");
            frame.add(labels[i], BorderLayout.NORTH);
        }

        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setVisible(true);

        boolean used[][] = new boolean[labyrinth.length][labyrinth.length];
        ArrayList<Pair<Integer, Integer>> path = new ArrayList<>();

        dfsPathSearcher(x1, y1, x2, y2, used, path, isNeedToPrintPath);

        labyrinth = saveLabyrinth;
        writeLabyrinth();
        return path;
    }

    ArrayList<Pair<Integer, Integer>> findPathWithBfs(
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
        frame = new JFrame("DfsDemonstration");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        labels = new JLabel[labyrinth.length];
        for (int i = 0; i < labyrinth.length; ++i) {
            labels[i] = new JLabel("flag");
            frame.add(labels[i], BorderLayout.NORTH);
        }

        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setVisible(true);

        boolean used[][] = new boolean[labyrinth.length][labyrinth.length];
        Pair<Integer, Integer> parent[][] = new Pair[labyrinth.length][labyrinth.length];
        ArrayList<Pair<Integer, Integer>> path = new ArrayList<>();

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(x1, y1));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> vertex = queue.peek();
            queue.pollFirst();

            if (isNeedToPrintPath) {
                labyrinth[vertex.first][vertex.second] = blueCeil;
                writeLabyrinth();

                TimeUnit.MILLISECONDS.sleep(70);
            }

            if (vertex.first.equals(x2) && vertex.second.equals(y2)) {
                if (isNeedToPrintPath) {
                    while (!vertex.first.equals(x1) || !vertex.second.equals(y1)) {
                        labyrinth[vertex.first][vertex.second] = greenCeil;
                        writeLabyrinth();

                        TimeUnit.MILLISECONDS.sleep(70);

                        vertex = parent[vertex.first][vertex.second];
                    }

                    labyrinth[vertex.first][vertex.second] = greenCeil;
                    writeLabyrinth();

                    TimeUnit.MILLISECONDS.sleep(70);
                }
            }

            if (!used[vertex.first][vertex.second]) {
                used[vertex.first][vertex.second] = true;

                for (var each : neighboursOfCeil) {
                    Integer neighbourX = vertex.first + each.first;
                    Integer neighbourY = vertex.second + each.second;

                    if (neighbourX.compareTo(0) > 0 && neighbourY.compareTo(0) > 0
                        && neighbourX.compareTo(labyrinth.length - 1) < 0
                        && neighbourY.compareTo(labyrinth.length - 1) < 0
                        && !used[neighbourX][neighbourY]
                        && (labyrinth[neighbourX][neighbourY].equals(orangeCeil)
                        || labyrinth[neighbourX][neighbourY].equals(greenCeil))) {

                        parent[neighbourX][neighbourY] = vertex;
                        queue.add(new Pair<>(neighbourX, neighbourY));
                    }
                }
            }
        }

        labyrinth = saveLabyrinth;
        return path;
    }

    void writeLabyrinth() throws IOException, InterruptedException {
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

        TimeUnit.MILLISECONDS.sleep(2);
    }
}
