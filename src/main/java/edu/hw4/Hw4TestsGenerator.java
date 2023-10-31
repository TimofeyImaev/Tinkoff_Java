package edu.hw4;

import java.util.Random;

public class Hw4TestsGenerator {
    private static final String[] animalNames = new String[] {
        "Admiral",
        "Baloo",
        "Baron",
        "Benedict",
        "Blitz",
        "Blues",
        "Bond",
        "Boomer",
        "Bruno",
        "Caesar",
        "Carlin",
        "Carter",
        "Casper",
        "Celt",
        "Chase",
        "Cooper",
        "Crystall",
        "Dobby",
        "Doyle",
        "Duke",
        "Fall",
        "Gold",
        "Hank",
        "Hide",
        "Hobbit",
        "Hudson",
        "Jarvis",
        "Jay",
        "Joker",
        "Jordan",
        "June",
        "Laser",
        "Light",
        "Luke",
        "Luther",
        "Magic",
        "Mars",
        "McFly",
        "Melvin",
        "Murray",
        "Newton",
        "Nolan",
        "Osborne",
        "Percival",
        "Percy",
        "Ramsey",
        "Raygun",
        "Reiner",
        "Shakespeare",
        "Sheldon",
        "Sheriff",
        "Sherlock",
        "Smith",
        "Spenser",
        "Spike",
        "Stream",
        "Swen",
        "Viscount",
        "Watson",
        "Wild",
    };

    public static void main(String[] args) {
        Random rn = new Random();

        System.out.println("return new Arguments[]{");
        for (int i = 0; i < 5; ++i) {
            System.out.println("Arguments.of(");
            int animalsAmount = rn.nextInt(20);

            for (int j = 0; j < animalsAmount; ++j) {
                System.out.println("new Animal(");
                System.out.print('"' + animalNames[rn.nextInt(animalNames.length)] + '"');
                System.out.print(',');

                System.out.print("Animal.Type.");
                System.out.print(Animal.Type.values()[rn.nextInt(Animal.Type.values().length)]);
                System.out.print(',');

                System.out.print("Animal.Sex.");
                System.out.print(Animal.Sex.values()[rn.nextInt(Animal.Sex.values().length)]);
                System.out.print(',');

                System.out.print(rn.nextInt(30));
                System.out.print(',');

                System.out.print(rn.nextInt(70));
                System.out.print(',');

                System.out.print(rn.nextInt(100));
                System.out.print(',');

                System.out.print(rn.nextInt(Animal.Sex.values().length) % 2 == 1);
                if (j == animalsAmount - 1) {
                    System.out.println(")");
                } else {
                    System.out.println("),");
                }
            }
            System.out.println("),");
        }
        System.out.println("};");
    }
}
