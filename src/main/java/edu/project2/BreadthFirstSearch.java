package edu.project2;

import edu.hw1.Pair;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
import static edu.project2.ShowLabyrinth.writeLabyrinth;

public class BreadthFirstSearch {
    String[][] labyrinth;
    JFrame frame;
    JLabel[] labels;
    LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
    ArrayList<Pair<Integer, Integer>> path = new ArrayList<>();

    public BreadthFirstSearch(
        String[][] labyrinth,
        JFrame frame,
        JLabel[] labels
    ) {
        this.labyrinth = labyrinth;
        this.frame = frame;
        this.labels = labels;
    }

    void iterateThroughPath(
        Pair<Integer, Integer>[][] parent,
        Integer x1,
        Integer y1,
        Integer x2,
        Integer y2,
        Pair<Integer, Integer> vertex
    ) throws InterruptedException {
        Pair<Integer, Integer> nowVertex = vertex;
        while (!nowVertex.first.equals(x1) || !nowVertex.second.equals(y1)) {
            labyrinth[nowVertex.first][nowVertex.second] = greenCeil;
            writeLabyrinth(labels, labyrinth);

            TimeUnit.MILLISECONDS.sleep(SEVENTY);
            path.add(nowVertex);

            nowVertex = parent[nowVertex.first][nowVertex.second];
        }
        path.add(new Pair<>(x1, y1));
    }

    private void bfsPathSearcher(
        boolean[][] used,
        Pair<Integer, Integer>[][] parent,
        Integer x1,
        Integer y1,
        Integer x2,
        Integer y2,
        boolean isNeedToPrintPath
    ) throws InterruptedException {
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> vertex = queue.peek();
            queue.pollFirst();

            if (vertex.first.equals(x2) && vertex.second.equals(y2)) {
                if (isNeedToPrintPath) {
                    iterateThroughPath(
                        parent,
                        x1, y1,
                        x2, y2,
                        vertex
                    );

                    labyrinth[vertex.first][vertex.second] = greenCeil;
                    writeLabyrinth(labels, labyrinth);

                    TimeUnit.MILLISECONDS.sleep(SEVENTY);
                }
                break;
            }

            if (!used[vertex.first][vertex.second]) {
                used[vertex.first][vertex.second] = true;

                if (isNeedToPrintPath) {
                    labyrinth[vertex.first][vertex.second] = blueCeil;
                    writeLabyrinth(labels, labyrinth);

                    TimeUnit.MILLISECONDS.sleep(SEVENTY);
                }

                for (var each : NEIGHBOURS_OF_CEIL) {
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
            System.arraycopy(labyrinth[i], 0, saveLabyrinth[i], 0, labyrinth.length);
        }

        if (isNeedToPrintPath) {
            labyrinth[x2][y2] = greenCeil;
            frame = new JFrame("BfsDemonstration");
            frame.setLayout(new BorderLayout());
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(SEVEN_HUNDRED, SEVEN_HUNDRED);

            labels = new JLabel[labyrinth.length];
            for (int i = 0; i < labyrinth.length; ++i) {
                labels[i] = new JLabel("flag2");
                frame.add(labels[i], BorderLayout.NORTH);
            }

            frame.setLayout(new FlowLayout(FlowLayout.LEFT));
            frame.setVisible(true);
        }

        boolean[][] used = new boolean[labyrinth.length][labyrinth.length];
        Pair<Integer, Integer>[][] parent = new Pair[labyrinth.length][labyrinth.length];
        path = new ArrayList<>();

        queue.add(new Pair<>(x1, y1));

        bfsPathSearcher(
            used,
            parent,
            x1, y1,
            x2, y2,
            isNeedToPrintPath
        );

        for (int i = 0; i < labyrinth.length; ++i) {
            System.arraycopy(saveLabyrinth[i], 0, labyrinth[i], 0, labyrinth.length);
        }
        return path;
    }
}
