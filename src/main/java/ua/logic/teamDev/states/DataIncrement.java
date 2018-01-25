package ua.logic.teamDev.states;


import ua.logic.teamDev.Context;

public class DataIncrement implements State{
    @Override
    public void action(Context context) {
        context.dataIncrement();
    }
}
