package ua.logic.teamDev.states;


import ua.logic.teamDev.Context;

public class JumpForward implements State {
    @Override
    public void action(Context context) {
        context.jumpForward();
    }
}
