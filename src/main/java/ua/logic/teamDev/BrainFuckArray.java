package ua.logic.teamDev;

import java.util.ArrayList;
import java.util.List;

public class BrainFuckArray {
    private List<Integer> integers = new ArrayList<>();
    private int index;

    public String outputElement() {
        char c = (char) integers.get(index).intValue();
        return "" + c;
    }

    public Integer getElement() {
        if (integers.size() == index) {
            integers.add(0);
        }

        return integers.get(index);
    }

    public void elementIncrement() {
        Integer i = getElement();
        integers.set(index, ++i);
    }

    public void elementDecrement() {
        Integer i = getElement();
        integers.set(index, --i);
    }

    public void incrementIndex() {
        index++;
    }

    public void decrementIndex() {
        index--;
    }
}
