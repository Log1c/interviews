package ua.logic.teamDev;

public class BrainFuckString {
    private final String brainFuckString;
    private int index = 0;

    public BrainFuckString(String brainFuckString) {
        this.brainFuckString = brainFuckString;
    }

    public int getLength() {
        return brainFuckString.length();
    }

    public String getCharacter() {
        return brainFuckString.substring(index, index+1);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void incrementIndex() {
        index++;
    }
}
