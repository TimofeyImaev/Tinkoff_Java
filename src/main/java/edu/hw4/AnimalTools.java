package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.util.Map.entry;

@SuppressWarnings("CyclomaticComplexity")
public class AnimalTools {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int TEN = 10;
    private static final int FIVE = 5;
    private static final int SEVENTY_ONE = 71;
    private static final int THIRTHY_EIGHT = 38;
    private static final int THIRTHY_ONE = 31;
    private static final int FORTY_THREE = 43;
    private static final int ONE_HUNDRED_TWELVE = 112;
    private static final String INCORRECT_AGE = "Incorrect age of animal";

    private AnimalTools() {

    }

    //Task1
    public static List<Animal> heightSort(List<Animal> animalList) {
        LOGGER.trace("Sorting List {}", animalList);

        return animalList.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    //Task2
    public static List<Animal> weightSort(List<Animal> animalList, Integer k) {
        return animalList.stream()
            .sorted(Comparator.comparingInt(Animal::weight))
            .limit(k)
            .collect(Collectors.toList());
    }

    //Task3
    public static Map<Animal.Type, Long> amountOfAnimalsInSpecies(List<Animal> animalList) {
        return animalList.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    //Task4
    public static Animal animalWithLongestName(List<Animal> animalLst) {
        if (animalLst.isEmpty()) {
            return null;
        }

        return animalLst.stream()
            .reduce((first, second) -> {
                if (first.name().length() < second.name().length()) {
                    return second;
                }
                return first;
            })
            .get();
    }

    //Task5
    public static Animal.Sex mostCommonSex(List<Animal> animalLst) {
        long malesCount = animalLst.stream()
            .filter(animal -> animal.sex() == Animal.Sex.M).count();
        long femalesCount = animalLst.stream()
            .filter(animal -> animal.sex() == Animal.Sex.F).count();

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
        return animalList.stream()
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparing(Animal::weight)),
                    Optional::get
                )
            ));
    }

    //Task7
    public static Animal kthOldestAnimal(List<Animal> animalList, Integer k) {
        Optional<Animal> animal = animalList.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst();

        if (animal.isEmpty()) {
            return null;
        }

        return animal.get();
    }

    //Task8
    public static Optional<Animal> heaviestAnimalLowerK(List<Animal> animalList, Integer k) {
        return animalList.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparing(Animal::weight));
    }

    //Task9
    public static Integer countOfPaws(List<Animal> animalList) {
        return animalList.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    //Task10
    public static List<Animal> animalsWhichAgeNotEqualsCountOfPaws(List<Animal> animalList) {
        return animalList.stream()
            .filter(animal -> animal.age() == animal.paws())
            .collect(Collectors.toList());
    }

    //Task11
    public static List<Animal> listOfAnimalsWhichBitesAndHeightMoreTen(List<Animal> animalList) {
        return animalList.stream()
            .filter(animal -> animal.bites() && animal.height() >= TEN)
            .collect(Collectors.toList());
    }

    //Task12
    public static Integer amountOfAnimalsWhichWeightMoreHeight(List<Animal> animalList) {
        return Integer.valueOf((int) animalList.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count());
    }

    //Task13
    public static List<Animal> animalListsWithNamesLongerThanTwoWords(List<Animal> animalList) {
        return animalList.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .collect(Collectors.toList());
    }

    //Task14
    public static Boolean isAnimalsListHadDogWithHeightMoreOrEqualsK(List<Animal> animalList, Integer k) {
        return animalList.stream()
            .anyMatch(animal -> animal.height() >= k);
    }

    //Task15
    public static Map<Animal.Type, Integer> findTotalWeightOfEveryTypeFromKToLAge(
        List<Animal> animalList,
        Integer k,
        Integer l
    ) {
        return animalList.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.summingInt(Animal::weight)
            ));
    }

    //Task16
    public static List<Animal> animalsListSortedByTypeSexName(List<Animal> animalList) {
        return animalList.stream()
            .sorted((firstAnimal, secondAnimal) -> {
                if (firstAnimal.type() == secondAnimal.type()) {
                    if (firstAnimal.sex() == secondAnimal.sex()) {
                        return firstAnimal.name().compareTo(secondAnimal.name());
                    }

                    return firstAnimal.sex().compareTo(secondAnimal.sex());
                }
                return firstAnimal.type().compareTo(secondAnimal.type());
            })
            .collect(Collectors.toList());
    }

    //Task17
    public static Boolean isSpidersBitesMoreOftenThenDogs(List<Animal> animalList) {
        return animalList.stream()
            .mapToInt(animal -> {
                int countOfBitesSpiderSubDogs = 0;

                if (animal.type().equals(Animal.Type.DOG) && animal.bites()) {
                    countOfBitesSpiderSubDogs--;
                } else if (animal.type().equals(Animal.Type.SPIDER) && animal.bites()) {
                    countOfBitesSpiderSubDogs++;
                }

                return countOfBitesSpiderSubDogs;
            })
            .sum() > 0;
    }

    //Task18
    public static Animal heaviestFishInListsOfAnimals(List<List<Animal>> animalLists) {
        Optional<Animal> heaviestFish = animalLists.stream()
            .map(Collection::stream)
            .reduce(Stream::concat)
            .get()
            .filter(animal -> animal.type().equals(Animal.Type.FISH))
            .max(Comparator.comparing(Animal::weight));

        if (heaviestFish.isEmpty()) {
            return null;
        }

        return heaviestFish.get();
    }

    //Task19
    public static Map<String, Set<ValidationError>> animalsWithValidationError(List<Animal> animalList) {
        return animalList.stream()
            .map(animal -> {
                Set<ValidationError> errors = new TreeSet<ValidationError>();

                for (var each : animal.name().toCharArray()) {
                    if (!(each >= 'a' || each <= 'z') && each != ' '
                        && !(each >= 'A' || each <= 'Z')) {
                        errors.add(new ValidationError("Animal name should contains only latin letters and spaces"));
                        break;
                    }
                }

                if (animal.type() == Animal.Type.BIRD && animal.age() > SEVENTY_ONE) {
                    errors.add(new ValidationError(INCORRECT_AGE));
                }
                if (animal.type() == Animal.Type.CAT && animal.age() > THIRTHY_EIGHT) {
                    errors.add(new ValidationError(INCORRECT_AGE));
                }
                if (animal.type() == Animal.Type.DOG && animal.age() > THIRTHY_ONE) {
                    errors.add(new ValidationError(INCORRECT_AGE));
                }
                if (animal.type() == Animal.Type.SPIDER && animal.age() > FORTY_THREE) {
                    errors.add(new ValidationError(INCORRECT_AGE));
                }
                if (animal.type() == Animal.Type.FISH && animal.age() > ONE_HUNDRED_TWELVE) {
                    errors.add(new ValidationError(INCORRECT_AGE));
                }
                if (animal.age() < 0) {
                    errors.add(new ValidationError(INCORRECT_AGE));
                }

                if (animal.height() < FIVE) {
                    errors.add(new ValidationError("Incorrect height of animal"));
                }
                if (animal.weight() < 1) {
                    errors.add(new ValidationError("Incorrect weight of animal"));
                }

                return entry(animal.name(), errors);
            })
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
