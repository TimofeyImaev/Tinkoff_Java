package edu.hw10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    @Test
    void givenClassCarWhenCreatingObjectThenReturningObject() {
        Task1.RandomObjectGenerator randomObjectGenerator = new Task1.RandomObjectGenerator();
        Task1HelpClasses.Car car = randomObjectGenerator.nextObject(Task1HelpClasses.Car.class);

        assertTrue(true);
    }

    @Test
    void givenClassAnimalWhenCreatingObjectWithAnnotationNotNullThenReturningObject() {
        Task1.RandomObjectGenerator randomObjectGenerator = new Task1.RandomObjectGenerator();
        Task1HelpClasses.Animal animal = randomObjectGenerator.nextObject(Task1HelpClasses.Animal.class);

        assertTrue(animal.name != null && animal.secondName != null);
    }

    @Test
    void givenClassSquareWhenCreatingObjectWithAnnotationMaxThenReturningObject() {
        Task1.RandomObjectGenerator randomObjectGenerator = new Task1.RandomObjectGenerator();
        Task1HelpClasses.Square square = randomObjectGenerator.nextObject(Task1HelpClasses.Square.class);

        assertTrue(square.sideLength == 1 << 31 - 1);
    }

    @Test
    void givenClassRectangleWhenCreatingObjectWithAnnotationMinThenReturningObject() {
        Task1.RandomObjectGenerator randomObjectGenerator = new Task1.RandomObjectGenerator();
        Task1HelpClasses.Rectangle rectangle = randomObjectGenerator.nextObject(Task1HelpClasses.Rectangle.class);

        assertTrue(rectangle.firstSideLength == 0 && rectangle.secondSideLength == 0);
    }

    @Test
    void givenClassSomeClassWhenCreatingObjectWithAnnotationMaxThenReturningObject() {
        Task1.RandomObjectGenerator randomObjectGenerator = new Task1.RandomObjectGenerator();
        Task1HelpClasses.SomeClass someClass =
            randomObjectGenerator.nextObject(Task1HelpClasses.SomeClass.class, "create");

        assertTrue(someClass.someString.equals("MaxString") && someClass.someInt == 1 << 31 - 1);
    }
}
