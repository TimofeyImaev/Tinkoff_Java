package edu.hw4;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.params.provider.Arguments;
import static java.util.Map.entry;

public class AnimalLists {
    static Arguments[] animalLists() {
        return new Arguments[] {
            Arguments.of(
                Arrays.asList()
            ),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Osborne", Animal.Type.DOG, Animal.Sex.M, 26, 7, 17, true),
                    new Animal(
                        "Benedict", Animal.Type.CAT, Animal.Sex.F, 0, 69, 86, false),
                    new Animal(
                        "Nolan", Animal.Type.SPIDER, Animal.Sex.F, 15, 34, 48, false),
                    new Animal(
                        "Carlin", Animal.Type.BIRD, Animal.Sex.F, 19, 20, 48, true),
                    new Animal(
                        "Jay", Animal.Type.CAT, Animal.Sex.F, 24, 47, 83, true),
                    new Animal(
                        "Admiral", Animal.Type.BIRD, Animal.Sex.F, 5, 4, 35, false),
                    new Animal(
                        "Fall", Animal.Type.DOG, Animal.Sex.M, 6, 49, 27, false),
                    new Animal(
                        "Stream", Animal.Type.CAT, Animal.Sex.M, 25, 19, 73, true)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Caesar", Animal.Type.DOG, Animal.Sex.F, 4, 13, 6, false),
                    new Animal(
                        "Sheriff", Animal.Type.FISH, Animal.Sex.F, 27, 35, 40, true),
                    new Animal(
                        "Cooper", Animal.Type.CAT, Animal.Sex.F, 2, 17, 44, true),
                    new Animal(
                        "Osborne", Animal.Type.SPIDER, Animal.Sex.F, 26, 34, 64, true),
                    new Animal(
                        "Wild", Animal.Type.DOG, Animal.Sex.F, 8, 61, 97, true),
                    new Animal(
                        "Jordan", Animal.Type.DOG, Animal.Sex.F, 26, 69, 56, true),
                    new Animal(
                        "Luke", Animal.Type.DOG, Animal.Sex.M, 18, 24, 3, true),
                    new Animal(
                        "Hobbit", Animal.Type.FISH, Animal.Sex.F, 8, 16, 18, true),
                    new Animal(
                        "Carlin", Animal.Type.SPIDER, Animal.Sex.M, 5, 7, 72, true),
                    new Animal(
                        "Hank", Animal.Type.CAT, Animal.Sex.F, 24, 16, 2, true)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Nolan", Animal.Type.FISH, Animal.Sex.F, 17, 8, 58, true),
                    new Animal(
                        "Carlin", Animal.Type.FISH, Animal.Sex.F, 24, 59, 10, true),
                    new Animal(
                        "Raygun", Animal.Type.BIRD, Animal.Sex.M, 12, 64, 4, false),
                    new Animal(
                        "Wild", Animal.Type.FISH, Animal.Sex.M, 28, 54, 58, false),
                    new Animal(
                        "Percy", Animal.Type.BIRD, Animal.Sex.F, 20, 37, 17, false),
                    new Animal(
                        "Reiner", Animal.Type.CAT, Animal.Sex.F, 12, 41, 35, true),
                    new Animal(
                        "Crystall", Animal.Type.CAT, Animal.Sex.F, 23, 52, 57, true),
                    new Animal(
                        "Sherlock", Animal.Type.BIRD, Animal.Sex.M, 22, 26, 33, true),
                    new Animal(
                        "Hank", Animal.Type.BIRD, Animal.Sex.M, 13, 10, 90, false),
                    new Animal(
                        "Wild", Animal.Type.SPIDER, Animal.Sex.F, 20, 34, 71, false),
                    new Animal(
                        "Sheriff", Animal.Type.DOG, Animal.Sex.M, 19, 30, 27, false),
                    new Animal(
                        "Chase", Animal.Type.SPIDER, Animal.Sex.M, 0, 5, 70, false),
                    new Animal(
                        "Stream", Animal.Type.BIRD, Animal.Sex.F, 26, 6, 2, true),
                    new Animal(
                        "Spike", Animal.Type.BIRD, Animal.Sex.F, 16, 16, 98, false),
                    new Animal(
                        "Hobbit", Animal.Type.DOG, Animal.Sex.M, 28, 47, 54, false),
                    new Animal(
                        "Swen", Animal.Type.SPIDER, Animal.Sex.F, 7, 65, 21, true),
                    new Animal(
                        "Shakespeare", Animal.Type.FISH, Animal.Sex.M, 3, 36, 80, false)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Swen", Animal.Type.FISH, Animal.Sex.F, 4, 18, 16, true),
                    new Animal(
                        "Mars", Animal.Type.CAT, Animal.Sex.M, 13, 34, 30, false),
                    new Animal(
                        "Magic", Animal.Type.BIRD, Animal.Sex.F, 19, 8, 44, false),
                    new Animal(
                        "Nolan", Animal.Type.FISH, Animal.Sex.F, 2, 64, 85, true),
                    new Animal(
                        "Doyle", Animal.Type.DOG, Animal.Sex.F, 18, 20, 43, false),
                    new Animal(
                        "Percy", Animal.Type.SPIDER, Animal.Sex.F, 16, 55, 75, false),
                    new Animal(
                        "Joker", Animal.Type.FISH, Animal.Sex.M, 21, 24, 66, false),
                    new Animal(
                        "Sheriff", Animal.Type.FISH, Animal.Sex.F, 16, 3, 86, false),
                    new Animal(
                        "Admiral", Animal.Type.CAT, Animal.Sex.F, 23, 2, 83, false),
                    new Animal(
                        "Jordan", Animal.Type.CAT, Animal.Sex.F, 24, 46, 76, false),
                    new Animal(
                        "June", Animal.Type.BIRD, Animal.Sex.F, 27, 45, 69, false)
                )),
        };

    }

    static Arguments[] animalListsHeightSorted() {
        return new Arguments[] {
            Arguments.of(
                Arrays.asList()
            ),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Admiral", Animal.Type.BIRD, Animal.Sex.F, 5, 4, 35, false),
                    new Animal(
                        "Osborne", Animal.Type.DOG, Animal.Sex.M, 26, 7, 17, true),
                    new Animal(
                        "Stream", Animal.Type.CAT, Animal.Sex.M, 25, 19, 73, true),
                    new Animal(
                        "Carlin", Animal.Type.BIRD, Animal.Sex.F, 19, 20, 48, true),
                    new Animal(
                        "Nolan", Animal.Type.SPIDER, Animal.Sex.F, 15, 34, 48, false),
                    new Animal(
                        "Jay", Animal.Type.CAT, Animal.Sex.F, 24, 47, 83, true),
                    new Animal(
                        "Fall", Animal.Type.DOG, Animal.Sex.M, 6, 49, 27, false),

                    new Animal(
                        "Benedict", Animal.Type.CAT, Animal.Sex.F, 0, 69, 86, false)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Carlin", Animal.Type.SPIDER, Animal.Sex.M, 5, 7, 72, true),
                    new Animal(
                        "Caesar", Animal.Type.DOG, Animal.Sex.F, 4, 13, 6, false),
                    new Animal(
                        "Hobbit", Animal.Type.FISH, Animal.Sex.F, 8, 16, 18, true),
                    new Animal(
                        "Hank", Animal.Type.CAT, Animal.Sex.F, 24, 16, 2, true),
                    new Animal(
                        "Cooper", Animal.Type.CAT, Animal.Sex.F, 2, 17, 44, true),
                    new Animal(
                        "Luke", Animal.Type.DOG, Animal.Sex.M, 18, 24, 3, true),
                    new Animal(
                        "Osborne", Animal.Type.SPIDER, Animal.Sex.F, 26, 34, 64, true),
                    new Animal(
                        "Sheriff", Animal.Type.FISH, Animal.Sex.F, 27, 35, 40, true),
                    new Animal(
                        "Wild", Animal.Type.DOG, Animal.Sex.F, 8, 61, 97, true),
                    new Animal(
                        "Jordan", Animal.Type.DOG, Animal.Sex.F, 26, 69, 56, true)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Chase", Animal.Type.SPIDER, Animal.Sex.M, 0, 5, 70, false),
                    new Animal(
                        "Stream", Animal.Type.BIRD, Animal.Sex.F, 26, 6, 2, true),
                    new Animal(
                        "Nolan", Animal.Type.FISH, Animal.Sex.F, 17, 8, 58, true),
                    new Animal(
                        "Hank", Animal.Type.BIRD, Animal.Sex.M, 13, 10, 90, false),
                    new Animal(
                        "Spike", Animal.Type.BIRD, Animal.Sex.F, 16, 16, 98, false),
                    new Animal(
                        "Sherlock", Animal.Type.BIRD, Animal.Sex.M, 22, 26, 33, true),
                    new Animal(
                        "Sheriff", Animal.Type.DOG, Animal.Sex.M, 19, 30, 27, false),
                    new Animal(
                        "Wild", Animal.Type.SPIDER, Animal.Sex.F, 20, 34, 71, false),
                    new Animal(
                        "Shakespeare", Animal.Type.FISH, Animal.Sex.M, 3, 36, 80, false),
                    new Animal(
                        "Percy", Animal.Type.BIRD, Animal.Sex.F, 20, 37, 17, false),
                    new Animal(
                        "Reiner", Animal.Type.CAT, Animal.Sex.F, 12, 41, 35, true),
                    new Animal(
                        "Hobbit", Animal.Type.DOG, Animal.Sex.M, 28, 47, 54, false),
                    new Animal(
                        "Crystall", Animal.Type.CAT, Animal.Sex.F, 23, 52, 57, true),
                    new Animal(
                        "Wild", Animal.Type.FISH, Animal.Sex.M, 28, 54, 58, false),
                    new Animal(
                        "Carlin", Animal.Type.FISH, Animal.Sex.F, 24, 59, 10, true),
                    new Animal(
                        "Raygun", Animal.Type.BIRD, Animal.Sex.M, 12, 64, 4, false),
                    new Animal(
                        "Swen", Animal.Type.SPIDER, Animal.Sex.F, 7, 65, 21, true)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Admiral", Animal.Type.CAT, Animal.Sex.F, 23, 2, 83, false),
                    new Animal(
                        "Sheriff", Animal.Type.FISH, Animal.Sex.F, 16, 3, 86, false),
                    new Animal(
                        "Magic", Animal.Type.BIRD, Animal.Sex.F, 19, 8, 44, false),
                    new Animal(
                        "Swen", Animal.Type.FISH, Animal.Sex.F, 4, 18, 16, true),
                    new Animal(
                        "Doyle", Animal.Type.DOG, Animal.Sex.F, 18, 20, 43, false),
                    new Animal(
                        "Joker", Animal.Type.FISH, Animal.Sex.M, 21, 24, 66, false),
                    new Animal(
                        "Mars", Animal.Type.CAT, Animal.Sex.M, 13, 34, 30, false),
                    new Animal(
                        "June", Animal.Type.BIRD, Animal.Sex.F, 27, 45, 69, false),
                    new Animal(
                        "Jordan", Animal.Type.CAT, Animal.Sex.F, 24, 46, 76, false),
                    new Animal(
                        "Percy", Animal.Type.SPIDER, Animal.Sex.F, 16, 55, 75, false),
                    new Animal(
                        "Nolan", Animal.Type.FISH, Animal.Sex.F, 2, 64, 85, true)
                )),
        };
    }

    static Arguments[] animalListsWeightSorted() {
        return new Arguments[] {
            Arguments.of(
                Arrays.asList(),
                8
            ),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Osborne", Animal.Type.DOG, Animal.Sex.M, 26, 7, 17, true),
                    new Animal(
                        "Fall", Animal.Type.DOG, Animal.Sex.M, 6, 49, 27, false),
                    new Animal(
                        "Admiral", Animal.Type.BIRD, Animal.Sex.F, 5, 4, 35, false),
                    new Animal(
                        "Nolan", Animal.Type.SPIDER, Animal.Sex.F, 15, 34, 48, false),
                    new Animal(
                        "Carlin", Animal.Type.BIRD, Animal.Sex.F, 19, 20, 48, true),
                    new Animal(
                        "Stream", Animal.Type.CAT, Animal.Sex.M, 25, 19, 73, true),
                    new Animal(
                        "Jay", Animal.Type.CAT, Animal.Sex.F, 24, 47, 83, true),

                    new Animal(
                        "Benedict", Animal.Type.CAT, Animal.Sex.F, 0, 69, 86, false)
                ), 8),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Hank", Animal.Type.CAT, Animal.Sex.F, 24, 16, 2, true),
                    new Animal(
                        "Luke", Animal.Type.DOG, Animal.Sex.M, 18, 24, 3, true)
                ), 2),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Stream", Animal.Type.BIRD, Animal.Sex.F, 26, 6, 2, true),
                    new Animal(
                        "Raygun", Animal.Type.BIRD, Animal.Sex.M, 12, 64, 4, false),
                    new Animal(
                        "Carlin", Animal.Type.FISH, Animal.Sex.F, 24, 59, 10, true),
                    new Animal(
                        "Percy", Animal.Type.BIRD, Animal.Sex.F, 20, 37, 17, false),
                    new Animal(
                        "Swen", Animal.Type.SPIDER, Animal.Sex.F, 7, 65, 21, true),
                    new Animal(
                        "Sheriff", Animal.Type.DOG, Animal.Sex.M, 19, 30, 27, false),
                    new Animal(
                        "Sherlock", Animal.Type.BIRD, Animal.Sex.M, 22, 26, 33, true),
                    new Animal(
                        "Reiner", Animal.Type.CAT, Animal.Sex.F, 12, 41, 35, true),
                    new Animal(
                        "Hobbit", Animal.Type.DOG, Animal.Sex.M, 28, 47, 54, false),
                    new Animal(
                        "Crystall", Animal.Type.CAT, Animal.Sex.F, 23, 52, 57, true),
                    new Animal(
                        "Nolan", Animal.Type.FISH, Animal.Sex.F, 17, 8, 58, true)
                ), 11
            ),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Swen", Animal.Type.FISH, Animal.Sex.F, 4, 18, 16, true),
                    new Animal(
                        "Mars", Animal.Type.CAT, Animal.Sex.M, 13, 34, 30, false),
                    new Animal(
                        "Doyle", Animal.Type.DOG, Animal.Sex.F, 18, 20, 43, false),
                    new Animal(
                        "Magic", Animal.Type.BIRD, Animal.Sex.F, 19, 8, 44, false),
                    new Animal(
                        "Joker", Animal.Type.FISH, Animal.Sex.M, 21, 24, 66, false),
                    new Animal(
                        "June", Animal.Type.BIRD, Animal.Sex.F, 27, 45, 69, false)
                ), 6),
        };
    }

    static Arguments[] amountOfAnimalsInEverySpecies() {
        return new Arguments[]{
            Arguments.of(
                Map.<Animal.Type, Long>ofEntries(
                )
            ),
            Arguments.of(
                Map.<Animal.Type, Long>ofEntries(
                    entry(Animal.Type.CAT, 3L),
                    entry(Animal.Type.DOG, 2L),
                    entry(Animal.Type.SPIDER, 1L),
                    entry(Animal.Type.BIRD, 2L)
                )
            ),
            Arguments.of(
                Map.<Animal.Type, Long>ofEntries(
                    entry(Animal.Type.CAT, 2L),
                    entry(Animal.Type.DOG, 4L),
                    entry(Animal.Type.FISH, 2L),
                    entry(Animal.Type.SPIDER, 2L)
                )
            ),
            Arguments.of(
                Map.<Animal.Type, Long>ofEntries(
                    entry(Animal.Type.CAT, 2L),
                    entry(Animal.Type.DOG, 2L),
                    entry(Animal.Type.FISH, 4L),
                    entry(Animal.Type.SPIDER, 3L),
                    entry(Animal.Type.BIRD, 6L)
                )
            ),
            Arguments.of(
                Map.<Animal.Type, Long>ofEntries(
                    entry(Animal.Type.CAT, 3L),
                    entry(Animal.Type.DOG, 1L),
                    entry(Animal.Type.FISH, 4L),
                    entry(Animal.Type.SPIDER, 1L),
                    entry(Animal.Type.BIRD, 2L)
                )
            ),
        };
    }
}
