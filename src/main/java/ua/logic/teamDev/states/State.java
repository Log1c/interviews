package ua.logic.teamDev.states;

import ua.logic.teamDev.Context;

public interface State {
    String ceilIncrement = ">";
    String ceilDecrement = "<";
    String dataIncrement = "+";
    String dataDecrement = "-";
    String input = ",";
    String output = ".";
    String jumpForward = "[";
    String jumpBack = "]";

    void action(Context context);
}
