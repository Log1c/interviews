package ua.logic.teamDev;

import ua.logic.teamDev.states.*;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Context {
    private int indexWhile;
    private int indexArray;
    private List<Integer> integers = new ArrayList<>();
    private String brainFuckString;
    private int brainFuckIndex;
    private String result = "";

    public Context(String s) {
        brainFuckString = s;
    }

    State getState(String s) {
        switch (s) {
            case State.ceilDecrement:
                return new CeilDecrement();
            case State.ceilIncrement:
                return new CeilIncrement();
            case State.dataDecrement:
                return new DataDecrement();
            case State.dataIncrement:
                return new DataIncrement();
            case State.input:
                return new Input();
            case State.output:
                return new Output();
            case State.jumpBack:
                return new JumpBack();
            case State.jumpForward:
                return new JumpForward();
            default:
                throw new IllegalArgumentException();
        }
    }

    void evaluate() {
        for (; brainFuckIndex < brainFuckString.length(); brainFuckIndex++) {
            String current = brainFuckString.substring(brainFuckIndex, brainFuckIndex + 1);
            State state = getState(current);
            state.action(this);
        }
    }

    public void decrementIndex() {
        indexArray--;
    }

    public void incrementIndex() {
        indexArray++;
    }

    public void dataIncrement() {
        Integer i = getElement();
        integers.set(indexArray, ++i);
    }

    public void dataDecrement() {
        Integer i = getElement();
        integers.set(indexArray, --i);
    }

    public Integer getElement() {
        if (integers.size() == indexArray) {
            integers.add(0);
        }

        return integers.get(indexArray);
    }

    public void input() {
        try {
            throw new OperationNotSupportedException();
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void output() {
        char c = (char) integers.get(indexArray).intValue();
        result+=c;
//        System.out.print(c);
    }

    public void jumpForward() {
        indexWhile = brainFuckIndex;
    }

    public void jumpBack() {
        Integer i = getElement();
        if (i != 0) {
            brainFuckIndex = indexWhile;
        }
    }
    public String getResult() {
        return result;
    }
}