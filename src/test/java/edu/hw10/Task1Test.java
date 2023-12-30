package edu.hw10;

import edu.hw10.task1.HelpClasses.Animal;
import edu.hw10.task1.HelpClasses.Car;
import edu.hw10.task1.HelpClasses.ManyNumberTypes;
import edu.hw10.task1.HelpClasses.Rectangle;
import edu.hw10.task1.HelpClasses.SomeClass;
import edu.hw10.task1.HelpClasses.Square;
import edu.hw10.task1.RandomObjectGenerator;
import org.junit.jupiter.api.Test;
import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    @Test
    void givenClassCarWhenCreatingObjectThenReturningObject() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        Car car = randomObjectGenerator.nextObject(Car.class);

        assertNotNull(car);
    }

    @Test
    void givenClassAnimalWhenCreatingObjectWithAnnotationNotNullThenReturningObject() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        Animal animal = randomObjectGenerator.nextObject(Animal.class);

        assertTrue(animal.name != null && animal.secondName != null);
    }

    @Test
    void givenClassSquareWhenCreatingObjectWithAnnotationMaxThenReturningObject() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        Square square = randomObjectGenerator.nextObject(Square.class);

        assertTrue(square.sideLength == 1 << 31 - 1);
    }

    @Test
    void givenClassRectangleWhenCreatingObjectWithAnnotationMinThenReturningObject() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        Rectangle rectangle = randomObjectGenerator.nextObject(Rectangle.class);

        assertTrue(rectangle.firstSideLength == 0 && rectangle.secondSideLength == 0);
    }

    @Test
    void givenClassSomeClassWhenCreatingObjectWithAnnotationMaxThenReturningObject() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        SomeClass someClass =
            randomObjectGenerator.nextObject(SomeClass.class, "create");

        assertTrue(someClass.someString.equals("MaxString") && someClass.someInt == 1 << 31 - 1);
    }

    @Test
    void givenClassManyNumberTypesWhenCreatingObjectWithAnnotationMaxThenReturningObject() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        ManyNumberTypes manyNumberTypes =
            randomObjectGenerator.nextObject(ManyNumberTypes.class);

        assertTrue(manyNumberTypes.aBoolean.equals(true)
            && manyNumberTypes.anInt.equals(1 << 31 - 1)
            && manyNumberTypes.aShort.equals((short)(1 << 15 - 1))
            && manyNumberTypes.aLong.equals(1L << 63 - 1L)
            && abs(manyNumberTypes.aFloat - 999999.0) < 0.001
        );
    }
}
