package ua.logic.teamDev.states;


import ua.logic.teamDev.Context;

public class CeilIncrement implements State {
    @Override
    public void action(Context context) {
        context.incrementIndex();
    }
}
