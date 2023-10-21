package edu.project1.sessionStatuses;

public class LoseStatus implements Session {
    private String lastMessage = "You lost! (Write anything to continue)\n";

    public LoseStatus() {

    }

    public LoseStatus(String newLastMessage) {
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
        return false;
    }
}
