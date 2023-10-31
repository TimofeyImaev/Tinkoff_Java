package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
}
