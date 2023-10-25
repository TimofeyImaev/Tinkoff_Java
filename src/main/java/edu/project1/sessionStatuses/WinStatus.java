package edu.project1.sessionStatuses;

public class WinStatus implements Session {
    private String lastMessage = "You won!\n";

    public WinStatus() {

    }

    public WinStatus(String newLastMessage) {
        this.lastMessage = newLastMessage;
    }

    @Override
    public ActingStatus changeStatus(String move) {
        return new ActingStatus();
    }

    @Override
    public String getLastMessage() {
        return lastMessage;
    }

    @Override
    public boolean isLettersGuessed() {
        return true;
    }
}
