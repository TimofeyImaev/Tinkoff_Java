package edu.hw10;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.jetbrains.annotations.NotNull;

public class Task1HelpClasses {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Min {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Max {
    }

    public static class Car {
        Integer speed;

        public Car(Integer speed) {
            this.speed = speed;
        }
    }

    @NotNull
    public static class Animal {
        String name;
        String secondName;

        public Animal(String name, String secondName) {
            this.name = name;
            this.secondName = secondName;
        }
    }

    @Max
    public static class Square {
        Integer sideLength;

        public Square(Integer sideLength) {
            this.sideLength = sideLength;
        }
    }

    @Min
    public static class Rectangle {
        Integer firstSideLength;
        Integer secondSideLength;

        public Rectangle(Integer firstSideLength, Integer secondSideLength) {
            this.firstSideLength = firstSideLength;
            this.secondSideLength = secondSideLength;
        }
    }

    @Max
    public static class SomeClass {
        String someString;
        Integer someInt;

        static SomeClass create(String someString, Integer someInt) {
            SomeClass someClass = new SomeClass();

            someClass.someString = someString;
            someClass.someInt = someInt;
            return someClass;
        }
    }
}
