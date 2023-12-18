package edu.project2;

import edu.hw1.Pair;
import java.util.ArrayList;
import java.util.List;

public class Constants {
    static final ArrayList<Pair<Integer, Integer>> NEIGHBOURS_OF_CEIL = new ArrayList<>(List.of(
        new Pair<>(1, 0),
        new Pair<>(-1, 0),
        new Pair<>(0, -1),
        new Pair<>(0, 1)
    ));
    final static int SEVENTY = 70;
    final static int SEVEN_HUNDRED = 700;
    static String cyanCeil = "<font color = \"cyan\">▉▉<>";
    static String orangeCeil = "<font color = \"orange\">▉▉<>";
    static String blueCeil = "<font color = \"blue\">▉▉<>";
    static String greenCeil = "<font color = \"green\">▉▉<>";
    static String redCeil = "<font color = \"red\">▉▉<>";

    private Constants() {

    }
}
