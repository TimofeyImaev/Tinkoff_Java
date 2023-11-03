package edu.hw4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        return new Arguments[] {
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

    static Arguments[] animalsWithLongestName() {
        return new Arguments[] {
            Arguments.of((Object) null),
            Arguments.of(
                new Animal(
                    "Benedict", Animal.Type.CAT, Animal.Sex.F, 0, 69, 86, false)
            ),
            Arguments.of(
                new Animal(
                    "Sheriff", Animal.Type.FISH, Animal.Sex.F, 27, 35, 40, true)
            ),
            Arguments.of(
                new Animal(
                    "Shakespeare", Animal.Type.FISH, Animal.Sex.M, 3, 36, 80, false)
            ),
            Arguments.of(
                new Animal(
                    "Sheriff", Animal.Type.FISH, Animal.Sex.F, 16, 3, 86, false)
            ),
        };
    }

    static Arguments[] mostCommonSex() {
        return new Arguments[] {
            Arguments.of((Object) null),
            Arguments.of(Animal.Sex.F),
            Arguments.of(Animal.Sex.F),
            Arguments.of(Animal.Sex.F),
            Arguments.of(Animal.Sex.F),
        };
    }

    static Arguments[] heaviestAnimal() {
        return new Arguments[] {
            Arguments.of(
                Map.<Animal.Type, Animal>ofEntries(

                )
            ),
            Arguments.of(
                Map.<Animal.Type, Animal>ofEntries(
                    entry(Animal.Type.DOG, new Animal(
                        "Fall", Animal.Type.DOG, Animal.Sex.M, 6, 49, 27, false)
                    ),
                    entry(Animal.Type.CAT, new Animal(
                        "Benedict", Animal.Type.CAT, Animal.Sex.F, 0, 69, 86, false)
                    ),
                    entry(Animal.Type.SPIDER, new Animal(
                        "Nolan", Animal.Type.SPIDER, Animal.Sex.F, 15, 34, 48, false)

                    ),
                    entry(Animal.Type.BIRD, new Animal(
                        "Carlin", Animal.Type.BIRD, Animal.Sex.F, 19, 20, 48, true)
                    )
                )
            ),
            Arguments.of(
                Map.<Animal.Type, Animal>ofEntries(
                    entry(Animal.Type.DOG, new Animal(
                        "Wild", Animal.Type.DOG, Animal.Sex.F, 8, 61, 97, true)
                    ),
                    entry(Animal.Type.CAT, new Animal(
                        "Cooper", Animal.Type.CAT, Animal.Sex.F, 2, 17, 44, true)
                    ),
                    entry(Animal.Type.SPIDER, new Animal(
                        "Carlin", Animal.Type.SPIDER, Animal.Sex.M, 5, 7, 72, true)

                    ),
                    //entry(Animal.Type.BIRD, ),
                    entry(Animal.Type.FISH, new Animal(
                        "Sheriff", Animal.Type.FISH, Animal.Sex.F, 27, 35, 40, true)
                    )
                )
            ),
            Arguments.of(
                Map.<Animal.Type, Animal>ofEntries(
                    entry(Animal.Type.DOG, new Animal(
                        "Hobbit", Animal.Type.DOG, Animal.Sex.M, 28, 47, 54, false)
                    ),
                    entry(Animal.Type.CAT, new Animal(
                        "Crystall", Animal.Type.CAT, Animal.Sex.F, 23, 52, 57, true)
                    ),
                    entry(Animal.Type.SPIDER, new Animal(
                        "Wild", Animal.Type.SPIDER, Animal.Sex.F, 20, 34, 71, false)
                    ),
                    entry(
                        Animal.Type.BIRD,
                        new Animal(
                            "Spike", Animal.Type.BIRD, Animal.Sex.F, 16, 16, 98, false)
                    ),
                    entry(Animal.Type.FISH, new Animal(
                        "Shakespeare", Animal.Type.FISH, Animal.Sex.M, 3, 36, 80, false)
                    )
                )
            ),
            Arguments.of(
                Map.<Animal.Type, Animal>ofEntries(
                    entry(Animal.Type.DOG, new Animal(
                        "Doyle", Animal.Type.DOG, Animal.Sex.F, 18, 20, 43, false)
                    ),
                    entry(Animal.Type.CAT, new Animal(
                        "Admiral", Animal.Type.CAT, Animal.Sex.F, 23, 2, 83, false)
                    ),
                    entry(Animal.Type.SPIDER, new Animal(
                        "Percy", Animal.Type.SPIDER, Animal.Sex.F, 16, 55, 75, false)

                    ),
                    entry(Animal.Type.BIRD, new Animal(
                        "June", Animal.Type.BIRD, Animal.Sex.F, 27, 45, 69, false)
                    ),
                    entry(Animal.Type.FISH, new Animal(
                        "Sheriff", Animal.Type.FISH, Animal.Sex.F, 16, 3, 86, false)
                    )
                )
            )
        };
    }

    static Arguments[] kthOldestAnimal() {
        return new Arguments[] {
            Arguments.of(
                1, null
            ),
            Arguments.of(
                3,
                new Animal(
                    "Jay", Animal.Type.CAT, Animal.Sex.F, 24, 47, 83, true)
            ),
            Arguments.of(
                2,
                new Animal(
                    "Osborne", Animal.Type.SPIDER, Animal.Sex.F, 26, 34, 64, true)
            ),
            Arguments.of(
                14,
                new Animal(
                    "Reiner", Animal.Type.CAT, Animal.Sex.F, 12, 41, 35, true)
            ),
            Arguments.of(
                5,
                new Animal(
                    "Magic", Animal.Type.BIRD, Animal.Sex.F, 19, 8, 44, false)
            ),
        };
    }

    static Arguments[] heaviestAnimalLowerK() {
        return new Arguments[] {
            Arguments.of(
                5,
                Optional.empty()
            ),
            Arguments.of(
                21,
                Optional.of(new Animal(
                    "Stream", Animal.Type.CAT, Animal.Sex.M, 25, 19, 73, true)
                )
            ),
            Arguments.of(
                12,
                Optional.of(new Animal(
                    "Carlin", Animal.Type.SPIDER, Animal.Sex.M, 5, 7, 72, true)
                )
            ),
            Arguments.of(
                40,
                Optional.of(new Animal(
                    "Spike", Animal.Type.BIRD, Animal.Sex.F, 16, 16, 98, false)
                )
            ),
            Arguments.of(
                14,
                Optional.of(new Animal(
                    "Sheriff", Animal.Type.FISH, Animal.Sex.F, 16, 3, 86, false)
                )
            ),
        };
    }

    static Arguments[] countOfPaws() {
        return new Arguments[] {
            Arguments.<Integer>of(0),
            Arguments.<Integer>of(32),
            Arguments.<Integer>of(40),
            Arguments.<Integer>of(52),
            Arguments.<Integer>of(28),
        };
    }

    static Arguments[] animalsWhichAgeNotEqualsCountOfPaws() {
        return new Arguments[] {
            Arguments.of(List.<Animal>of(

            )),
            Arguments.of(List.<Animal>of(

            )),
            Arguments.of(List.<Animal>of(
                new Animal(
                    "Caesar", Animal.Type.DOG, Animal.Sex.F, 4, 13, 6, false)
            )),
            Arguments.of(List.<Animal>of(

            )),
            Arguments.of(List.<Animal>of(

            )),
        };
    }

    static Arguments[] listOfAnimalsWhichBitesAndHeightMoreTen() {
        return new Arguments[] {
            Arguments.of(List.<Animal>of(

            )),
            Arguments.of(List.<Animal>of(
                new Animal(
                    "Carlin", Animal.Type.BIRD, Animal.Sex.F, 19, 20, 48, true),
                new Animal(
                    "Jay", Animal.Type.CAT, Animal.Sex.F, 24, 47, 83, true),
                new Animal(
                    "Stream", Animal.Type.CAT, Animal.Sex.M, 25, 19, 73, true)
            )),
            Arguments.of(List.<Animal>of(
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
                    "Hank", Animal.Type.CAT, Animal.Sex.F, 24, 16, 2, true)
            )),
            Arguments.of(List.<Animal>of(
                new Animal(
                    "Carlin", Animal.Type.FISH, Animal.Sex.F, 24, 59, 10, true),
                new Animal(
                    "Reiner", Animal.Type.CAT, Animal.Sex.F, 12, 41, 35, true),
                new Animal(
                    "Crystall", Animal.Type.CAT, Animal.Sex.F, 23, 52, 57, true),
                new Animal(
                    "Sherlock", Animal.Type.BIRD, Animal.Sex.M, 22, 26, 33, true),
                new Animal(
                    "Swen", Animal.Type.SPIDER, Animal.Sex.F, 7, 65, 21, true)
            )),
            Arguments.of(List.<Animal>of(
                new Animal(
                    "Swen", Animal.Type.FISH, Animal.Sex.F, 4, 18, 16, true),
                new Animal(
                    "Nolan", Animal.Type.FISH, Animal.Sex.F, 2, 64, 85, true)
            )),
        };
    }

    static Arguments[] amountOfAnimalsWhichWeightMoreHeight() {
        return new Arguments[] {
            Arguments.<Integer>of(0),
            Arguments.<Integer>of(7),
            Arguments.<Integer>of(6),
            Arguments.<Integer>of(10),
            Arguments.<Integer>of(9),
        };
    }

    static Arguments[] isAnimalsListHadDogWithHeightMoreOrEqualsK() {
        return new Arguments[] {
            Arguments.of(2, false),
            Arguments.of(25, true),
            Arguments.of(70, false),
            Arguments.of(44, true),
            Arguments.of(12, true),
        };
    }

    static Arguments[] findTotalWeightOfEveryTypeFromKToLAge() {
        return new Arguments[] {
            Arguments.of(
                5, 10,
                Map.<Animal.Type, Integer>ofEntries(
                )
            ),
            Arguments.of(
                6, 17,
                Map.<Animal.Type, Integer>ofEntries(
                    entry(Animal.Type.DOG, 27),
                    entry(Animal.Type.SPIDER, 48)
                )
            ),
            Arguments.of(
                12, 35,
                Map.<Animal.Type, Integer>ofEntries(
                    entry(Animal.Type.DOG, 59),
                    entry(Animal.Type.CAT, 2),
                    entry(Animal.Type.SPIDER, 64),
                    entry(Animal.Type.FISH, 40)
                )
            ),
            Arguments.of(
                2, 51,
                Map.<Animal.Type, Integer>ofEntries(
                    entry(Animal.Type.DOG, 81),
                    entry(Animal.Type.CAT, 92),
                    entry(Animal.Type.SPIDER, 92),
                    entry(Animal.Type.FISH, 206),
                    entry(Animal.Type.BIRD, 244)
                )
            ),
            Arguments.of(
                22, 34,
                Map.<Animal.Type, Integer>ofEntries(
                    entry(Animal.Type.CAT, 159),
                    entry(Animal.Type.BIRD, 69)
                )
            ),
        };
    }

    static Arguments[] animalsListSortedByTypeSexName() {
        return new Arguments[] {
            Arguments.of(
                Arrays.asList()
            ),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Stream", Animal.Type.CAT, Animal.Sex.M, 25, 19, 73, true),
                    new Animal(
                        "Benedict", Animal.Type.CAT, Animal.Sex.F, 0, 69, 86, false),
                    new Animal(
                        "Jay", Animal.Type.CAT, Animal.Sex.F, 24, 47, 83, true),
                    new Animal(
                        "Fall", Animal.Type.DOG, Animal.Sex.M, 6, 49, 27, false),
                    new Animal(
                        "Osborne", Animal.Type.DOG, Animal.Sex.M, 26, 7, 17, true),
                    new Animal(
                        "Admiral", Animal.Type.BIRD, Animal.Sex.F, 5, 4, 35, false),
                    new Animal(
                        "Carlin", Animal.Type.BIRD, Animal.Sex.F, 19, 20, 48, true),
                    new Animal(
                        "Nolan", Animal.Type.SPIDER, Animal.Sex.F, 15, 34, 48, false)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Cooper", Animal.Type.CAT, Animal.Sex.F, 2, 17, 44, true),
                    new Animal(
                        "Hank", Animal.Type.CAT, Animal.Sex.F, 24, 16, 2, true),
                    new Animal(
                        "Luke", Animal.Type.DOG, Animal.Sex.M, 18, 24, 3, true),
                    new Animal(
                        "Caesar", Animal.Type.DOG, Animal.Sex.F, 4, 13, 6, false),
                    new Animal(
                        "Jordan", Animal.Type.DOG, Animal.Sex.F, 26, 69, 56, true),
                    new Animal(
                        "Wild", Animal.Type.DOG, Animal.Sex.F, 8, 61, 97, true),
                    new Animal(
                        "Hobbit", Animal.Type.FISH, Animal.Sex.F, 8, 16, 18, true),
                    new Animal(
                        "Sheriff", Animal.Type.FISH, Animal.Sex.F, 27, 35, 40, true),
                    new Animal(
                        "Carlin", Animal.Type.SPIDER, Animal.Sex.M, 5, 7, 72, true),
                    new Animal(
                        "Osborne", Animal.Type.SPIDER, Animal.Sex.F, 26, 34, 64, true)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Crystall", Animal.Type.CAT, Animal.Sex.F, 23, 52, 57, true),
                    new Animal(
                        "Reiner", Animal.Type.CAT, Animal.Sex.F, 12, 41, 35, true),
                    new Animal(
                        "Hobbit", Animal.Type.DOG, Animal.Sex.M, 28, 47, 54, false),
                    new Animal(
                        "Sheriff", Animal.Type.DOG, Animal.Sex.M, 19, 30, 27, false),
                    new Animal(
                        "Hank", Animal.Type.BIRD, Animal.Sex.M, 13, 10, 90, false),
                    new Animal(
                        "Raygun", Animal.Type.BIRD, Animal.Sex.M, 12, 64, 4, false),
                    new Animal(
                        "Sherlock", Animal.Type.BIRD, Animal.Sex.M, 22, 26, 33, true),
                    new Animal(
                        "Percy", Animal.Type.BIRD, Animal.Sex.F, 20, 37, 17, false),
                    new Animal(
                        "Spike", Animal.Type.BIRD, Animal.Sex.F, 16, 16, 98, false),
                    new Animal(
                        "Stream", Animal.Type.BIRD, Animal.Sex.F, 26, 6, 2, true),
                    new Animal(
                        "Shakespeare", Animal.Type.FISH, Animal.Sex.M, 3, 36, 80, false),
                    new Animal(
                        "Wild", Animal.Type.FISH, Animal.Sex.M, 28, 54, 58, false),
                    new Animal(
                        "Carlin", Animal.Type.FISH, Animal.Sex.F, 24, 59, 10, true),
                    new Animal(
                        "Nolan", Animal.Type.FISH, Animal.Sex.F, 17, 8, 58, true),
                    new Animal(
                        "Chase", Animal.Type.SPIDER, Animal.Sex.M, 0, 5, 70, false),
                    new Animal(
                        "Swen", Animal.Type.SPIDER, Animal.Sex.F, 7, 65, 21, true),
                    new Animal(
                        "Wild", Animal.Type.SPIDER, Animal.Sex.F, 20, 34, 71, false)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Mars", Animal.Type.CAT, Animal.Sex.M, 13, 34, 30, false),
                    new Animal(
                        "Admiral", Animal.Type.CAT, Animal.Sex.F, 23, 2, 83, false),
                    new Animal(
                        "Jordan", Animal.Type.CAT, Animal.Sex.F, 24, 46, 76, false),
                    new Animal(
                        "Doyle", Animal.Type.DOG, Animal.Sex.F, 18, 20, 43, false),
                    new Animal(
                        "June", Animal.Type.BIRD, Animal.Sex.F, 27, 45, 69, false),
                    new Animal(
                        "Magic", Animal.Type.BIRD, Animal.Sex.F, 19, 8, 44, false),
                    new Animal(
                        "Joker", Animal.Type.FISH, Animal.Sex.M, 21, 24, 66, false),
                    new Animal(
                        "Nolan", Animal.Type.FISH, Animal.Sex.F, 2, 64, 85, true),
                    new Animal(
                        "Sheriff", Animal.Type.FISH, Animal.Sex.F, 16, 3, 86, false),
                    new Animal(
                        "Swen", Animal.Type.FISH, Animal.Sex.F, 4, 18, 16, true),
                    new Animal(
                        "Percy", Animal.Type.SPIDER, Animal.Sex.F, 16, 55, 75, false)
                )),
        };
    }

    static Arguments[] isSpidersBitesMoreOftenThenDogs() {
        return new Arguments[] {
            Arguments.of(false),
            Arguments.of(false),
            Arguments.of(false),
            Arguments.of(true),
            Arguments.of(false),
        };
    }

    static Arguments[] heaviestFishInListsOfAnimals() {
        return new Arguments[] {
            Arguments.of(
                (Animal) null
            ),
            Arguments.of(
                (Animal) null
            ),
            Arguments.of(
                new Animal(
                    "Sheriff", Animal.Type.FISH, Animal.Sex.F, 27, 35, 40, true)
            ),
            Arguments.of(
                new Animal(
                    "Shakespeare", Animal.Type.FISH, Animal.Sex.M, 3, 36, 80, false)
            ),
            Arguments.of(
                new Animal(
                    "Sheriff", Animal.Type.FISH, Animal.Sex.F, 16, 3, 86, false)
            ),
        };
    }

    static Arguments[] listsOfAnimalLists() {
        return new Arguments[] {
            Arguments.of(
                Arrays.asList(
                    Arrays.asList(

                    )
                )
            ),
            Arguments.of(
                Arrays.asList(
                    Arrays.asList(
                        new Animal(
                            "Osborne", Animal.Type.DOG, Animal.Sex.M, 26, 7, 17, true),
                        new Animal(
                            "Benedict", Animal.Type.CAT, Animal.Sex.F, 0, 69, 86, false),
                        new Animal(
                            "Nolan", Animal.Type.SPIDER, Animal.Sex.F, 15, 34, 48, false)
                    ),
                    Arrays.asList(
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
                    )
                )),
            Arguments.of(
                Arrays.asList(
                    Arrays.asList(
                        new Animal(
                            "Caesar", Animal.Type.DOG, Animal.Sex.F, 4, 13, 6, false),
                        new Animal(
                            "Sheriff", Animal.Type.FISH, Animal.Sex.F, 27, 35, 40, true),
                        new Animal(
                            "Cooper", Animal.Type.CAT, Animal.Sex.F, 2, 17, 44, true)
                    ),
                    Arrays.asList(
                        new Animal(
                            "Osborne", Animal.Type.SPIDER, Animal.Sex.F, 26, 34, 64, true)
                    ),
                    Arrays.asList(

                    ),
                    Arrays.asList(
                        new Animal(
                            "Wild", Animal.Type.DOG, Animal.Sex.F, 8, 61, 97, true),
                        new Animal(
                            "Jordan", Animal.Type.DOG, Animal.Sex.F, 26, 69, 56, true),
                        new Animal(
                            "Luke", Animal.Type.DOG, Animal.Sex.M, 18, 24, 3, true),
                        new Animal(
                            "Hobbit", Animal.Type.FISH, Animal.Sex.F, 8, 16, 18, true)
                    ),
                    Arrays.asList(
                        new Animal(
                            "Carlin", Animal.Type.SPIDER, Animal.Sex.M, 5, 7, 72, true),
                        new Animal(
                            "Hank", Animal.Type.CAT, Animal.Sex.F, 24, 16, 2, true)
                    )
                )),
            Arguments.of(
                Arrays.asList(
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
                            "Percy", Animal.Type.BIRD, Animal.Sex.F, 20, 37, 17, false)
                    ),
                    Arrays.asList(
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
                            "Chase", Animal.Type.SPIDER, Animal.Sex.M, 0, 5, 70, false)
                    ),
                    Arrays.asList(
                        new Animal(
                            "Stream", Animal.Type.BIRD, Animal.Sex.F, 26, 6, 2, true),
                        new Animal(
                            "Spike", Animal.Type.BIRD, Animal.Sex.F, 16, 16, 98, false),
                        new Animal(
                            "Hobbit", Animal.Type.DOG, Animal.Sex.M, 28, 47, 54, false)
                    ),
                    Arrays.asList(
                        new Animal(
                            "Swen", Animal.Type.SPIDER, Animal.Sex.F, 7, 65, 21, true),
                        new Animal(
                            "Shakespeare", Animal.Type.FISH, Animal.Sex.M, 3, 36, 80, false)
                    )
                )
            ),
            Arguments.of(
                Arrays.asList(
                    Arrays.asList(
                        new Animal(
                            "Swen", Animal.Type.FISH, Animal.Sex.F, 4, 18, 16, true),
                        new Animal(
                            "Mars", Animal.Type.CAT, Animal.Sex.M, 13, 34, 30, false),
                        new Animal(
                            "Magic", Animal.Type.BIRD, Animal.Sex.F, 19, 8, 44, false)
                    ),

                    Arrays.asList(
                        new Animal(
                            "Nolan", Animal.Type.FISH, Animal.Sex.F, 2, 64, 85, true),
                        new Animal(
                            "Doyle", Animal.Type.DOG, Animal.Sex.F, 18, 20, 43, false)
                    ),

                    Arrays.asList(
                        new Animal(
                            "Percy", Animal.Type.SPIDER, Animal.Sex.F, 16, 55, 75, false)
                    ),

                    Arrays.asList(
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
                    )
                )
            )
        };
    }

    static Arguments[] animalWithLongNamesLists() {
        return new Arguments[] {
            Arguments.of(
                Arrays.asList()
            ),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Osborne Austin Abdullah", Animal.Type.DOG, Animal.Sex.M, 26, 7, 17, true),
                    new Animal(
                        "Benedict Bawerman Abeyta", Animal.Type.CAT, Animal.Sex.F, 0, 69, 86, false),
                    new Animal(
                        "Nolan", Animal.Type.SPIDER, Animal.Sex.F, 15, 34, 48, false),
                    new Animal(
                        "Carlin Brown", Animal.Type.BIRD, Animal.Sex.F, 19, 20, 48, true),
                    new Animal(
                        "Jay Carter Ahearn", Animal.Type.CAT, Animal.Sex.F, 24, 47, 83, true),
                    new Animal(
                        "Admiral", Animal.Type.BIRD, Animal.Sex.F, 5, 4, 35, false),
                    new Animal(
                        "Fall", Animal.Type.DOG, Animal.Sex.M, 6, 49, 27, false),
                    new Animal(
                        "Stream Charlson Alicea", Animal.Type.CAT, Animal.Sex.M, 25, 19, 73, true)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Caesar Daniels", Animal.Type.DOG, Animal.Sex.F, 4, 13, 6, false),
                    new Animal(
                        "Sheriff Dodson Alldredge", Animal.Type.FISH, Animal.Sex.F, 27, 35, 40, true),
                    new Animal(
                        "Cooper", Animal.Type.CAT, Animal.Sex.F, 2, 17, 44, true),
                    new Animal(
                        "Osborne Dowman", Animal.Type.SPIDER, Animal.Sex.F, 26, 34, 64, true),
                    new Animal(
                        "Wild", Animal.Type.DOG, Animal.Sex.F, 8, 61, 97, true),
                    new Animal(
                        "Jordan Eddington Arana", Animal.Type.DOG, Animal.Sex.F, 26, 69, 56, true),
                    new Animal(
                        "Luke Fane", Animal.Type.DOG, Animal.Sex.M, 18, 24, 3, true),
                    new Animal(
                        "Hobbit Flannagan Aron", Animal.Type.FISH, Animal.Sex.F, 8, 16, 18, true),
                    new Animal(
                        "Carlin Gardner Arredondo Appleton", Animal.Type.SPIDER, Animal.Sex.M, 5, 7, 72, true),
                    new Animal(
                        "Hank", Animal.Type.CAT, Animal.Sex.F, 24, 16, 2, true)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Nolan Hamphrey Ardis", Animal.Type.FISH, Animal.Sex.F, 17, 8, 58, true),
                    new Animal(
                        "Carlin", Animal.Type.FISH, Animal.Sex.F, 24, 59, 10, true),
                    new Animal(
                        "Raygun Hamphrey Ancheta", Animal.Type.BIRD, Animal.Sex.M, 12, 64, 4, false),
                    new Animal(
                        "Wild Hardman", Animal.Type.FISH, Animal.Sex.M, 28, 54, 58, false),
                    new Animal(
                        "Percy Gerald", Animal.Type.BIRD, Animal.Sex.F, 20, 37, 17, false),
                    new Animal(
                        "Reiner", Animal.Type.CAT, Animal.Sex.F, 12, 41, 35, true),
                    new Animal(
                        "Crystall Fulton", Animal.Type.CAT, Animal.Sex.F, 23, 52, 57, true),
                    new Animal(
                        "Sherlock Flannagan Ammons", Animal.Type.BIRD, Animal.Sex.M, 22, 26, 33, true),
                    new Animal(
                        "Hank", Animal.Type.BIRD, Animal.Sex.M, 13, 10, 90, false),
                    new Animal(
                        "Wild Farmer", Animal.Type.SPIDER, Animal.Sex.F, 20, 34, 71, false),
                    new Animal(
                        "Sheriff", Animal.Type.DOG, Animal.Sex.M, 19, 30, 27, false),
                    new Animal(
                        "Chase Elmers", Animal.Type.SPIDER, Animal.Sex.M, 0, 5, 70, false),
                    new Animal(
                        "Stream", Animal.Type.BIRD, Animal.Sex.F, 26, 6, 2, true),
                    new Animal(
                        "Spike", Animal.Type.BIRD, Animal.Sex.F, 16, 16, 98, false),
                    new Animal(
                        "Hobbit", Animal.Type.DOG, Animal.Sex.M, 28, 47, 54, false),
                    new Animal(
                        "Swen Donaldson Ashburn", Animal.Type.SPIDER, Animal.Sex.F, 7, 65, 21, true),
                    new Animal(
                        "Shakespeare Derrick", Animal.Type.FISH, Animal.Sex.M, 3, 36, 80, false)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Swen", Animal.Type.FISH, Animal.Sex.F, 4, 18, 16, true),
                    new Animal(
                        "Mars Croftoon Artz", Animal.Type.CAT, Animal.Sex.M, 13, 34, 30, false),
                    new Animal(
                        "Magic Cook", Animal.Type.BIRD, Animal.Sex.F, 19, 8, 44, false),
                    new Animal(
                        "Nolan", Animal.Type.FISH, Animal.Sex.F, 2, 64, 85, true),
                    new Animal(
                        "Doyle Clapton Ammerman", Animal.Type.DOG, Animal.Sex.F, 18, 20, 43, false),
                    new Animal(
                        "Percy", Animal.Type.SPIDER, Animal.Sex.F, 16, 55, 75, false),
                    new Animal(
                        "Joker Carroll", Animal.Type.FISH, Animal.Sex.M, 21, 24, 66, false),
                    new Animal(
                        "Sheriff Bush Arellano", Animal.Type.FISH, Animal.Sex.F, 16, 3, 86, false),
                    new Animal(
                        "Admiral", Animal.Type.CAT, Animal.Sex.F, 23, 2, 83, false),
                    new Animal(
                        "Jordan Bootman Asher", Animal.Type.CAT, Animal.Sex.F, 24, 46, 76, false),
                    new Animal(
                        "June", Animal.Type.BIRD, Animal.Sex.F, 27, 45, 69, false)
                )),
        };

    }

    static Arguments[] animalListsWithNamesLongerThanTwoWords() {
        return new Arguments[] {
            Arguments.of(
                Arrays.asList()
            ),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Osborne Austin Abdullah", Animal.Type.DOG, Animal.Sex.M, 26, 7, 17, true),
                    new Animal(
                        "Benedict Bawerman Abeyta", Animal.Type.CAT, Animal.Sex.F, 0, 69, 86, false),
                    new Animal(
                        "Jay Carter Ahearn", Animal.Type.CAT, Animal.Sex.F, 24, 47, 83, true),
                    new Animal(
                        "Stream Charlson Alicea", Animal.Type.CAT, Animal.Sex.M, 25, 19, 73, true)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Sheriff Dodson Alldredge", Animal.Type.FISH, Animal.Sex.F, 27, 35, 40, true),
                    new Animal(
                        "Jordan Eddington Arana", Animal.Type.DOG, Animal.Sex.F, 26, 69, 56, true),
                    new Animal(
                        "Hobbit Flannagan Aron", Animal.Type.FISH, Animal.Sex.F, 8, 16, 18, true),
                    new Animal(
                        "Carlin Gardner Arredondo Appleton", Animal.Type.SPIDER, Animal.Sex.M, 5, 7, 72, true)
                )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Nolan Hamphrey Ardis", Animal.Type.FISH, Animal.Sex.F, 17, 8, 58, true),
                    new Animal(
                        "Raygun Hamphrey Ancheta", Animal.Type.BIRD, Animal.Sex.M, 12, 64, 4, false),
                    new Animal(
                        "Sherlock Flannagan Ammons", Animal.Type.BIRD, Animal.Sex.M, 22, 26, 33, true),
                    new Animal(
                        "Swen Donaldson Ashburn", Animal.Type.SPIDER, Animal.Sex.F, 7, 65, 21, true)
                    )),
            Arguments.of(
                Arrays.asList(
                    new Animal(
                        "Mars Croftoon Artz", Animal.Type.CAT, Animal.Sex.M, 13, 34, 30, false),
                    new Animal(
                        "Doyle Clapton Ammerman", Animal.Type.DOG, Animal.Sex.F, 18, 20, 43, false),
                    new Animal(
                        "Sheriff Bush Arellano", Animal.Type.FISH, Animal.Sex.F, 16, 3, 86, false),
                    new Animal(
                        "Jordan Bootman Asher", Animal.Type.CAT, Animal.Sex.F, 24, 46, 76, false)
                )),
        };

    }
}
