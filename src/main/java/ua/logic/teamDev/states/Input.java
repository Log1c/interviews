package ua.logic.teamDev.states;


import ua.logic.teamDev.Context;

public class Input implements State {
    @Override
    public void action(Context context) {
        context.input();
    }
}
