package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnimalTools {
    private static final Logger LOGGER = LogManager.getLogger();

    private AnimalTools() {

    }

    public static List<Animal> heightSort(List<Animal> animalList) {
        LOGGER.trace("Sorting List {}", animalList);

        return animalList.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    public static List<Animal> weightSort(List<Animal> animalList, Integer k) {
        return animalList.stream()
            .sorted(Comparator.comparingInt(Animal::weight))
            .limit(k)
            .collect(Collectors.toList());
    }

    public static Map<Animal.Type, Long> amountOfAnimalsInSpecies(List<Animal> animalList) {
        return animalList.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

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

    public static Optional<Animal> heaviestAnimalLowerK(List<Animal> animalList, Integer k) {
        return animalList.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparing(Animal::weight));
    }

    public static Integer countOfPaws(List<Animal> animalList) {
        return animalList.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static List<Animal> animalsWhichAgeNotEqualsCountOfPaws(List<Animal> animalList) {
        return animalList.stream()
            .filter(animal -> animal.age() == animal.paws())
            .collect(Collectors.toList());
    }

    public static List<Animal> listOfAnimalsWhichBitesAndHeightMoreTen(List<Animal> animalList) {
        return animalList.stream()
            .filter(animal -> animal.bites() && animal.height() >= 10)
            .collect(Collectors.toList());
    }

    public static Integer amountOfAnimalsWhichWeightMoreHeight(List<Animal> animalList) {
        return Integer.valueOf((int) animalList.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count());
    }

    public static Boolean isAnimalsListHadDogWithHeightMoreOrEqualsK(List<Animal> animalList, Integer k) {
        return animalList.stream()
            .anyMatch(animal -> animal.height() >= k);
    }

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
}
