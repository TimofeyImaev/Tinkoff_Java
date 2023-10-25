package edu.project1;

import java.util.Random;

@SuppressWarnings({"PMD", "checkstyle:hideutilityclassconstructor"})
public class GetRandomWord {
    static String[] dictionary = {
        "banana", "apple", "orange", "lemon",
        "nectarine", "pear", "plum", "mango",
        "kiwi", "avocado", "melon", "blueberry",
    };

    public static String getRandomWord() {
        Random random = new Random();

        return dictionary[random.nextInt(dictionary.length)];
    }
}
