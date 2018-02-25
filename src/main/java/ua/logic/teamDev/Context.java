package ua.logic.teamDev;

import ua.logic.teamDev.states.*;

import javax.naming.OperationNotSupportedException;

public class Context {
    private int indexWhile;
    private BrainFuckArray brainFuckArray;
    private BrainFuckString brainFuckString;
    private String result = "";

    public Context(String s) {
        brainFuckString = new BrainFuckString(s);
        brainFuckArray = new BrainFuckArray();
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
        for (; brainFuckString.getIndex() < brainFuckString.getLength(); brainFuckString.incrementIndex()) {
            String current = brainFuckString.getCharacter();
            State state = getState(current);
            state.action(this);
        }
    }

    public void decrementIndex() {
        brainFuckArray.decrementIndex();
    }

    public void incrementIndex() {
        brainFuckArray.incrementIndex();
    }

    public void dataIncrement() {
        brainFuckArray.elementIncrement();
    }

    public void dataDecrement() {
        brainFuckArray.elementDecrement();
    }

    public void input() {
        try {
            throw new OperationNotSupportedException();
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void output() {
        result += brainFuckArray.outputElement();
    }

    public void jumpForward() {
        indexWhile = brainFuckString.getIndex();
    }

    public void jumpBack() {
        Integer i = brainFuckArray.getElement();
        if (i != 0) {
            brainFuckString.setIndex(indexWhile);
        }
    }

    public String getResult() {
        return result;
    }
}