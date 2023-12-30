package edu.hw10.task2;

public interface StringConcatenation {
    @Cache
    String concatenate(String firstString, String secondString);
}
