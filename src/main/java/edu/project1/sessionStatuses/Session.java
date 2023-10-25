package edu.project1.sessionStatuses;

public interface Session {
    ActingStatus changeStatus(String move);

    String getLastMessage();

    boolean isLettersGuessed();
}
