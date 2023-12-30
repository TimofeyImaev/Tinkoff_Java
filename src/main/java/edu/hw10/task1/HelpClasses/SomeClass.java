package edu.hw10.task1.HelpClasses;

@Max
public class SomeClass {
    public String someString;
    public Integer someInt;

    static SomeClass create(String someString, Integer someInt) {
        SomeClass someClass = new SomeClass();

        someClass.someString = someString;
        someClass.someInt = someInt;
        return someClass;
    }
}
