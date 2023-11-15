package edu.hw4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.util.Map.entry;

@SuppressWarnings("CyclomaticComplexity") public class AnimalTools {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int HEIGHT_HUNDRED = 100;
    private static final int MINIMAL_ANIMAL_HEIGHT = 5;
    private static final int MAXIMUM_BIRD_AGE = 71;
    private static final int MAXIMUM_CAT_AGE = 38;
    private static final int MAXIMUM_DOG_AGE = 31;
    private static final int MAXIMUM_SPIDER_AGE = 43;
    private static final int MAXIMUM_FISH_AGE = 112;
    private static final String INCORRECT_AGE = "Incorrect age of animal";

    private AnimalTools() {

    }

    //Task1
    public static List<Animal> heightSort(List<Animal> animalList) {
        LOGGER.trace("Sorting List {}", animalList);

        return animalList.stream().sorted(Comparator.comparingInt(Animal::height)).collect(Collectors.toList());
    }

    //Task2
    public static List<Animal> weightSort(List<Animal> animalList, Integer k) {
        return animalList.stream().sorted(Comparator.comparingInt(Animal::weight)).limit(k)
            .collect(Collectors.toList());
    }

    //Task3
    public static Map<Animal.Type, Long> amountOfAnimalsInSpecies(List<Animal> animalList) {
        return animalList.stream().collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    //Task4
    public static Animal animalWithLongestName(List<Animal> animalLst) {
        if (animalLst.isEmpty()) {
            return null;
        }

        return animalLst.stream().max(Comparator.comparingInt(animal -> animal.name().length())).get();
    }

    //Task5
    public static Animal.Sex mostCommonSex(List<Animal> animalLst) {
        long malesCount = animalLst.stream().filter(animal -> animal.sex() == Animal.Sex.M).count();
        long femalesCount = animalLst.stream().filter(animal -> animal.sex() == Animal.Sex.F).count();

        Animal.Sex answer;

        if (malesCount > femalesCount) {
            answer = Animal.Sex.M;
        } else if (malesCount < femalesCount) {
            answer = Animal.Sex.F;
        } else {
            answer = null;
        }

        return answer;
    }

    //Task6
    public static Map<Animal.Type, Animal> heaviestAnimalOfEveryType(List<Animal> animalList) {
        LOGGER.trace("List of animals {}", animalList);
        return animalList.stream().collect(Collectors.groupingBy(Animal::type,
            Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Animal::weight)), Optional::get)
        ));
    }

    //Task7
    public static Animal kthOldestAnimal(List<Animal> animalList, Integer k) {
        Optional<Animal> animal =
            animalList.stream().sorted(Comparator.comparingInt(Animal::age).reversed()).skip(k - 1).findFirst();

        if (animal.isEmpty()) {
            return null;
        }

        return animal.get();
    }

    //Task8
    public static Optional<Animal> heaviestAnimalLowerK(List<Animal> animalList, Integer k) {
        return animalList.stream().filter(animal -> animal.height() < k).max(Comparator.comparing(Animal::weight));
    }

    //Task9
    public static Integer countOfPaws(List<Animal> animalList) {
        return animalList.stream().mapToInt(Animal::paws).sum();
    }

    //Task10
    public static List<Animal> animalsWhichAgeNotEqualsCountOfPaws(List<Animal> animalList) {
        return animalList.stream().filter(animal -> animal.age() != animal.paws()).collect(Collectors.toList());
    }

    //Task11
    public static List<Animal> listOfAnimalsWhichBitesAndHeightMoreTen(List<Animal> animalList) {
        return animalList.stream().filter(animal -> animal.bites() && animal.height() >= HEIGHT_HUNDRED)
            .collect(Collectors.toList());
    }

    //Task12
    public static Integer amountOfAnimalsWhichWeightMoreHeight(List<Animal> animalList) {
        return Math.toIntExact(animalList.stream().filter(animal -> animal.weight() > animal.height()).count());
    }

    //Task13
    public static List<Animal> animalListsWithNamesLongerThanTwoWords(List<Animal> animalList) {
        return animalList.stream().filter(animal ->
                Arrays.stream(animal.name().split(" ", 0)).filter(string -> !string.isEmpty()).toList().size() > 2)
            .collect(Collectors.toList());
    }

    //Task14
    public static Boolean isAnimalsListHadDogWithHeightMoreOrEqualsK(List<Animal> animalList, Integer k) {
        return animalList.stream().anyMatch(animal -> animal.height() >= k && animal.type().equals(Animal.Type.DOG));
    }

    //Task15
    public static Map<Animal.Type, Integer> findTotalWeightOfEveryTypeFromKToLAge(
        List<Animal> animalList, Integer k, Integer l
    ) {
        return animalList.stream().filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    //Task16
    public static List<Animal> animalsListSortedByTypeSexName(List<Animal> animalList) {
        return animalList.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    //Task17
    public static Boolean isSpidersBitesMoreOftenThenDogs(List<Animal> animalList) {
        return animalList.stream().mapToInt(animal -> {
            int countOfBitesSpiderSubDogs = 0;

            if (animal.type().equals(Animal.Type.DOG) && animal.bites()) {
                countOfBitesSpiderSubDogs--;
            } else if (animal.type().equals(Animal.Type.SPIDER) && animal.bites()) {
                countOfBitesSpiderSubDogs++;
            }

            return countOfBitesSpiderSubDogs;
        }).sum() > 0;
    }

    //Task18
    public static Animal heaviestFishInListsOfAnimals(List<List<Animal>> animalLists) {
        Optional<Animal> heaviestFish =
            animalLists.stream().flatMap(Collection::stream).filter(animal -> animal.type().equals(Animal.Type.FISH))
                .max(Comparator.comparing(Animal::weight));

        return heaviestFish.orElse(null);

    }

    public static Set<ValidationError> nameErrors(String animalName) {
        Set<ValidationError> errors = new HashSet<ValidationError>();

        for (var each : animalName.toCharArray()) {
            if (!(each >= 'a' || each <= 'z') && each != ' ' && !(each >= 'A' || each <= 'Z')) {
                errors.add(new ValidationError("Animal name should contains only latin letters and spaces"));
                break;
            }
        }

        return errors;
    }

    public static Set<ValidationError> ageErrors(Animal.Type type, int age) {
        Set<ValidationError> errors = new HashSet<ValidationError>();

        if (type == Animal.Type.BIRD && age > MAXIMUM_BIRD_AGE) {
            errors.add(new ValidationError(INCORRECT_AGE));
        }
        if (type == Animal.Type.CAT && age > MAXIMUM_CAT_AGE) {
            errors.add(new ValidationError(INCORRECT_AGE));
        }
        if (type == Animal.Type.DOG && age > MAXIMUM_DOG_AGE) {
            errors.add(new ValidationError(INCORRECT_AGE));
        }
        if (type == Animal.Type.SPIDER && age > MAXIMUM_SPIDER_AGE) {
            errors.add(new ValidationError(INCORRECT_AGE));
        }
        if (type == Animal.Type.FISH && age > MAXIMUM_FISH_AGE) {
            errors.add(new ValidationError(INCORRECT_AGE));
        }
        if (age < 0) {
            errors.add(new ValidationError(INCORRECT_AGE));
        }

        return errors;
    }

    public static Set<ValidationError> heightError(int height) {
        Set<ValidationError> errors = new HashSet<ValidationError>();

        if (height < MINIMAL_ANIMAL_HEIGHT) {
            errors.add(new ValidationError("Incorrect height of animal"));
        }

        return errors;
    }

    public static Set<ValidationError> weightError(int weight) {
        Set<ValidationError> errors = new HashSet<ValidationError>();

        if (weight < 1) {
            errors.add(new ValidationError("Incorrect weight of animal"));
        }

        return errors;
    }

    //Task19
    public static Map<String, Set<ValidationError>> animalsWithValidationError(List<Animal> animalList) {
        return animalList.stream().map(animal -> {

                Set<ValidationError> errors = new HashSet<ValidationError>();

                errors.addAll(nameErrors(animal.name()));
                errors.addAll(ageErrors(animal.type(), animal.age()));
                errors.addAll(heightError(animal.height()));
                errors.addAll(weightError(animal.weight()));

                return entry(animal.name(), errors);
            }).filter(entry -> !entry.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    //Task20
    public static Map<String, String> readableListOfAnimalsWithValidationError(List<Animal> animalList) {
        return animalsWithValidationError(animalList).entrySet().stream().map(error -> {
            String stringWithError = "";

            for (var each : error.getValue()) {
                stringWithError += each.getMessage() + "\n";
            }

            return entry(error.getKey(), stringWithError);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
