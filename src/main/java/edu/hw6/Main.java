package edu.hw6;

public class Main {
    public static void main(String[] args) {

        System.out.println(
            "C:\\Users\\ullle\\IdeaProjects\\java-course-2023\\src\\main\\java\\edu\\hw6\\dictionary"
                .equals(
                    Paths.getPathToRepository() + "\\src\\main\\java\\edu\\hw6\\dictionary"
                ));
    }
}
